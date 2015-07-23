package com.platinum.graphics.display;


import processing.core.PVector;
import processing.core.PApplet;

public class Display {
	
	public static PVector res;
	public static PVector ratio;
	private PApplet that;
	
	public Display(PApplet g){
		res = new PVector(g.displayWidth, g.displayHeight);	
		this.that = g;
	}
	
	public Display(int x, int y, PApplet g){
		res = new PVector(x, y);
		this.that = g;
		
	}
	
	public void size(){
		that.size((int) res.x, (int) res.y);
	}
	
	public void sizeP2D(){
		that.size((int) res.x, (int) res.y, PApplet.P2D);
	}
	
	public void sizeP3D(){
		that.size((int) res.x, (int) res.y, PApplet.P3D);
	}
	
	public void getRatio(PVector nativeRes){
		Display.ratio = new PVector(Display.res.x/nativeRes.x, Display.res.y/nativeRes.y);
	}
	

}
