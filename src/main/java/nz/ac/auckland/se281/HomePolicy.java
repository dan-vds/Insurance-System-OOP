package nz.ac.auckland.se281;

public class HomePolicy extends Policy {

  private String address;
  private Boolean rental;

  public HomePolicy(int sum, int policyId, String address, Boolean rental) {
    super(sum, policyId);
    this.address = address;
    this.rental = rental;
  }
}
