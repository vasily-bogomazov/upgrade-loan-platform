package vasily.bogomazov.upgrade.DTO;

public class LoanOfferDTO {
	
	private	String approvedLoanAmount;
	private String monthlyPayment;
	private String term ;
	private String interestRate;
	private String apr;
	
	public String getApprovedLoanAmount() {
		return approvedLoanAmount;
	}
	public void setApprovedLoanAmount(String approvedLoanAmount) {
		this.approvedLoanAmount = approvedLoanAmount;
	}
	public String getMonthlyPayment() {
		return monthlyPayment;
	}
	public void setMonthlyPayment(String monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
	
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}
	public String getApr() {
		return apr;
	}
	public void setApr(String apr) {
		this.apr = apr;
	}
	
	
	@Override
	public String toString() {
		return "Stored values [approvedLoanAmount=" + approvedLoanAmount + ", monthlyPayment=" + monthlyPayment
				+ ", term=" + term + ", interestRate=" + interestRate + ", apr=" + apr + "]";
	}
	
	
	
	
	

}
