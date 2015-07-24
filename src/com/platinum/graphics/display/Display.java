package com.platinum.graphics.display;


import com.platinum.Platbit;

import processing.core.PVector;
import processing.core.PApplet;

public class Display {
	

	private static PVector res;
	private static PVector ratio;
	private PApplet that;
	private static String renderType;
	
	
	
	public Display(PApplet g){
		res = new PVector(g.displayWidth, g.displayHeight);	
		this.that = g;
	}
	
	public Display(int x, int y, PApplet g){
		res = new PVector(x, y);
		this.that = g;
		
	}
	
	public void setSize(Platbit.renderTypes renderMode){
		switch(renderMode){
		case NATIVE:
			that.size((int) res.x, (int) res.y);
			renderType = null;
		case P2D:
			that.size((int) res.x, (int) res.y, PApplet.P2D);
			renderType = PApplet.P2D;
		case P3D:
			that.size((int) res.x, (int) res.y, PApplet.P3D);
			renderType = PApplet.P3D;
			
		}
		
		
	}
	
	
	public void getRatio(PVector nativeRes){
		Display.ratio = new PVector(Display.res.x/nativeRes.x, Display.res.y/nativeRes.y);
	}

	public static PVector getRes() {
		return res;
	}


	public static PVector getRatio() {
		return ratio;
	}
	
	public static PVector getPosFromFloat(PVector in){
		return new PVector(res.x * in.x, res.y * in.y);
		
	}
	
	public static String getRenderType(){
		return renderType;
	}

	
	

}
