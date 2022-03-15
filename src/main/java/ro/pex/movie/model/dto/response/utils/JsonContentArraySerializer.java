package ro.pex.movie.model.dto.response.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


/**
 * Serializer class used for always transforming the tag "content" into an array tag. This class can be used as annotation in the get method of the field.
 */
public class JsonContentArraySerializer extends JsonSerializer<Object> {
	public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		JsonNode actualObj = objectMapper.convertValue(value, JsonNode.class);

		if (actualObj.isArray())
			jgen.writeObject(value);
		else {
			jgen.writeStartArray();
			jgen.writeObject(value);
			jgen.writeEndArray();
		}

	}
}