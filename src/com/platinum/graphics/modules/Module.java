package com.platinum.graphics.modules;

import com.platinum.mouse.MouseListener;
import com.platinum.graphics.colour.Colour;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PVector;



public abstract class Module implements MouseListener{
	
	protected String name;
	protected PVector pos;
	protected PVector size;
	protected Colour colour;
	protected PGraphics buttonGraphic;
	protected MouseListener listener;
	
	public Module(){
		this.listener = null;
	}
	
	
	protected void init(String s, PVector pos, PVector size, Colour c)
	{
		this.name = s;
		this.pos = pos;
		this.size = size;
		this.colour = c;
	}
	
	public boolean contains(PVector p)
	{
		return this.contains(p.x, p.y);
	}
	
	public boolean contains(float x, float y)
	{
		return pos.x <= x && pos.x + size.x > x && pos.y <= y && pos.y + size.y > y;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PVector getPos() {
		return pos;
	}
	public void setPos(PVector pos) {
		this.pos = pos;
	}
	public PVector getSize() {
		return size;
	}
	public void setSize(PVector size) {
		this.size = size;
	}
	
	public void setListener(MouseListener l){
		this.listener = l;
	}
	
	public MouseListener getListener(){
		return this.listener;
	}
	public Colour getColour() {
		return colour;
	}
	public void setColour(Colour colour) {
		this.colour = colour;
	}
	
	public abstract void draw(PApplet g);
	public abstract void update();
	public abstract void update(PApplet g);
	
	

}
