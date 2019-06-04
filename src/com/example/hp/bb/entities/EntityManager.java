package com.example.hp.bb.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import com.example.hp.bb.Handler;

public class EntityManager {

	private ArrayList<Entity> entities;
	private Handler handler;

	public EntityManager(Handler handler) {
		this.handler = handler;
		entities = new ArrayList<>();
	}

	public void tick() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).tick();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(g);
		}
	}

	public void addEntity(Entity e) {
		entities.add(e);
	}

}
