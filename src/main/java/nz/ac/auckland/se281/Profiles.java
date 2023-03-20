package nz.ac.auckland.se281;

public class Profiles {
  // Defining instance variables for the class Profiles
  private String username;
  private String age;

  public Profiles(String un, String a) {
    // Defining constructor
    username = un;
    age = a;
  }

  public String getUsername() {
    // Getter method to give access to usernames
    String name = username;
    return name;
  }

  public String getAge() {
    // Getter method to give access to age
    String old = age;
    return old;
  }
}
