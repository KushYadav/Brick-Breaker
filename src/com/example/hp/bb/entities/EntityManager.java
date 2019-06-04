package com.example.hp.bb.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.example.hp.bb.Handler;
import com.example.hp.bb.entities.dynamics.Ball;
import com.example.hp.bb.entities.dynamics.HoverBoard;

public class EntityManager {

	private ArrayList<Entity> entities;
	private Handler handler;

	public EntityManager(Handler handler) {
		this.handler = handler;
		entities = new ArrayList<>();
	}

	public void tick() {
		HoverBoard hb = handler.getHoverBoard();
		Ball b = handler.getBall();
		for (int i = 2; i < entities.size(); i++) {
			entities.get(i).tick();

			Rectangle vertical = new Rectangle((int) (b.getX() + b.getWidth() * 7 / 16), (int) (b.getY()),
					b.getWidth() / 8, b.getHeight());
			Rectangle horizontal = new Rectangle((int) (b.getX()), (int) (b.getY() + b.getHeight() * 7 / 16),
					b.getWidth(), b.getHeight() / 16);

			Rectangle left = new Rectangle((int) (entities.get(i).getX()),
					(int) (entities.get(i).getY() + entities.get(i).height / 16), entities.get(i).getWidth() / 16,
					entities.get(i).getHeight() * 7 / 8);
			Rectangle right = new Rectangle((int) (entities.get(i).getX() + entities.get(i).getWidth() * 15 / 16),
					(int) (entities.get(i).getY() + entities.get(i).getHeight() / 16), entities.get(i).getWidth() / 16,
					entities.get(i).getHeight() * 7 / 8);
			Rectangle top = new Rectangle((int) (entities.get(i).getX() + entities.get(i).getWidth() / 16),
					(int) (entities.get(i).getY()), entities.get(i).getWidth() * 15 / 16,
					entities.get(i).getHeight() / 16);
			Rectangle bottom = new Rectangle((int) (entities.get(i).getX() + entities.get(i).getWidth() / 16),
					(int) (entities.get(i).getY() + entities.get(i).height * 15 / 16),
					entities.get(i).getWidth() * 7 / 8, entities.get(i).getHeight() / 16);

			if (vertical.intersects(top) || horizontal.intersects(top)) {
				b.setyMove(-b.getyMove());
				entities.remove(i);
			} else if (vertical.intersects(right) || horizontal.intersects(right)) {
				entities.remove(i);
				b.setxMove(-b.getxMove());
			} else if (vertical.intersects(bottom) || horizontal.intersects(bottom)) {
				entities.remove(i);
				b.setyMove(-b.getyMove());
			} else if (vertical.intersects(left) || horizontal.intersects(left)) {
				entities.remove(i);
				b.setxMove(-b.getxMove());
			}
		}
		if (b.getCollisionBounds().intersects(hb.getCollisionBounds())) {
			b.setyMove(-b.getyMove());
			b.setxMove(b.getxMove() / 2 + hb.getxMove() / 2);
		}
		b.tick();
		hb.tick();
	}

	public void render(Graphics g) {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(g);
		}
//		Ball b = handler.getBall();
//		for (int i = 2; i < entities.size(); i++) {
//			g.fillRect((int) (entities.get(i).getX() + entities.get(i).getWidth() * 15 / 16),
//					(int) (entities.get(i).getY() + entities.get(i).getHeight() / 16), entities.get(i).getWidth() / 16,
//					entities.get(i).getHeight() * 7 / 8);
//			g.fillRect((int) (entities.get(i).getX()), (int) (entities.get(i).getY() + entities.get(i).height / 16),
//					entities.get(i).getWidth() / 16, entities.get(i).getHeight() * 7 / 8);
//			g.fillRect((int) (entities.get(i).getX() + entities.get(i).getWidth() / 16), (int) (entities.get(i).getY()),
//					entities.get(i).getWidth() * 7 / 8, entities.get(i).getHeight() / 16);
//			g.fillRect((int) (entities.get(i).getX() + entities.get(i).getWidth() / 16),
//					(int) (entities.get(i).getY() + entities.get(i).height * 15 / 16),
//					entities.get(i).getWidth() * 7 / 8, entities.get(i).getHeight() / 16);
//			g.fillRect((int) (b.getX() + b.getWidth() * 15 / 32), (int) (b.getY()), b.getWidth() / 8, b.getHeight());
//			g.fillRect((int) (b.getX()), (int) (b.getY() + b.getHeight() * 15 / 32), b.getWidth(), b.getHeight() / 8);
//		} // Render Bounds
	}

	public void addEntity(Entity e) {
		entities.add(e);
	}

}
