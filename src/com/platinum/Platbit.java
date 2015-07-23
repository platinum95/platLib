package com.platinum;

import com.platinum.graphics.display.Display;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class Platbit extends PApplet{

	/**
	 *  Initial declarations and stuff
	 */
	
	private static final long serialVersionUID = 1L;//6202239234304283752L;

	private Display disp;
	
	
	/*
	 * Display stuff
	 */
	
	public void initDisplay(int x, int y){							//initialise display with set res
		this.disp = new Display(x, y, this);
	}
	
	public void initDisplayNative(){								//initialise display with native screen res
		this.disp = new Display(this);
	}
	
	public void getRatio(int x, int y){								//get ratio of current screen res to other res for future scaling
		this.disp.getRatio(new PVector(x, y));
	}
	
	
	
}
