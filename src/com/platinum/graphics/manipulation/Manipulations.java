package com.platinum.graphics.manipulation;

import processing.core.PApplet;
import processing.core.PGraphics;

public abstract class Manipulations {
	
	
	public static void setUp(PApplet g){
		
		setBlurise(g);
	}
	
	private static void setBlurise(PApplet g){
		Blurise.setBlur(g);
		
	}
	
	public static PGraphics blurise(PGraphics src, float sigma, int size, PApplet that){
		return Blurise.blurise(src, sigma, size, that);
	}
	

}
