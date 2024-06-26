package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  private ArrayList<Profiles> profileDatabase = new ArrayList<>();
  private ArrayList<Policy> policyDatabase = new ArrayList<>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  // define method to get the profile instance from the ID alone
  public Profiles getProfileFromID(int profileId) {
    for (Profiles profile : profileDatabase) {
      if (profile.getProfileId() == profileId) {
        return profile;
      }
    }
    return null;
  }

  // define method to apply the discounts to peoples premiums
  public int getDiscountedPremium(int profileId, Policy policy) {
    int discountedPremium = (int) policy.getBasePremium();
    Profiles profile = getProfileFromID(profileId);
    if (profile.getPolicyCount() == 2) {
      discountedPremium = (int) (policy.getBasePremium() * 0.9);
    }
    if (profile.getPolicyCount() >= 3) {
      discountedPremium = (int) (policy.getBasePremium() * 0.8);
    }
    return discountedPremium;
  }

  // define method to caluculate the total cost of all policies for a given profile
  public int getTotalCost(int profileId) {
    int totalCost = 0;
    for (Policy policy : policyDatabase) {
      if (policy.getPolicyId() == profileId) {
        totalCost += getDiscountedPremium(profileId, policy);
      }
    }
    return totalCost;
  }

  // define method which prints all of the policies for a particular person
  public void printPolicies(int profileId) {
    for (Policy policy : policyDatabase) {
      if (policy.getPolicyId() == profileId) {
        if (policy.getPolicyType() == PolicyType.CAR) {
          MessageCli.PRINT_DB_CAR_POLICY.printMessage(
              ((CarPolicy) policy).getMakeAndModel(),
              String.valueOf(policy.getSum()),
              String.valueOf(policy.getBasePremium()),
              String.valueOf(getDiscountedPremium(profileId, policy)));
        } else if (policy.getPolicyType() == PolicyType.HOME) {
          MessageCli.PRINT_DB_HOME_POLICY.printMessage(
              ((HomePolicy) policy).getAddress(),
              String.valueOf(policy.getSum()),
              String.valueOf(policy.getBasePremium()),
              String.valueOf(getDiscountedPremium(profileId, policy)));
        } else if (policy.getPolicyType() == PolicyType.LIFE) {
          MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
              String.valueOf(policy.getSum()),
              String.valueOf(policy.getBasePremium()),
              String.valueOf(getDiscountedPremium(profileId, policy)));
        }
      }
    }
  }

  public void printDatabase() {
    // Checking if the database has no entries
    if (profileDatabase.size() == 0) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
    } else if (profileDatabase.size() == 1) {
      // This runs if the database has one entry
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", "", ":");
      String plural = "ies";
      if (profileDatabase.get(0).getPolicyCount() == 1) {
        plural = "y";
      }
      if (profileDatabase.get(0).getLoaded() == true) {
        MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
            "*** ",
            "1",
            (profileDatabase.get(0)).getUsername(),
            (profileDatabase.get(0)).getAge(),
            String.valueOf(profileDatabase.get(0).getPolicyCount()),
            plural,
            String.valueOf(getTotalCost(profileDatabase.get(0).getProfileId())));
        printPolicies(profileDatabase.get(0).getProfileId());
      } else {
        MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
            "",
            "1",
            (profileDatabase.get(0)).getUsername(),
            (profileDatabase.get(0)).getAge(),
            String.valueOf(profileDatabase.get(0).getPolicyCount()),
            plural,
            String.valueOf(getTotalCost(profileDatabase.get(0).getProfileId())));
        printPolicies(profileDatabase.get(0).getProfileId());
      }
    } else {
      // This runs if the database has more than one entry
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(
          Integer.toString(profileDatabase.size()), "s", ":");
      for (int i = 0; i < profileDatabase.size(); i++) {
        String plural = "ies";
        if (profileDatabase.get(i).getPolicyCount() == 1) {
          plural = "y";
        }
        // Looping through every database entry in order and printing it
        if (profileDatabase.get(i).getLoaded() == true) {
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "*** ",
              Integer.toString(i + 1),
              (profileDatabase.get(i)).getUsername(),
              (profileDatabase.get(i)).getAge(),
              String.valueOf(profileDatabase.get(i).getPolicyCount()),
              plural,
              String.valueOf(getTotalCost(profileDatabase.get(i).getProfileId())));
          printPolicies(profileDatabase.get(i).getProfileId());
        } else {
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "",
              Integer.toString(i + 1),
              (profileDatabase.get(i)).getUsername(),
              (profileDatabase.get(i)).getAge(),
              String.valueOf(profileDatabase.get(i).getPolicyCount()),
              plural,
              String.valueOf(getTotalCost(profileDatabase.get(i).getProfileId())));
          printPolicies(profileDatabase.get(i).getProfileId());
        }
      }
    }
  }

  public void createNewProfile(String userName, String age) {
    // Converting the username to title case
    userName = userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
    // Defining checking variable to check whether the username is unique
    int uniqueCheck = 0;
    Profiles loadedProfile = null;
    // Checking if the age is an int
    try {
      if (Integer.parseInt(age) < 0) {
        MessageCli.INVALID_AGE.printMessage(age, userName);
        return;
      }
    } catch (NumberFormatException e) {
      MessageCli.INVALID_AGE.printMessage(age, userName);
      return;
    }

    for (int i = 0; i < profileDatabase.size(); i++) {
      if (userName.equals(profileDatabase.get(i).getUsername())) {
        // If username is not unique, set uniqueCheck to 1
        uniqueCheck++;
      }
      if (profileDatabase.get(i).getLoaded() == true) {
        loadedProfile = profileDatabase.get(i);
      }
    }
    if (loadedProfile != null) {
      // If a profile is loaded, return error
      MessageCli.CANNOT_CREATE_WHILE_LOADED.printMessage(loadedProfile.getUsername());
    } else if (uniqueCheck != 0) {
      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
    } else if (userName.length() < 3) {
      // If username is too short, return error
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
    } else {
      // Otherwise create a profile
      Profiles userProfile = new Profiles(userName, age);
      profileDatabase.add(userProfile);
      MessageCli.PROFILE_CREATED.printMessage(userName, age);
    }
  }

  public void loadProfile(String userName) {
    // convert username to title case
    userName = userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
    Profiles currentLoaded = null;
    Profiles toLoad = null;
    // loop through database to find any currently loaded profiles, or the profile to load
    for (Profiles profile : profileDatabase) {
      if (profile.getLoaded() == true) {
        currentLoaded = profile;
      }
      if (profile.getUsername().equals(userName)) {
        toLoad = profile;
      }
    }
    if (toLoad == null) {
      MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(userName);
    } else {
      if (currentLoaded == null) {
        toLoad.loadProfile();
        MessageCli.PROFILE_LOADED.printMessage(userName);
      } else {
        currentLoaded.unloadProfile();
        toLoad.loadProfile();
        MessageCli.PROFILE_LOADED.printMessage(userName);
      }
    }
  }

  public void unloadProfile() {
    // loop through database to find any currently loaded profiles, and unload. Otherwise print
    // error
    for (Profiles profile : profileDatabase) {
      if (profile.getLoaded() == true) {
        profile.unloadProfile();
        MessageCli.PROFILE_UNLOADED.printMessage(profile.getUsername());
        return;
      }
    }
    MessageCli.NO_PROFILE_LOADED.printMessage();
  }

  public void deleteProfile(String userName) {
    // convert username to title case
    userName = userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
    // loop to find the profile to delete, and delete it if it is not loaded. Otherwise print error
    for (Profiles profile : profileDatabase) {
      if (profile.getUsername().equals(userName)) {
        if (profile.getLoaded() == false) {
          profileDatabase.remove(profile);
          MessageCli.PROFILE_DELETED.printMessage(profile.getUsername());
          return;
        } else {
          MessageCli.CANNOT_DELETE_PROFILE_WHILE_LOADED.printMessage(profile.getUsername());
          return;
        }
      }
    }
    MessageCli.NO_PROFILE_FOUND_TO_DELETE.printMessage(userName);
  }

  public void createPolicy(PolicyType type, String[] options) {
    // set sum to the first element in option, and loop through database to find the currently
    // loaded profile
    int sum = Integer.parseInt(options[0]);
    Profiles currentLoaded = null;
    for (Profiles profile : profileDatabase) {
      if (profile.getLoaded() == true) {
        currentLoaded = profile;
      }
    }
    if (currentLoaded == null) {
      // if no profile is loaded, print error
      MessageCli.NO_PROFILE_FOUND_TO_CREATE_POLICY.printMessage();
      return;
    } else {
      if (type == PolicyType.HOME) {
        // if the policy is a home policy, create a home policy object and add it to the database
        String address = options[1];
        Boolean rental = false;
        if ((options[2].toLowerCase()).contains("y")) {
          rental = true;
        }
        HomePolicy homePolicy =
            new HomePolicy(type, sum, currentLoaded.getProfileId(), address, rental);
        MessageCli.NEW_POLICY_CREATED.printMessage("home", currentLoaded.getUsername());
        policyDatabase.add(homePolicy);
        currentLoaded.addPolicy();
      } else if (type == PolicyType.CAR) {
        // if the policy is a car policy, create a car policy object and add it to the database
        String makeAndModel = options[1];
        String licensePlate = options[2];
        Boolean breakdown = false;
        if ((options[3].toLowerCase()).contains("y")) {
          breakdown = true;
        }
        CarPolicy carPolicy =
            new CarPolicy(
                type,
                sum,
                currentLoaded.getProfileId(),
                makeAndModel,
                licensePlate,
                breakdown,
                Integer.parseInt(currentLoaded.getAge()));
        MessageCli.NEW_POLICY_CREATED.printMessage("car", currentLoaded.getUsername());
        policyDatabase.add(carPolicy);
        currentLoaded.addPolicy();
      } else if (type == PolicyType.LIFE) {
        // if the policy is a life policy, create a life policy object and add it to the database
        if (Integer.parseInt(currentLoaded.getAge()) > 100) {
          MessageCli.OVER_AGE_LIMIT_LIFE_POLICY.printMessage(currentLoaded.getUsername());
          return;
        } else {
          for (Policy policy : policyDatabase) {
            if (policy.getPolicyType() == PolicyType.LIFE) {
              if (policy.getPolicyId() == currentLoaded.getProfileId()) {
                MessageCli.ALREADY_HAS_LIFE_POLICY.printMessage(currentLoaded.getUsername());
                return;
              }
            }
          }
          LifePolicy lifePolicy =
              new LifePolicy(
                  type,
                  sum,
                  currentLoaded.getProfileId(),
                  Integer.parseInt(currentLoaded.getAge()));
          MessageCli.NEW_POLICY_CREATED.printMessage("life", currentLoaded.getUsername());
          currentLoaded.addPolicy();
          policyDatabase.add(lifePolicy);
        }
      }
    }
  }
}
