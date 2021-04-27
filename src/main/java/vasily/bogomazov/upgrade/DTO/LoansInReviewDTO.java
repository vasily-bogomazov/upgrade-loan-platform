package vasily.bogomazov.upgrade.DTO;

import java.util.Date;
import java.util.UUID;

public class LoansInReviewDTO {

	private Long id;
	private UUID uuid;
	private String status;
	private String productType;
	private String collateralDistributionType;
	private Boolean hasOpenBackendCounter;
	private String purpose;
	private Date createDate;
	private String postIssuanceStatus;
	private String addon;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getCollateralDistributionType() {
		return collateralDistributionType;
	}
	public void setCollateralDistributionType(String collateralDistributionType) {
		this.collateralDistributionType = collateralDistributionType;
	}
	public Boolean getHasOpenBackendCounter() {
		return hasOpenBackendCounter;
	}
	public void setHasOpenBackendCounter(Boolean hasOpenBackendCounter) {
		this.hasOpenBackendCounter = hasOpenBackendCounter;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getPostIssuanceStatus() {
		return postIssuanceStatus;
	}
	public void setPostIssuanceStatus(String postIssuanceStatus) {
		this.postIssuanceStatus = postIssuanceStatus;
	}
	public String getAddon() {
		return addon;
	}
	public void setAddon(String addon) {
		this.addon = addon;
	}
	
}
