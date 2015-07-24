package com.platinum.graphics.manipulation;

import processing.core.PApplet;

public abstract class Manipulations {
	
	
	public static void setUp(PApplet g){
		
		setBlurise(g);
	}
	
	private static void setBlurise(PApplet g){
		Blurise.setBlur(g);
		
	}
	

}
