package com.example.hp.bb.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys;
	public static boolean right, left, A, D;

	public KeyManager() {
		keys = new boolean[256];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	public void tick() {
		right = keys[KeyEvent.VK_RIGHT];
		left = keys[KeyEvent.VK_LEFT];
		A = keys[KeyEvent.VK_A];
		D = keys[KeyEvent.VK_D];
	}

}
