package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class LifePolicy extends Policy {

  public LifePolicy(PolicyType type, int sum, int policyId, int age) {
    // calling superconstructor
    super(type, sum, policyId);
    this.basePremium = (1 + ((double) age / 100)) / 100 * sum;
  }
}
