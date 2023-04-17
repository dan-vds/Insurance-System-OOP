package nz.ac.auckland.se281;

public class CarPolicy extends Policy {

  private String makeAndModel;
  private String licensePlate;
  private Boolean breakdown;

  public CarPolicy(int sum, String makeAndModel, String licensePlate, Boolean breakdown) {
    super(sum);
    this.makeAndModel = makeAndModel;
    this.licensePlate = licensePlate;
    this.breakdown = breakdown;
  }
}
