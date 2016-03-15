/*
 * @(#)RectangleMixIn.java $version 2016年3月14日
 *
 * Copyright 2016 LINE Corporation. All rights Reserved. 
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.demo.websocket.objectmapper.module;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author cn40085
 *
 */
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
