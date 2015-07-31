package com.platinum;

import java.util.ArrayList;
import java.util.List;

import com.platinum.graphics.display.Display;
import com.platinum.graphics.manipulation.Manipulations;
import com.platinum.mouse.MouseListener;
import com.platinum.sound.Sound;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class Platbit extends PApplet{

	/**
	 *  Initial declarations and stuff
	 */
	
	private static final long serialVersionUID = 1L;//6202239234304283752L;

	private List<MouseListener> listeners;
	private List<Sound> sounds;
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
		Display.setRes(x, y);
	}
	
	public void initDisplay(){								//initialise display with native screen res
		Display.setRes(this);
	}
	
	
	public void setRatio(int x, int y){								//get ratio of current screen res to other res for future scaling
		Display.setRatio(new PVector(x, y));
	}
	
	public void setSize(renderTypes renderMode, PApplet g){
		Display.setSize(renderMode, g);
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
	
	/*
	 * Sound stuff
	 */
	public void newSound(String loc, String name){
		if(sounds == null)
			sounds = new ArrayList<Sound>();
		sounds.add(new Sound(loc, name)); 
		
	}
	public void playSound(String name){
		for(Sound s: sounds){
			if(name == s.getName()){
				s.play();
			}
			else{
				System.out.println("Unknown sound");
				return;
			}
		}
	}
	
	/*
	 * For mouse clicks
	 */
	@Override
	public void mousePressed()
	{
		for(MouseListener l : listeners)
		{
			l.onMousePressed(this);
		}		
	}
	
	@Override
	public void mouseDragged()
	{
		for(MouseListener l : listeners)
		{
			l.onMouseDragged(this);
		}	
	}
	
	@Override
	public void mouseReleased()
	{
		for(MouseListener l : listeners)
		{
			l.onMouseReleased(this);
		}	
	}
	
	@Override
	public void mouseMoved()
	{
		for(MouseListener l : listeners)
		{
			l.onMouseMoved(this);
		}	
	}
}
