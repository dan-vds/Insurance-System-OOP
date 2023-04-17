package nz.ac.auckland.se281;

public class CarPolicy extends Policy {

  private String makeAndModel;
  private String licensePlate;
  private Boolean breakdown;

  public CarPolicy(
      int sum, int policyId, String makeAndModel, String licensePlate, Boolean breakdown) {
    super(sum, policyId);
    this.makeAndModel = makeAndModel;
    this.licensePlate = licensePlate;
    this.breakdown = breakdown;
  }
}
