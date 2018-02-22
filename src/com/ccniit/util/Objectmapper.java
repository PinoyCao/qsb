package com.ccniit.util;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Objectmapper {
	private static ObjectMapper objectMapper=new ObjectMapper();


	public static ObjectMapper getObjectMapper() {
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		return objectMapper;
	}

	public static void setObjectMapper(ObjectMapper objectMapper) {
		Objectmapper.objectMapper = objectMapper;
	}
}
