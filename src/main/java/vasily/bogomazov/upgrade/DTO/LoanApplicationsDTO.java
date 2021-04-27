package vasily.bogomazov.upgrade.DTO;

import java.util.Date;
import java.util.UUID;

public class LoanApplicationsDTO {
	
	private Long id;
	private UUID uuid;
	private String status;
	private String productType;
	private String sourceSystem;
	private String purpose;
	private Date createDate;
	private String offerAmount;
	private String initiator;
	
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
	public String getSourceSystem() {
		return sourceSystem;
	}
	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
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
	public String getOfferAmount() {
		return offerAmount;
	}
	public void setOfferAmount(String offerAmount) {
		this.offerAmount = offerAmount;
	}
	public String getInitiator() {
		return initiator;
	}
	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}

}
