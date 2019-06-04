package com.example.hp.bb.entities;

import java.awt.Graphics;

import com.example.hp.bb.Handler;

public abstract class Entity {

	public static final int DEFAULT_HEALTH = 100;
	protected Handler handler;
	protected float x;
	protected float y;
	protected int width, height;

	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public abstract void tick();

	public abstract void render(Graphics g);
}
