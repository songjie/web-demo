package com.demo.websocket.objectmapper.module;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class MixIn {

	@JsonAnySetter
	abstract void add(String key, Object value);
}
