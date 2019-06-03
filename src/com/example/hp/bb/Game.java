package com.example.hp.bb;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.example.hp.bb.display.Display;

public class Game implements Runnable {

	private String name;
	private int width, height;
	private Display display;
	private boolean running;

	private Thread thread;

	private BufferStrategy bs;
	private Graphics g;

	public Game(String name, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
		init();
	}

	private void init() {
		display = new Display(name, width, height);
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

	}

	public void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();

		// Draw Here
		g.fillRect(0, 0, width, height);

		bs.show();
		g.dispose();
	}

}
