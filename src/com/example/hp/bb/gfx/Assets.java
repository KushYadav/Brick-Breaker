package com.example.hp.bb.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static final int WIDTH = 32, HEIGHT = 32;
	public static BufferedImage[] tile;
	public static BufferedImage ball, backs, brick;

	public static void init() {
		SpriteSheet tiles = new SpriteSheet(ImageLoader.loadImage("/textures/Tile.png"));
		SpriteSheet balls = new SpriteSheet(ImageLoader.loadImage("/textures/Ball.png"));
		SpriteSheet back = new SpriteSheet(ImageLoader.loadImage("/textures/A.png"));
		SpriteSheet bricks = new SpriteSheet(ImageLoader.loadImage("/textures/Brick.png"));
		tile = new BufferedImage[16];

		ball = balls.crop(WIDTH, 0, WIDTH, HEIGHT);
		backs = back.crop(0, 0, WIDTH * 4, HEIGHT * 4);
		brick = bricks.crop(0, 0, WIDTH, HEIGHT);
		for (int i = 0; i < 16; i++) {
			tile[i] = tiles.crop(WIDTH * i, 0, WIDTH, HEIGHT);
		}
	}
}
