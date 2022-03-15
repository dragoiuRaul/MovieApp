package ro.pex.movie.model.dto.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import ro.pex.movie.model.dto.response.utils.JsonNullValueToEmptyStringTagSerializer;


public class StatusDto {

	private Boolean success;
	private Integer httpCode;
	private String messageDescription;
	private String messageType;

	public StatusDto() {
		super();
	}

	/**
	 * @param success whether the status is successful or not
	 * @param httpCode the http code
	 * @param messageDescription the message description
	 * @param messageType the message type
	 */
	public StatusDto(Boolean success, Integer httpCode, String messageDescription,
			String messageType) {
		super();
		this.success = success;
		this.httpCode = httpCode;
		this.messageDescription = messageDescription;
		this.messageType = messageType;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Integer getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(Integer httpCode) {
		this.httpCode = httpCode;
	}


	@JsonSerialize(nullsUsing =  JsonNullValueToEmptyStringTagSerializer.class)
	public String getMessageDescription() {
		return messageDescription;
	}

	public void setMessageDescription(String messageDescription) {
		this.messageDescription = messageDescription;
	}

	@JsonSerialize(nullsUsing =  JsonNullValueToEmptyStringTagSerializer.class)
	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

}
