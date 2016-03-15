package com.demo.websocket.objectmapper.module;

import java.util.HashMap;
import java.util.Map;

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
