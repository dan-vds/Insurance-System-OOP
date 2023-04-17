package nz.ac.auckland.se281;

public class Policy {
  private int policyID;
  private int sum;
  private static int nextID = 0;
  private double basePremium = 0.0;

  public Policy(int sum) {
    this.sum = sum;
    this.policyID = nextID++;
  }
}
