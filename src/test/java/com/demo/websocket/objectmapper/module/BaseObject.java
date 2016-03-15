/*
 * @(#)BaseObject.java $version 2016年3月14日
 *
 * Copyright 2016 LINE Corporation. All rights Reserved. 
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.demo.websocket.objectmapper.module;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cn40085
 *
 */
public abstract class BaseObject {
	private Map<String, Object> extraData;

	public BaseObject() {
		this.extraData = new HashMap<String, Object>();
	}

	public Map<String, Object> getExtraData() {
		return extraData;
	}

	protected void add(String key, Object value) {
		extraData.put(key, value);
	}

}
