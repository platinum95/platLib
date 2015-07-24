package com.platinum.graphics.manipulation;

import com.platinum.Platbit;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.opengl.PShader;

public class Blurise {
	private static PShader blur;
	
	
	protected static void setBlur(PApplet that){
		Blurise.blur = that.loadShader("res/shaders/blur.glsl");
		
	}
	
	public static final PGraphics blurise(PGraphics src, float sigma, int size, PApplet that){
		
		PGraphics pass1, pass2;
		pass1 = that.createGraphics(src.width, src.height, Platbit.P2D);
		pass1.noSmooth();
		pass2 = that.createGraphics(src.width, src.height, Platbit.P2D);
		pass2.noSmooth();
		blur.set("blurSize", 20);
		blur.set("sigma", 10.0f);
		
		blur.set("horizontalPass", 0);
		pass1.beginDraw();            
		pass1.shader(blur);  
		pass1.image(src, 0, 0);
		pass1.endDraw();
		  
		 // Applying the blur shader along the horizontal direction      
		blur.set("horizontalPass", 1);
		pass2.beginDraw();            
		pass2.shader(blur);  
		pass2.image(pass1, 0, 0);
		pass2.endDraw();   
		 
		
		
		return pass2;
	}
	
	

}
