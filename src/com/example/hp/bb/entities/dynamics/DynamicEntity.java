package com.example.hp.bb.entities.dynamics;

import java.awt.Graphics;

import com.example.hp.bb.Handler;
import com.example.hp.bb.entities.Entity;

public class DynamicEntity extends Entity {

	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_WIDTH = 32, DEFAULT_HEIGHT = 32;
	protected float speed;
	protected float xMove, yMove;
	protected int health;

	public DynamicEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		this.health = DEFAULT_HEALTH;
		this.speed = DEFAULT_SPEED;
		xMove = -5;
		yMove = -5;

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

}
