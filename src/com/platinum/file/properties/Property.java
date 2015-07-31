package com.platinum.file.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Property {
	private Properties prop;
	private OutputStream output;
	private InputStream input;
	private String name, loc;
	private Map props;
	
	public Property(String name, String loc, boolean out){
		try {
			output = new FileOutputStream(loc + name);
		} catch (FileNotFoundException e) {
			System.out.println("Invalid properties location for " + name);
		}
		
		prop = new Properties();
		
	
		
	}
	
	public Property(String name, String loc){
		this.name = name;
		this.loc = loc;
		this.props = new HashMap<String, String>();
		this.prop = new Properties();
		try{
			input = new FileInputStream(loc + name);
			prop.load(input);
		} catch(FileNotFoundException e){
			System.out.println("File " + loc + name + " not found.");
		} catch (IOException e) {
			System.out.println("Error: IOException for property " + name);
		}
	}
	
	public Properties getProperty(){
		return this.prop;
	}
	
	public void addToProperty(String field, String value){
		
	}
	
	public void addToProperty(String field, int value){
		
	}
	
	public void addToProperty(String field, float value){
		
	}

}
