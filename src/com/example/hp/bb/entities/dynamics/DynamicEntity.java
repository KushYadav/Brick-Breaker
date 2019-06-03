package com.example.hp.bb.entities.dynamics;

import java.awt.Graphics;

import com.example.hp.bb.Handler;
import com.example.hp.bb.entities.Entity;

public class DynamicEntity extends Entity {

	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_WIDTH = 32, DEFAULT_HEIGHT = 32;
	private float speed;

	public DynamicEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {

	}

}
