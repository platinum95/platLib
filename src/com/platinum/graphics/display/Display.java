package com.platinum.graphics.display;


import com.platinum.Platbit;

import processing.core.PVector;
import processing.core.PApplet;

public class Display {
	

	private static PVector res = new PVector(0, 0);
	private static PVector ratio;
	private static String renderType;
	
	
	public Display(PApplet g){
		res = new PVector(g.displayWidth, g.displayHeight);	
	}
	
	public Display(int x, int y, PApplet g){
		res = new PVector(x, y);
		
	}
	
	
	public static void setSize(Platbit.renderTypes renderMode, PApplet g){
		switch(renderMode){
		case NATIVE:
			g.size((int) res.x, (int) res.y);
			renderType = null;
			break;
			
		case P2D:
			g.size((int) res.x, (int) res.y, PApplet.P2D);
			renderType = PApplet.P2D;
			break;
			
		case P3D:
			g.size((int) res.x, (int) res.y, PApplet.P3D);
			renderType = PApplet.P3D;
			break;
			
			
		}
		
		
	}

	
	public static void setRatio(PVector nativeRes){
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
	public static int getPosFromFloat(float in){
		return (int) (in * res.x);
		
	}
	
	public static String getRenderType(){
		return renderType;
	}
	
	public static void setRes(int x, int y){
		res = new PVector(x, y);
	}
	public static void setRes(PApplet g){
		res = new PVector(g.displayWidth, g.displayHeight);
	}
	

	
	

}
