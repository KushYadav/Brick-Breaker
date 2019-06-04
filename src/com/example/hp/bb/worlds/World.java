package com.example.hp.bb.worlds;

import java.awt.Graphics;

import com.example.hp.bb.Handler;
import com.example.hp.bb.entities.EntityManager;
import com.example.hp.bb.entities.dynamics.Ball;
import com.example.hp.bb.entities.dynamics.DynamicEntity;
import com.example.hp.bb.entities.dynamics.HoverBoard;
import com.example.hp.bb.entities.statics.Brick;
import com.example.hp.bb.tiles.Tile;

public class World {

	private HoverBoard hoverBoard;
	private Ball ball;
	private Handler handler;
	private EntityManager entityManager;

	public World(Handler handler) {
		this.handler = handler;
		entityManager = new EntityManager(handler);
		init();
	}

	public void init() {
		hoverBoard = new HoverBoard(handler, handler.getWidth() / 2, handler.getHeight() - 10, 200, 10);
		ball = new Ball(handler, 350, 650, 20, 20);
		entityManager.addEntity(hoverBoard);
		entityManager.addEntity(ball);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++) {
				entityManager.addEntity(new Brick(handler, 30 + Tile.DEFAULT_WIDTH * i, 30 + Tile.DEFAULT_HEIGHT * j,
						Tile.DEFAULT_WIDTH, Tile.DEFAULT_HEIGHT));
			}
		}
	}

	public void tick() {
		entityManager.tick();
	}

	public void render(Graphics g) {
		entityManager.render(g);
	}

	public HoverBoard getHoverBoard() {
		return hoverBoard;
	}

	public Ball getBall() {
		return ball;
	}
}
