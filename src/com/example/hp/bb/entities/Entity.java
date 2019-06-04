package com.example.hp.bb.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.example.hp.bb.Handler;

public abstract class Entity {

	public static final int DEFAULT_HEALTH = 100;
	protected Handler handler;
	protected float x;
	protected float y;
	protected int width, height;
	protected Rectangle bounds;

	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public Rectangle getCollisionBounds() {
		return new Rectangle((int) x, (int) y, width, height);
	}

	public void showCollisionBounds(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect((int) x, (int) y, width, height);
	}
}
