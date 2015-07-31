package com.platinum.graphics.image;

import processing.core.PGraphics;
import processing.core.PImage;
import processing.core.PVector;
import processing.core.PApplet;


public abstract class ImgParent {
	protected PVector pos, size, offset, offset2;
	protected float scale;
	protected PImage img;
	protected PGraphics ImgGraphics;
	
	public void draw(PApplet g){
		g.image(ImgGraphics, this.pos.x + this.offset.x + this.offset2.x, this.pos.y + this.offset.y + this.offset2.y);
	}
	
	public PGraphics getImage(){
		return this.ImgGraphics;
	}
	
	public PVector getPos(){
		return this.pos;
	}
	
	public PVector getOffset(){
		return this.offset;
	}
	
	public PVector getOffset2(){
		return this.offset2;
	}
	public PVector getOverallPos(){
		return new PVector(this.pos.x + this.offset.x + this.offset2.x, this.pos.y + this.offset.y + this.offset2.y);
	}
	
	public PVector getSize(){
		return this.size;
	}
	
	public void setPos(PVector posIn){
		this.pos = posIn;
	}
	
	public void setOffset(PVector posIn){
		this.offset = posIn;
	}
	
	public void setOffset2(PVector posIn){
		this.offset2 = posIn;
	}
}
