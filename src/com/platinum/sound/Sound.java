package com.platinum.sound;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound implements Runnable{
	
	private Clip clip;
	private AudioInputStream sound;
	//private Thread play;
	private String name;
	
	public Sound(String fileName, String namme){
		//play = new Thread(this);
		this.name = namme;
		
		try{
			//soundFile = new File(fileName);
	
			sound = AudioSystem.getAudioInputStream(new BufferedInputStream(getClass().getResourceAsStream(fileName)));
			clip = AudioSystem.getClip();
			clip.open(sound);
			
			
			
		}
		 catch (MalformedURLException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Sound: Malformed URL: " + e);
	        }
	     catch (UnsupportedAudioFileException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Sound: Unsupported Audio File: " + e);
	        }
        catch (IOException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Sound: Input/Output Error: " + e);
	        }
        catch (LineUnavailableException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Sound: Line Unavailable Exception Error: " + e);
	        }
		
	}
	
	public void play(){
		if(!clip.isRunning()){
			//play.start();
			clip.setFramePosition(0);
			clip.start();
		}
		
	}
	
	public void loop(){
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop(){
		clip.stop();
	}

	@Override
	public void run() {
		clip.setFramePosition(0);
		clip.start();
		
	}
	
	public String getName(){
		return name;
	}
	
	public boolean isRunning(){
		return clip.isRunning();
	}
	

}

