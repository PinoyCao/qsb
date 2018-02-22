package com.ccniit.model;
public class Cylinder {
	private static final long serialVersionUID = 1L;
	private String id;
	private String uid;
	private String companyId;	
	private String model;
	private String workingPressure;
	private String waterOverpressure;
	private String type;
	private String name;
	private String material;
	private Double volume;
	private String contentName;
	private String manufactureDate;
	private String manufacturingNumber;
	private String testCycle;
	private String serviceLife;
	private String productionUnitCode;
	private String productionUnitName;
	private String delFlag;
	private String location;
	private Double lng;
	private Double lat;
	private String lastModified;
	private String nextInspection;
	private String last_fill;
	private String state;
	private String lastInspectionFlag;
	private static Cylinder cylinder=new Cylinder();
	public static Cylinder getCylinder(){
		return cylinder;
	}
	public String getId() {
		return id;
	}

	public String getUid() {
		return uid;
	}

	public String getModel() {
		return model;
	}

	public String getWorkingPressure() {
		return workingPressure;
	}

	public String getWaterOverpressure() {
		return waterOverpressure;
	}

	public String getType() {
		return type;
	}

	public String getMaterial() {
		return material;
	}

	public Double getVolume() {
		return volume;
	}

	public String getContentName() {
		return contentName;
	}

	public String getManufactureDate() {
		return manufactureDate;
	}

	public String getManufacturingNumber() {
		return manufacturingNumber;
	}

	public String getTestCycle() {
		return testCycle;
	}

	public String getServiceLife() {
		return serviceLife;
	}

	public String getProductionUnitCode() {
		return productionUnitCode;
	}

	public String getProductionUnitName() {
		return productionUnitName;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public String getLocation() {
		return location;
	}

	public Double getLng() {
		return lng;
	}

	public Double getLat() {
		return lat;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setWorkingPressure(String workingPressure) {
		this.workingPressure = workingPressure;
	}

	public void setWaterOverpressure(String waterOverpressure) {
		this.waterOverpressure = waterOverpressure;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public void setManufacturingNumber(String manufacturingNumber) {
		this.manufacturingNumber = manufacturingNumber;
	}

	public void setTestCycle(String testCycle) {
		this.testCycle = testCycle;
	}

	public void setServiceLife(String serviceLife) {
		this.serviceLife = serviceLife;
	}

	public void setProductionUnitCode(String productionUnitCode) {
		this.productionUnitCode = productionUnitCode;
	}

	public void setProductionUnitName(String productionUnitName) {
		this.productionUnitName = productionUnitName;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	public void setLastFill(String lastFill) {
		this.last_fill = lastFill;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cylinder other = (Cylinder) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getNextInspection() {
		return nextInspection;
	}

	public void setNextInspection(String nextInspection) {
		this.nextInspection = nextInspection;
	}



	public String getLast_fill() {
		return last_fill;
	}

	public void setLast_fill(String last_fill) {
		this.last_fill = last_fill;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastInspectionFlag() {
		return lastInspectionFlag;
	}

	public void setLastInspectionFlag(String lastInspectionFlag) {
		this.lastInspectionFlag = lastInspectionFlag;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cylinder [id=");
		builder.append(id);
		builder.append(", uid=");
		builder.append(uid);
		builder.append(", companyId=");
		builder.append(companyId);
		builder.append(", model=");
		builder.append(model);
		builder.append(", workingPressure=");
		builder.append(workingPressure);
		builder.append(", waterOverpressure=");
		builder.append(waterOverpressure);
		builder.append(", type=");
		builder.append(type);
		builder.append(", name=");
		builder.append(name);
		builder.append(", material=");
		builder.append(material);
		builder.append(", volume=");
		builder.append(volume);
		builder.append(", contentName=");
		builder.append(contentName);
		builder.append(", manufactureDate=");
		builder.append(manufactureDate);
		builder.append(", manufacturingNumber=");
		builder.append(manufacturingNumber);
		builder.append(", testCycle=");
		builder.append(testCycle);
		builder.append(", serviceLife=");
		builder.append(serviceLife);
		builder.append(", productionUnitCode=");
		builder.append(productionUnitCode);
		builder.append(", productionUnitName=");
		builder.append(productionUnitName);
		builder.append(", delFlag=");
		builder.append(delFlag);
		builder.append(", location=");
		builder.append(location);
		builder.append(", lng=");
		builder.append(lng);
		builder.append(", lat=");
		builder.append(lat);
		builder.append(", lastModified=");
		builder.append(lastModified);
		builder.append(", nextInspection=");
		builder.append(nextInspection);
		builder.append(", last_fill=");
		builder.append(last_fill);
		builder.append(", state=");
		builder.append(state);
		builder.append(", lastInspectionFlag=");
		builder.append(lastInspectionFlag);
		builder.append("]");
		return builder.toString();
	}
	
}
