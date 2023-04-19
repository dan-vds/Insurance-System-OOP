package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public abstract class Policy {
  // defining instance variables for the class Policy that all subclasses have in common
  private int policyID;
  private int sum;
  private PolicyType type;
  protected double basePremium = 0.0;
  protected int totalCost = 0;
  protected double discountPremium = 0.0;

  // defining the superconstructor
  public Policy(PolicyType type, int sum, int policyID) {
    this.type = type;
    this.sum = sum;
    this.policyID = policyID;
  }

  // defining getter methods for the instance variables
  public PolicyType getPolicyType() {
    return type;
  }

  public int getPolicyId() {
    return policyID;
  }

  public int getSum() {
    return sum;
  }

  public int getBasePremium() {
    return (int) basePremium;
  }
}
