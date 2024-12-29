package com.offerpad.userEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "customerData")
public class Customer {
    @Id
    @NotBlank(message = "Customer ID cannot be blank")
    private String customerId;   

    @NotBlank(message = "Customer Name cannot be blank")
    private String customerName;

    private String description;
    private String memo;
    
    @NotBlank(message = "Customer Type cannot be blank")
    private String customerType;

    private String customerAgentName;
    private String customerAgentId;
    private String customeDocumentName;
    
    
    // Getters and Setters
    
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getCustomerAgentName() {
		return customerAgentName;
	}
	public void setCustomerAgentName(String customerAgentName) {
		this.customerAgentName = customerAgentName;
	}
	public String getCustomerAgentId() {
		return customerAgentId;
	}
	public void setCustomerAgentId(String customerAgentId) {
		this.customerAgentId = customerAgentId;
	}
	public String getCustomeDocumentName() {
		return customeDocumentName;
	}
	public void setCustomeDocumentName(String customeDocumentName) {
		this.customeDocumentName = customeDocumentName;
	}

   
}
