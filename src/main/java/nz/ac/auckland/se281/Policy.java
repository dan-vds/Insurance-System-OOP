package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class Policy {
  private int policyID;
  private int sum;
  private PolicyType type;
  protected double basePremium = 0.0;

  public Policy(PolicyType type, int sum, int policyID) {
    this.type = type;
    this.sum = sum;
    this.policyID = policyID;
  }

  public PolicyType getPolicyType() {
    return type;
  }

  public int getPolicyId() {
    return policyID;
  }

  public String getSum() {
    return String.valueOf(sum);
  }

  public String getBasePremium() {
    return String.valueOf(basePremium);
  }
}
