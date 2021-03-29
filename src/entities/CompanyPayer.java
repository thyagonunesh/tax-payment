package entities;

public class CompanyPayer extends Payer{

	private Integer numberOfEmployees;
	
	public CompanyPayer() {
		super();
	}

	public CompanyPayer(String name, Double anualIncome, Integer numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public Double taxPayment() {
		if(numberOfEmployees > 10) {
			return getAnualIncome() * 14 / 100;
		} else {
			return getAnualIncome() * 16 / 100;
		}
	}

}
