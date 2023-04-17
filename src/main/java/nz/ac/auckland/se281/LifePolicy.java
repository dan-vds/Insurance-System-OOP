package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class LifePolicy extends Policy {
  private double basePremium = 0.0;
  private int age;

  public LifePolicy(PolicyType type, int sum, int policyId, int age) {
    super(type, sum, policyId);
    this.age = age;
    this.basePremium = (1 + (age / 100)) * sum;
  }
}
