package com.platinum.graphics.image;

import com.platinum.graphics.display.Display;

import processing.core.PApplet;
import processing.core.PVector;

public class Image extends ImgParent{

	
	public Image(String Img, PVector pos, float scale, PApplet g){	
		this.img = g.loadImage(Img);
		this.size = new PVector(img.width * scale, img.height * scale);
		this.pos = pos;
		setUp(g);
	}
	
	public Image(String Img, PVector pos, PVector size, PApplet g){	
		this.size = Display.getPosFromFloat(size);
		this.img = g.loadImage(Img);
		this.pos = pos;
		setUp(g);		
	}
	public Image(String Img, PVector pos, PApplet g){	
		this.img = g.loadImage(Img);
		this.size = new PVector(Display.getRatio().x * img.width, Display.getRatio().y * img.height);
		this.pos = pos;
		setUp(g);		
	}
	
	private void setUp(PApplet g){
		this.pos = Display.getPosFromFloat(pos);
		//this.pos.y = Display.getPosFromFloat(pos.y);
		this.ImgGraphics = g.createGraphics((int) this.size.x, (int) this.size.y, Display.getRenderType());
		this.ImgGraphics.beginDraw();
		this.ImgGraphics.image(this.img, 0, 0, this.size.x, this.size.y);
		this.ImgGraphics.endDraw();
		this.offset = new PVector(0, 0);
		this.offset2 = new PVector(0, 0);
	}
	
	
}
