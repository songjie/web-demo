package com.demo.websocket.objectmapper.module;

import com.fasterxml.jackson.databind.module.SimpleModule;

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
