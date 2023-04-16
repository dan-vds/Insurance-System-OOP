package nz.ac.auckland.se281;

public class Profiles {
  // Defining instance variables for the class Profiles
  private String username;
  private String age;
  private Boolean loaded;

  public Profiles(String un, String a) {
    // Defining constructor
    loaded = false;
    username = un;
    age = a;
  }

  public String getUsername() {
    // Getter method to give access to usernames
    String name = username;
    return name;
  }

  public Boolean getLoaded() {
    // Getter method to give access to loaded or not
    Boolean value = loaded;
    return value;
  }

  public void loadProfile() {
    // Setter method to load/unload
    this.loaded = true;
  }

  public void unloadProfile() {
    // Setter method to load/unload
    this.loaded = false;
  }

  public String getAge() {
    // Getter method to give access to age
    String old = age;
    return old;
  }
}
