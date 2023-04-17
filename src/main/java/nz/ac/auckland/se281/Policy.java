package nz.ac.auckland.se281;

public class Policy {
  private int policyID;
  private int sum;
  private double basePremium = 0.0;

  public Policy(int sum, int policyID) {
    this.sum = sum;
    this.policyID = policyID;
  }
}
