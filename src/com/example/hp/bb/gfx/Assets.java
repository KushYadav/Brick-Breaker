package com.example.hp.bb.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static final int WIDTH = 32, HEIGHT = 32;
	public static BufferedImage[] tile;

	public static void init() {
		SpriteSheet tiles = new SpriteSheet(ImageLoader.loadImage("/textures/Tile.png"));
		tile = new BufferedImage[16];

		for (int i = 0; i < 16; i++) {
			tile[i] = tiles.crop(WIDTH * i, 0, WIDTH, HEIGHT);
		}
	}
}
