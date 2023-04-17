package nz.ac.auckland.se281;

public class CarPolicy extends Policy {

  private String makeAndModel;
  private String licensePlate;
  private Boolean breakdown;
  private double basePremium = 0.0;
  private int age;

  public CarPolicy(
      int sum, int policyId, String makeAndModel, String licensePlate, Boolean breakdown, int age) {
    super(sum, policyId);
    this.makeAndModel = makeAndModel;
    this.licensePlate = licensePlate;
    this.breakdown = breakdown;
    this.age = age;
  }
}
