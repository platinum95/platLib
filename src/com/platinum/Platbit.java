package com.platinum;

import java.util.ArrayList;
import java.util.List;

import com.platinum.graphics.display.Display;
import com.platinum.graphics.manipulation.Manipulations;
import com.platinum.mouse.MouseListener;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class Platbit extends PApplet{

	/**
	 *  Initial declarations and stuff
	 */
	
	private static final long serialVersionUID = 1L;//6202239234304283752L;

	private Display disp;
	private List<MouseListener> listeners;
	public enum renderTypes{
		NATIVE, P2D, P3D
	}
	
	public Platbit(){
		super();
		this.listeners = new ArrayList<MouseListener>();
	}
	
	/*
	 * Display stuff
	 */
	
	public void initDisplay(int x, int y){							//initialise display with set res
		this.disp = new Display(x, y, this);
	}
	
	public void initDisplayNative(){								//initialise display with native screen res
		this.disp = new Display(this);
	}
	
	public Display getDisplay(){
		return this.disp;
	}
	
	public void getRatio(int x, int y){								//get ratio of current screen res to other res for future scaling
		this.disp.getRatio(new PVector(x, y));
	}
	
	public void setSize(renderTypes renderMode){
		this.disp.setSize(renderMode);
	}
	
	/*
	 * 	Setup stuff to be done at some point
	 */
	
	public void setUp(){
		Manipulations.setUp(this);
	}
	
	
	/*
	 * Listener stuff
	 */
	public void registerListener(MouseListener l)
	{
		this.listeners.add(l);
	}
	
}
