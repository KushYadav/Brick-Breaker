package com.example.hp.bb.worlds;

import java.awt.Graphics;

import com.example.hp.bb.Handler;
import com.example.hp.bb.entities.EntityManager;
import com.example.hp.bb.entities.dynamics.Ball;
import com.example.hp.bb.entities.dynamics.HoverBoard;

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
		hoverBoard = new HoverBoard(handler, 0, handler.getHeight() - 10, 100, 10);
		ball = new Ball(handler, 350, 550, 20, 20);
		entityManager.addEntity(hoverBoard);
		entityManager.addEntity(ball);
	}

	public void tick() {
		entityManager.tick();
	}

	public void render(Graphics g) {
		entityManager.render(g);
	}
}
