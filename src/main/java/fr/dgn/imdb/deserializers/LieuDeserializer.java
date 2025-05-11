package fr.dgn.imdb.deserializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import fr.dgn.imdb.dtos.LieuDto;

public class LieuDeserializer extends StdDeserializer<LieuDto>{

	/** serialVersionUID */
	private static final long serialVersionUID = -1631845126075919578L;

	public LieuDeserializer() {
		super(Double.class);
	}

	@Override
	public LieuDto deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		String value = p.readValueAs(String.class);
		String[] elts = value.split(",", -1);
		String ville = "";
		String region = "";
		String pays = "";
		
		if (elts.length==2) {
			ville = elts[0];
			pays= elts[1];
		}
		else if (elts.length==3) {
			ville = elts[0];
			region = elts[1];
			pays = elts[2];
		}
		else if (elts.length>3) {
			for (int i=0; i<elts.length-2; i++) {
				ville+=elts[i];
			}
			region = elts[elts.length-2];
			pays = elts[elts.length-1];
		}
		LieuDto lieu = new LieuDto();
		lieu.setVille(ville);
		lieu.setEtatDept(region);
		lieu.setPays(pays);
		return lieu;
	}

}
