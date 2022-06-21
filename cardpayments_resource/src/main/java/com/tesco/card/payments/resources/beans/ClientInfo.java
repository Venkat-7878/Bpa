package com.tesco.card.payments.resources.beans;

public class ClientInfo {

	private String clientId;
	private String channelId;
	private String correlationId;
	private String messageTs;
	
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getCorrelationId() {
		return correlationId;
	}
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}
	public String getMessageTs() {
		return messageTs;
	}
	public void setMessageTs(String messageTs) {
		this.messageTs = messageTs;
	}
	
	@Override
	public String toString() {
		return "ClientInfo [clientId=" + clientId + ", channelId=" + channelId + ", correlationId=" + correlationId
				+ ", messageTs=" + messageTs + "]";
	}
}
