package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  private ArrayList<Profiles> profileDatabase = new ArrayList<>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {
    if (profileDatabase.size() == 0) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
    } else if (profileDatabase.size() == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", "", ":");
      MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
          "1", (profileDatabase.get(0)).getUsername(), (profileDatabase.get(0)).getAge());
    } else {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(
          Integer.toString(profileDatabase.size()), "s", ":");
      for (int i = 0; i < profileDatabase.size(); i++) {
        MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
            Integer.toString(i + 1),
            (profileDatabase.get(i)).getUsername(),
            (profileDatabase.get(i)).getAge());
      }
    }
  }

  public void createNewProfile(String userName, String age) {
    Profiles userProfile = new Profiles(userName, age);
    profileDatabase.add(userProfile);
    MessageCli.PROFILE_CREATED.printMessage(userName, age);
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
