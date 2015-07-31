package com.platinum.graphics.modules;

import com.platinum.graphics.colour.Colour;
import com.platinum.graphics.display.Display;
import com.platinum.mouse.MouseTracker;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import processing.core.PVector;

public class Button extends Module{
	
	
	public enum shape{
		CIRCLE, ELLIPSE, SQUARE, RECTANGLE, IMAGE
	}
	
	private shape type;
	private MouseTracker tracker;
//	private boolean state;
	
	public Button(String name, shape type, PVector pos, PVector size, Colour colour, PFont fIn, PApplet g){
		super();
		int i = 0;
		this.name = name;
		this.type = type;
		this.pos = Display.getPosFromFloat(pos);
		this.size = Display.getPosFromFloat(size);
		this.colour = colour;
		this.state = false;
		this.tracker = new MouseTracker();
		this.f = fIn;
		this.buttonGraphic = g.createGraphics((int) this.size.x, (int) this.size.y, Display.getRenderType());
		this.buttonGraphic.beginDraw();
		this.buttonGraphic.stroke(0);
		this.buttonGraphic.fill(colour.R, colour.G, colour.B, colour.A);
		this.buttonGraphic.textFont(f, i);
		
		while(i < this.size.y * 0.8 && this.buttonGraphic.textWidth(this.name) < this.size.x * 0.9f)
			i++;
		this.buttonGraphic.textFont(f, i);
		this.buttonGraphic.textAlign(PApplet.CENTER, PApplet.CENTER);
		
		switch(type){
		
		case SQUARE:
			this.buttonGraphic.rect(0, 0, this.size.x, this.size.x);
			this.buttonGraphic.fill(0);
			this.buttonGraphic.text(this.name, this.size.x/2, this.size.x/2);
			this.buttonGraphic.noFill();
			break;
			
		case RECTANGLE:
			this.buttonGraphic.rect(0, 0, this.size.x, this.size.y);
			this.buttonGraphic.fill(0);
			this.buttonGraphic.text(this.name, this.size.x/2, this.size.y/2);
			this.buttonGraphic.noFill();
			break;
		case CIRCLE:
			this.buttonGraphic.ellipse(this.buttonGraphic.width/2, this.buttonGraphic.height/2, this.size.x, this.size.x);
			break;
		case ELLIPSE:
			this.buttonGraphic.ellipse(this.buttonGraphic.width/2, this.buttonGraphic.height/2, this.size.x, this.size.y);
			break;
		case IMAGE:
			System.out.println("Error: Use other function");
			break;	
		}
		this.buttonGraphic.noStroke();
		this.buttonGraphic.noFill();
		this.buttonGraphic.endDraw();
		this.lock = true;
		
		
	}
	
	public Button(String name, PVector pos, PVector size, String img, Colour tint, PApplet g){
		super();
		this.name = name;
		this.type = shape.IMAGE;
		this.pos = Display.getPosFromFloat(pos);
		this.size = Display.getPosFromFloat(size);
		this.colour = tint;
		this.tracker = new MouseTracker();
		PImage Img = g.loadImage(img);		
		
		this.buttonGraphic = g.createGraphics((int) this.size.x, (int) this.size.y, Display.getRenderType());
		this.buttonGraphic.beginDraw();
		this.buttonGraphic.tint(colour.R, colour.G, colour.B, colour.A);
		this.buttonGraphic.image(Img, 0, 0, buttonGraphic.width, buttonGraphic.height);
		this.buttonGraphic.noTint();
		this.buttonGraphic.endDraw();
		
		this.lock = true;
		
	}
	public Button(String name, PVector pos, PVector size, String img, PApplet g){
		super();
		this.name = name;
		this.type = shape.IMAGE;
		this.pos = Display.getPosFromFloat(pos);
		this.size = Display.getPosFromFloat(size);
		this.tracker = new MouseTracker();
		PImage Img = g.loadImage(img);		
		
		this.buttonGraphic = g.createGraphics((int) this.size.x, (int) this.size.y, Display.getRenderType());
		this.buttonGraphic.beginDraw();
		this.buttonGraphic.image(Img, 0, 0, buttonGraphic.width, buttonGraphic.height);
		this.buttonGraphic.endDraw();	
		
		this.lock = true;
	}
	
	public Button(String name, PVector pos, String img, PApplet g){
		super();
		this.name = name;
		this.type = shape.IMAGE;
		this.pos = Display.getPosFromFloat(pos);
		PImage Img = g.loadImage(img);		
		this.size = new PVector(Img.width * Display.getRatio().x, Img.height * Display.getRatio().y);
		this.tracker = new MouseTracker();
		
		
		this.buttonGraphic = g.createGraphics((int) this.size.x, (int) this.size.y, Display.getRenderType());
		this.buttonGraphic.beginDraw();
		this.buttonGraphic.image(Img, 0, 0, buttonGraphic.width, buttonGraphic.height);
		this.buttonGraphic.endDraw();	
		
		this.lock = true;
		
	}
	
	

	@Override
	public void draw(PApplet that) {
		
		this.checkDrawn = that.frameCount;
		that.imageMode(PApplet.CENTER);
		that.image(this.buttonGraphic, this.pos.x, this.pos.y);
		that.imageMode(PApplet.CORNER);
	//	System.out.println(this.checkDrawn);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PApplet g) {
		this.tracker.setHovering(this.contains(g.mouseX, g.mouseY));
		
	}
	

	
	
	public shape getType(){
		return type;
	}

	public boolean getState(){
		return state;
	}
	

	@Override
	public void onMousePressed(PApplet g) {
		this.tracker.setDown(this.contains(g.mouseX, g.mouseY));

				
	}

	@Override
	public void onMouseReleased(PApplet g) {
		if(this.tracker.isDown() && checkDrawn == g.frameCount && !this.lock){
			this.state = !this.state;
			System.out.println("Button: " + this.name + ". state: " + this.state + ". framecount: " + g.frameCount);
		}
		
	}

	@Override
	public void onMouseDragged(PApplet g) {
		this.tracker.setDown(this.contains(g.mouseX, g.mouseY));
		this.update(g);
	}

	@Override
	public void onMouseClicked(PApplet g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMouseMoved(PApplet g) {
		this.update(g);
		
	}
	
}

	