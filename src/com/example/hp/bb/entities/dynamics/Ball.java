package com.example.hp.bb.entities.dynamics;

import java.awt.Graphics;

import com.example.hp.bb.Handler;
import com.example.hp.bb.gfx.Assets;

public class Ball extends DynamicEntity {

	public Ball(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}

	public void tick() {
		getInput();
		move();
	}

	public void getInput() {

		if (x == 0 || x == handler.getWidth() - width) {
			xMove = -xMove;
		}
		if (y == 0 || y == handler.getHeight() - height) {
			yMove = -yMove;
		}
	}

	public void render(Graphics g) {
		g.drawImage(Assets.tile[14], (int) x, (int) y, width, height, null);
	}

}
