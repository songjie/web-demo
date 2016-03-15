/*
 * @(#)DeserializationTest.java $version 2016年3月14日
 *
 * Copyright 2016 LINE Corporation. All rights Reserved. 
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.demo.websocket.objectmapper;

import java.io.IOException;

import org.junit.Test;

import com.demo.websocket.objectmapper.module.MyModule;
import com.demo.websocket.objectmapper.module.Rectangle;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author cn40085
 *
 */
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
