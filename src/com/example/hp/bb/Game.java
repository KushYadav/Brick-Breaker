package com.example.hp.bb;

import com.example.hp.bb.display.Display;

public class Game {

	private String name;
	private int width, height;
	private Display display;

	public Game(String name, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
		init();
	}

	private void init() {
		display = new Display(name, width, height);
	}

}
