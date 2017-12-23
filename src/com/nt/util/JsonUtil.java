package com.nt.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


public class JsonUtil {

	static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();
	}

	public static String convertJavaToJson(Object obj)
			throws JsonGenerationException, JsonMappingException, IOException {
		return mapper.writeValueAsString(obj);
	}

	public static <T> T convertJsonToJava(String jsonStr, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {
		
		return mapper.readValue(jsonStr, clazz);
	}

}
