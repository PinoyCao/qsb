package com.ccniit.model;


public class Record{

	private Long id;
	private String cylinderId;
	private Integer userId;
	private Integer companyId;
	private String operation;
	private String operationNumber;
	private String description;
	private String date;

	public Long getId() {
		return id;
	}

	public String getCylinderId() {
		return cylinderId;
	}

	public int getUserId() {
		return userId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public String getOperation() {
		return operation;
	}

	public String getOperationNumber() {
		return operationNumber;
	}

	public String getDescription() {
		return description;
	}

	public String getDate() {
		return date;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCylinderId(String cylinderId) {
		this.cylinderId = cylinderId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**气瓶所在公司ID*/
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public void setOperationNumber(String operationNumber) {
		this.operationNumber = operationNumber;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Record [id=").append(id).append(", cylinderId=").append(cylinderId).append(", userId=")
				.append(userId).append(", companyId=").append(companyId).append(", operation=").append(operation)
				.append(", operationNumber=").append(operationNumber).append(", description=").append(description)
				.append(", date=").append(date).append("]");
		return builder.toString();
	}

}
