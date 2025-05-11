package fr.dgn.imdb.deserializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class AnneeSortieDeserializer extends StdDeserializer<Integer>{

	/** serialVersionUID */
	private static final long serialVersionUID = 8850848039828939708L;

	public AnneeSortieDeserializer() {
		super(Integer.class);
	}

	@Override
	public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		String value = p.readValueAs(String.class);
		if (value==null || value.trim().isEmpty()) {
			return 0;
		}
		if (value.contains("–")) {
			value = value.substring(value.indexOf('–')+1).trim();
		}
		return Integer.parseInt(value.replace(',', '.'));
	}

}
