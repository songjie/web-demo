/*
 * @(#)MixIn.java $version 2016年3月14日
 *
 * Copyright 2016 LINE Corporation. All rights Reserved. 
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.demo.websocket.objectmapper.module;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author cn40085
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class MixIn {

	@JsonAnySetter
	abstract void add(String key, Object value);
}
