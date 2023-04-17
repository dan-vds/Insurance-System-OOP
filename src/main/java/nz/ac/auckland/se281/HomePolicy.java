package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class HomePolicy extends Policy {

  private String address;
  private Boolean rental;
  private double basePremium = 0.0;

  public HomePolicy(PolicyType type, int sum, int policyId, String address, Boolean rental) {
    super(type, sum, policyId);
    this.address = address;
    this.rental = rental;
    if (rental == false) {
      this.basePremium = sum * 0.01;
    } else {
      this.basePremium = sum * 0.02;
    }
  }
}
