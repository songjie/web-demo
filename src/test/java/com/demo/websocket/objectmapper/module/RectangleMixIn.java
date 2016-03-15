package com.demo.websocket.objectmapper.module;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class RectangleMixIn extends MixIn {
	RectangleMixIn(@JsonProperty("width") int w, @JsonProperty("height") int h) {
	}

	@JsonProperty("width")
	abstract int getW();

	@JsonProperty("height")
	abstract int getH();

	@JsonIgnore
	abstract int getSize();

}
