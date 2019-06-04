package com.example.hp.bb.entities.statics;

import java.awt.Graphics;

import com.example.hp.bb.Handler;
import com.example.hp.bb.gfx.Assets;

public class Brick extends StaticEntity {

	public Brick(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);

	}

	public void tick() {

	}

	public void render(Graphics g) {
		g.drawImage(Assets.brick, (int) x, (int) y, width, height, null);
	}

}
