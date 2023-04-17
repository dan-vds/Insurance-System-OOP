package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class CarPolicy extends Policy {

  private String makeAndModel;
  private String licensePlate;
  private Boolean breakdown;
  private int age;

  public CarPolicy(
      PolicyType type,
      int sum,
      int policyId,
      String makeAndModel,
      String licensePlate,
      Boolean breakdown,
      int age) {
    super(type, sum, policyId);
    this.makeAndModel = makeAndModel;
    this.licensePlate = licensePlate;
    this.breakdown = breakdown;
    this.age = age;
    if (age < 25) {
      this.basePremium = sum * 0.15;
    } else {
      this.basePremium = sum * 0.1;
    }
    if (breakdown == true) {
      this.basePremium = this.basePremium + 80;
    }
  }

  public String getMakeAndModel() {
    return makeAndModel;
  }

  public String getLicensePlate() {
    return licensePlate;
  }

  public Boolean getBreakdown() {
    return breakdown;
  }

  public double getBasePremium() {
    return basePremium;
  }
}
