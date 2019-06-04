package com.example.hp.bb;

import com.example.hp.bb.input.KeyManager;

public class Handler {

	private Game game;

	public Handler(Game game) {
		this.game = game;
	}

	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}

}
