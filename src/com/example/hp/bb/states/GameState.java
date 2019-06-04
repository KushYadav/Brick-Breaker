package com.example.hp.bb.states;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.example.hp.bb.Handler;
import com.example.hp.bb.gfx.Assets;
import com.example.hp.bb.input.KeyManager;
import com.example.hp.bb.worlds.World;

public class GameState extends State {

	private World world;
	private boolean running;

	public GameState(Handler handler) {
		super(handler);
		world = new World(handler);
		handler.setWorld(world);

	}

	@Override
	public void tick() {
		if (KeyManager.A && running == false) {

			running = true;
		}
		if (running) {
			world.tick();
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.backs, 0, 0, handler.getWidth(), handler.getHeight(), null);
		world.render(g);
	}

}
