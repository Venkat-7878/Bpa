package com.tesco.card.payments.resources.beans;

public class ServiceInfo {
	private String serviceName;
	private String apiName;
	private String version;
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "ServiceInfo [serviceName=" + serviceName + ", apiName=" + apiName + ", version=" + version + "]";
	}
	
}
