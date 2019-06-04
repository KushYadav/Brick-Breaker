package com.example.hp.bb.entities.dynamics;

import java.awt.Graphics;

import com.example.hp.bb.Handler;
import com.example.hp.bb.entities.Entity;

public class DynamicEntity extends Entity {

	public static final float DEFAULT_SPEED = 5.0f;
	public static final int DEFAULT_WIDTH = 32, DEFAULT_HEIGHT = 32;
	protected float speed;
	protected float xMove, yMove;
	protected int health;

	public DynamicEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		this.health = DEFAULT_HEALTH;
		this.speed = DEFAULT_SPEED;
		xMove = -speed;
		yMove = -speed;

	}

	public void move() {
		xMove();
		yMove();
	}

	public void xMove() {
		x += xMove;
	}

	public void yMove() {
		y += yMove;
	}

	@Override
	public void tick() {
		xMove();
	}

	@Override
	public void render(Graphics g) {

	}

	// Getters and Setters

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public static float getDefaultSpeed() {
		return DEFAULT_SPEED;
	}

	public static int getDefaultWidth() {
		return DEFAULT_WIDTH;
	}

	public static int getDefaultHeight() {
		return DEFAULT_HEIGHT;
	}

}
