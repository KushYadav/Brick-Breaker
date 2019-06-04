package com.example.hp.bb.states;

import java.awt.Graphics;

import com.example.hp.bb.Handler;
import com.example.hp.bb.worlds.World;

public class GameState extends State {

	private World world;

	public GameState(Handler handler) {
		super(handler);
		world = new World(handler);
		handler.setWorld(world);

	}

	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}
