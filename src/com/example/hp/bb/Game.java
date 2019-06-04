package com.example.hp.bb;

import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import com.example.hp.bb.display.Display;
import com.example.hp.bb.gfx.Assets;
import com.example.hp.bb.input.KeyManager;
import com.example.hp.bb.states.CurrentState;
import com.example.hp.bb.states.GameState;

public class Game implements Runnable {

	private String name;
	private int width, height;
	private Display display;
	private boolean running;

	private Thread thread;

	private BufferStrategy bs;
	private Graphics g;

	private Handler handler;
	private GameState gameState;

	private KeyManager keyManager;

	public Game(String name, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
		init();
	}

	private void init() {
		Assets.init();
		keyManager = new KeyManager();
		display = new Display(name, width, height);
		handler = new Handler(this);
		gameState = new GameState(handler);
		CurrentState.setCurrentState(gameState);
		display.getFrame().addKeyListener(keyManager);
		display.getCanvas().addKeyListener(keyManager);
	}

	@Override
	public void run() {
		int fps = 60;
		double timesPerTick = 1000000000 / fps;
		long lastTime = System.nanoTime();
		long now;
		double delta = 0;
		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timesPerTick;
			timer += (now - lastTime);
			lastTime = now;
			if (delta >= 1) {
				delta = 0;
				tick();
				render();
				ticks++;
			}
			if (timer >= 1000000000) {
				System.out.println("Ticks: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}

	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();

	}

	public synchronized void stop() {
		if (!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void tick() {
		keyManager.tick();
		if (CurrentState.getCurrentState() != null) {
			CurrentState.getCurrentState().tick();
		}

	}

	public void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);

		// Draw Here
		if (CurrentState.getCurrentState() != null) {
			CurrentState.getCurrentState().render(g);
		}

//		g.drawImage(Assets.tile[1], 0, 0, 100, 100, null);

		bs.show();
		g.dispose();
	}

	// Getters and Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public BufferStrategy getBs() {
		return bs;
	}

	public void setBs(BufferStrategy bs) {
		this.bs = bs;
	}

	public Graphics getG() {
		return g;
	}

	public void setG(Graphics g) {
		this.g = g;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public void setKeyManager(KeyManager keyManager) {
		this.keyManager = keyManager;
	}

}
