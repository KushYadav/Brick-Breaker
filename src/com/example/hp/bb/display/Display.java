package com.example.hp.bb.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {

	private String name;
	private int width, height;

	private JFrame frame;
	private Canvas canvas;

	public Display(String name, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
		createDisplay();
	}

	private void createDisplay() {
		frame = new JFrame(name);
		canvas = new Canvas();

		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		canvas.setSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		frame.add(canvas);
		frame.pack();
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

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

}
