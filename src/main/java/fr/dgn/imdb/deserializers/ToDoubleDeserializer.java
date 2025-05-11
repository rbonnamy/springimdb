package fr.dgn.imdb.deserializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class ToDoubleDeserializer extends StdDeserializer<Double>{

	/** serialVersionUID */
	private static final long serialVersionUID = -6840032847683470934L;

	public ToDoubleDeserializer() {
		super(Double.class);
	}

	@Override
	public Double deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		String value = p.readValueAs(String.class);
		if (value==null || value.trim().isEmpty()) {
			return 0.0;
		}
		return Double.parseDouble(value.replace(',', '.'));
	}

}
