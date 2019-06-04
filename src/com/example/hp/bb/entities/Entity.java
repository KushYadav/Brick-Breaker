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

	public Rectangle predictCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int) (x + xOffset), (int) (y + yOffset), width, height);
	}

	// Getters and Setters

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public static int getDefaultHealth() {
		return DEFAULT_HEALTH;
	}
}
