package vasily.bogomazov.upgrade.DTO;

import java.util.List;
import java.util.UUID;

public class LoanResponse {

	private String firstName;
    private Long userId;
    private UUID userUuid;
    private String authenticationLevel;
    private List<Long> actorIds;
    private List<LoanApplicationsDTO> loanApplications;
    private List<LoansInReviewDTO> loansInReview;
    private List<LoanAccountSummaryAtoDTO> loanAccountSummaryAto;
    
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public UUID getUserUuid() {
		return userUuid;
	}
	public void setUserUuid(UUID userUuid) {
		this.userUuid = userUuid;
	}
	public String getAuthenticationLevel() {
		return authenticationLevel;
	}
	public void setAuthenticationLevel(String authenticationLevel) {
		this.authenticationLevel = authenticationLevel;
	}
	public List<Long> getActorIds() {
		return actorIds;
	}
	public void setActorIds(List<Long> actorIds) {
		this.actorIds = actorIds;
	}
	public List<LoanApplicationsDTO> getLoanApplications() {
		return loanApplications;
	}
	public void setLoanApplications(List<LoanApplicationsDTO> loanApplications) {
		this.loanApplications = loanApplications;
	}
	public List<LoansInReviewDTO> getLoansInReview() {
		return loansInReview;
	}
	public void setLoansInReview(List<LoansInReviewDTO> loansInReview) {
		this.loansInReview = loansInReview;
	}
	public List<LoanAccountSummaryAtoDTO> getLoanAccountSummaryAto() {
		return loanAccountSummaryAto;
	}
	public void setLoanAccountSummaryAto(List<LoanAccountSummaryAtoDTO> loanAccountSummaryAto) {
		this.loanAccountSummaryAto = loanAccountSummaryAto;
	}
	
	
	
	
}
