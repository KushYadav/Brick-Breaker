package com.example.hp.bb.states;

import java.awt.Graphics;

import com.example.hp.bb.Handler;
import com.example.hp.bb.entities.dynamics.HoverBoard;
import com.example.hp.bb.tiles.Tile;

public class GameState extends State {

	private HoverBoard hoverBoard;

	public GameState(Handler handler) {
		super(handler);
		hoverBoard = new HoverBoard(handler, 0, 0, 50, 50);
	}

	@Override
	public void tick() {
		hoverBoard.tick();
	}

	@Override
	public void render(Graphics g) {
		hoverBoard.render(g);
		Tile.orangeTile.render(g, 0, 400);
	}

}
