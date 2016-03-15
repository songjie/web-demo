/*
 * @(#)Rectangle.java $version 2016年3月14日
 *
 * Copyright 2016 LINE Corporation. All rights Reserved. 
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.demo.websocket.objectmapper.module;

/**
 * @author cn40085
 *
 */
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
