package com.platinum.graphics.modules;

import com.platinum.mouse.MouseListener;
import com.platinum.graphics.colour.Colour;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PGraphics;
import processing.core.PVector;



public abstract class Module implements MouseListener{
	
	protected String name;
	protected PVector pos;
	protected PVector size;
	protected Colour colour;
	protected PGraphics buttonGraphic;
	protected MouseListener listener;
	protected boolean state, isShown, lock;
	protected int checkDrawn;
	protected PFont f;
	
	
	public Module(){
		this.listener = null;
	}
	
	
	protected void init(String s, PVector pos, PVector size, Colour c)
	{
		this.name = s;
		this.pos = pos;
		this.size = size;
		this.colour = c;
		this.state = false;
		checkDrawn = 0;
	}
	
	public boolean contains(PVector p)
	{
		return this.contains(p.x, p.y);
	}
	
	public boolean contains(float x, float y)
	{
		return pos.x - size.x/2 <= x && pos.x + size.x/2 > x && pos.y - size.y/2 <= y && pos.y + size.y/2 > y;
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
	public boolean getState(){
		return state;
	}
	public boolean getLock(){
		return this.lock;
	}
	public void setLock(boolean in){
		this.lock = in;
	}
	
	public abstract void draw(PApplet g);
	public abstract void update();
	public abstract void update(PApplet g);


	public void setState(boolean b) {
		this.state = b;
		
	}
	
	

}
