package com.example.hp.bb.entities.dynamics;

import java.awt.Graphics;

import com.example.hp.bb.Handler;
import com.example.hp.bb.gfx.Assets;

public class HoverBoard extends DynamicEntity {

	public HoverBoard(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}

	public void tick() {

	}

	public void render(Graphics g) {
		g.drawImage(Assets.tile[4], (int) x, (int) y, width, height, null);
	}
}
