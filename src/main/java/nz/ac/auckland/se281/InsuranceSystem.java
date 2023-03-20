package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  private ArrayList<Profiles> profileDatabase = new ArrayList<>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {
    // Checking if the database has no entries
    if (profileDatabase.size() == 0) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
    } else if (profileDatabase.size() == 1) {
      // This runs if the database has one entry
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", "", ":");
      MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
          "1", (profileDatabase.get(0)).getUsername(), (profileDatabase.get(0)).getAge());
    } else {
      // This runs if the databse has more than one entry
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(
          Integer.toString(profileDatabase.size()), "s", ":");
      for (int i = 0; i < profileDatabase.size(); i++) {
        // Looping through every database entry in order and printing it
        MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
            Integer.toString(i + 1),
            (profileDatabase.get(i)).getUsername(),
            (profileDatabase.get(i)).getAge());
      }
    }
  }

  public void createNewProfile(String userName, String age) {
    // Converting the username to title case
    userName = userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
    // Defining checking variable to check whether the username is unique
    int uniqueCheck = 0;
    for (int i = 0; i < profileDatabase.size(); i++) {
      if (userName.equals(profileDatabase.get(i).getUsername())) {
        // If username is not unique, set uniqueCheck to 1
        uniqueCheck++;
      }
    }
    if (uniqueCheck != 0) {
      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
    } else if (userName.length() < 3) {
      // If username is too short, return error
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
    } else if (Integer.valueOf(age) < 0) {
      // If age is negative, return error
      MessageCli.INVALID_AGE.printMessage(age, userName);
    } else {
      // Otherwise create a profile
      Profiles userProfile = new Profiles(userName, age);
      profileDatabase.add(userProfile);
      MessageCli.PROFILE_CREATED.printMessage(userName, age);
    }
  }

  public void loadProfile(String userName) {
    // TODO: Complete this method.
  }

  public void unloadProfile() {
    // TODO: Complete this method.
  }

  public void deleteProfile(String userName) {
    // TODO: Complete this method.
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }
}
