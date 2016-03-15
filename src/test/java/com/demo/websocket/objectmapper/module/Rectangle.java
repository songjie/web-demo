package com.demo.websocket.objectmapper.module;

public class Rectangle extends BaseObject {
	final private int w, h;

	public Rectangle(int w, int h) {
		this.w = w;
		this.h = h;
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

	public int getSize() {
		return w * h;
	}
}
