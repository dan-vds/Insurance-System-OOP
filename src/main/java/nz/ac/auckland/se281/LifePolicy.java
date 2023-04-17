package nz.ac.auckland.se281;

public class LifePolicy extends Policy {
  private double basePremium = 0.0;
  private int age;

  public LifePolicy(int sum, int policyId, int age) {
    super(sum, policyId);
    this.age = age;
    this.basePremium = (1 + (age / 100)) * sum;
  }
}
