package com.platinum.graphics.modules;

import com.platinum.graphics.colour.Colour;
import com.platinum.graphics.display.Display;
import com.platinum.mouse.MouseTracker;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Button extends Module{
	
	
	public enum shape{
		CIRCLE, ELLIPSE, SQUARE, RECTANGLE, IMAGE
	}
	
	private shape type;
	private MouseTracker tracker;
	private boolean state;
	
	public Button(String name, shape type, PVector pos, PVector size, Colour colour, PApplet g){
		super();
		this.name = name;
		this.type = type;
		this.pos = Display.getPosFromFloat(pos);
		this.size = Display.getPosFromFloat(size);
		this.colour = colour;
		
		
		this.buttonGraphic = g.createGraphics((int) this.size.x, (int) this.size.y, Display.getRenderType());
		this.buttonGraphic.beginDraw();
		this.buttonGraphic.stroke(0);
		this.buttonGraphic.fill(colour.R, colour.G, colour.B, colour.A);
		
		switch(type){
		
		case SQUARE:
			this.buttonGraphic.rect(this.pos.x, this.pos.y, this.size.x, this.size.x);
			
		case RECTANGLE:
			this.buttonGraphic.rect(this.pos.x, this.pos.y, this.size.x, this.size.y);
			
		case CIRCLE:
			this.buttonGraphic.ellipse(pos.x, pos.y, this.size.x, this.size.x);
		
		case ELLIPSE:
			this.buttonGraphic.ellipse(this.pos.x, this.pos.y, this.size.x, this.size.y);
		case IMAGE:
			System.out.println("Error: Use other function");
			
			
		
		}
		this.buttonGraphic.noStroke();
		this.buttonGraphic.noFill();
		this.buttonGraphic.endDraw();
		
		
	}
	
	public Button(String name, PVector pos, PVector size, String img, Colour tint, PApplet g){
		super();
		this.name = name;
		this.type = shape.IMAGE;
		this.pos = Display.getPosFromFloat(pos);
		this.size = Display.getPosFromFloat(size);
		this.colour = tint;
		
		PImage Img = g.loadImage(img);		
		
		this.buttonGraphic = g.createGraphics((int) this.size.x, (int) this.size.y, Display.getRenderType());
		this.buttonGraphic.beginDraw();
		this.buttonGraphic.tint(colour.R, colour.G, colour.B, colour.A);
		this.buttonGraphic.image(Img, 0, 0, buttonGraphic.width, buttonGraphic.height);
		this.buttonGraphic.noTint();
		this.buttonGraphic.endDraw();
		
		
		
	}
	
	

	@Override
	public void draw(PApplet that) {
		System.out.println("2");
		
		that.imageMode(PApplet.CENTER);
		that.image(this.buttonGraphic, this.pos.x, this.pos.y);
		that.imageMode(PApplet.CORNER);
		
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

	

	@Override
	public void onMousePressed(PApplet g) {
		this.tracker.setDown(this.contains(g.mouseX, g.mouseY));
				
	}

	@Override
	public void onMouseReleased(PApplet g) {
		if(this.tracker.isDown()){
			this.state = !this.state;
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

	