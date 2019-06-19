package it.protectid.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

/**
 * @author clod16
 */
public class Converter {

	private final static Logger log = LogManager.getLogger(Converter.class);


	public static String objectToJson(Object object) throws Exception {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE); //This property put data in upper camel case
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
			throw new Exception(e);
		}
	}

	public static Object jsonToObject(String json, Class c) throws Exception {
		try {
			if (StringUtils.isEmpty(json))
				throw new Exception("Json data is EMPTY");
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
			return mapper.readValue(json, c);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception(e);
		}
	}
}
