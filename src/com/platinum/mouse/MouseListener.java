package com.platinum.mouse;

import processing.core.PApplet;

public interface MouseListener {
	public void onMousePressed(PApplet g);
	public void onMouseReleased(PApplet g);
	public void onMouseDragged(PApplet g);
	public void onMouseClicked(PApplet g);
	public void onMouseMoved(PApplet g);
}
