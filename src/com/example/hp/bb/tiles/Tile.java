package com.example.hp.bb.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.example.hp.bb.gfx.Assets;

public class Tile {

	public static Tile[] tile = new Tile[256];
	public static Tile orangeTile = new Tile(Assets.tile[0], 0);

	public static final int DEFAULT_WIDTH = 32, DEFAULT_HEIGHT = 32;
	private BufferedImage texture;
	private int id;

	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		tile[id] = this;
	}

	public void tick() {

	}

	public void render(Graphics g, float x, float y) {
		g.drawImage(texture, (int) x, (int) y, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
	}

	public boolean isSolid() {
		return false;
	}

	public int getId() {
		return this.id;
	}
}
