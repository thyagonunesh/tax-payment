package entities;

public class IndividualPayer extends Payer {
	
	private Double healthExpenditure;
	
	public IndividualPayer() {
		super();
	}

	public IndividualPayer(String name, Double anualIncome, Double healthExpenditure) {
		super(name, anualIncome);
		this.healthExpenditure = healthExpenditure;
	}

	public Double getHealthExpenditure() {
		return healthExpenditure;
	}

	public void setHealthExpenditure(Double healthExpenditure) {
		this.healthExpenditure = healthExpenditure;
	}

	@Override
	public Double taxPayment() {
		if(getAnualIncome() < 20000) {
			return (getAnualIncome() * 15 / 100) - (healthExpenditure * 50 / 100);
		} else {
			return (getAnualIncome() * 25 / 100) - (healthExpenditure * 50 / 100);
		}
	}
	
}
