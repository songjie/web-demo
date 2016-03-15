package com.demo.websocket.objectmapper;

import java.io.IOException;

import org.junit.Test;

import com.demo.websocket.objectmapper.module.MyModule;
import com.demo.websocket.objectmapper.module.Rectangle;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserializationTest {
	@Test
	public void test() throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();

		objectMapper.registerModule(new MyModule());

		String str = objectMapper.writeValueAsString(new Rectangle(5, 10));
		System.out.println(str);
		Rectangle r = objectMapper.readValue(str, Rectangle.class);
		System.out.println("width:" + r.getW() + ", height:" + r.getH());

	}
}
