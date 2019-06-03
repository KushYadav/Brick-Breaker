package com.example.hp.bb.states;

import java.awt.Graphics;

import com.example.hp.bb.Handler;

public abstract class State {

	private Handler handler;

	public State(Handler handler) {
		this.handler = handler;
	}

	public abstract void tick();

	public abstract void render(Graphics g);

}
