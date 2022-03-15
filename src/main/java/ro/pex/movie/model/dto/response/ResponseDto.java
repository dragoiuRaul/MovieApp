package ro.pex.movie.model.dto.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import ro.pex.movie.model.dto.response.utils.JsonContentArraySerializer;
import ro.pex.movie.model.dto.response.utils.JsonNullArrayToEmptyArrayTagSerializer;
import ro.pex.movie.model.dto.response.utils.JsonNullValueToEmptyTagSerializer;

/**
 * Class that returns a custom HTTP Response, used in the API service.
 */
public class ResponseDto<T> {

	private StatusDto status;
	private T content;

	public ResponseDto() {
		super();
	}

	/**
	 * @param status
	 *            Status
	 * @param content
	 */
	public ResponseDto(StatusDto status, T content) {
		super();
		this.status = status;
		this.content = content;
	}

	@JsonSerialize(nullsUsing = JsonNullValueToEmptyTagSerializer.class)
	public StatusDto getStatus() {
		return status;
	}

	public void setStatus(StatusDto status) {
		this.status = status;
	}

	@JsonSerialize(nullsUsing =  JsonNullArrayToEmptyArrayTagSerializer.class, using = JsonContentArraySerializer.class)
	public T getContent() {
		return content;
	}

	public void setContent(T data) {
		this.content = data;
	}


}
