package vasily.bogomazov.upgrade.DTO;

public class LoanAccountSummaryAtoDTO {

	private String loanAccountNumber;
	private String postIssuanceLoanStatus;
	private Integer daysPastDue;
	private String loanProductType;
	
	public String getLoanAccountNumber() {
		return loanAccountNumber;
	}
	public void setLoanAccountNumber(String loanAccountNumber) {
		this.loanAccountNumber = loanAccountNumber;
	}
	public String getPostIssuanceLoanStatus() {
		return postIssuanceLoanStatus;
	}
	public void setPostIssuanceLoanStatus(String postIssuanceLoanStatus) {
		this.postIssuanceLoanStatus = postIssuanceLoanStatus;
	}
	public Integer getDaysPastDue() {
		return daysPastDue;
	}
	public void setDaysPastDue(Integer daysPastDue) {
		this.daysPastDue = daysPastDue;
	}
	public String getLoanProductType() {
		return loanProductType;
	}
	public void setLoanProductType(String loanProductType) {
		this.loanProductType = loanProductType;
	}
	
}
