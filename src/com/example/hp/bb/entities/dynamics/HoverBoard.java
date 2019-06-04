package com.example.hp.bb.entities.dynamics;

import java.awt.Graphics;

import com.example.hp.bb.Handler;
import com.example.hp.bb.gfx.Assets;
import com.example.hp.bb.input.KeyManager;

public class HoverBoard extends DynamicEntity {

	public HoverBoard(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}

	public void tick() {
		getInput();
		xMove();
	}

	private void getInput() {
		xMove = 0;
		if (KeyManager.A || KeyManager.left) {
			xMove = -speed;
		}
		if (KeyManager.D || KeyManager.right) {
			xMove = speed;
		}
	}

	public void render(Graphics g) {
		g.drawImage(Assets.brick, (int) x, (int) y, width, height, null);
	}
}
