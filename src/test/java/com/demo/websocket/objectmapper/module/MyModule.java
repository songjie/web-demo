/*
 * @(#)MyModule.java $version 2016年3月14日
 *
 * Copyright 2016 LINE Corporation. All rights Reserved. 
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.demo.websocket.objectmapper.module;

import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * @author cn40085
 *
 */
public class MyModule extends SimpleModule {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7367713650317324435L;

	public MyModule() {
		super("ModuleName");
	}

	@Override
	public void setupModule(SetupContext context) {
		context.setMixInAnnotations(Rectangle.class, RectangleMixIn.class);
	}
}
