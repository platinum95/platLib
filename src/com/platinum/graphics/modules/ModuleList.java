package com.platinum.graphics.modules;

import java.util.ArrayList;
import java.util.List;


import com.platinum.Platbit;
import com.platinum.graphics.modules.Module;
import com.platinum.mouse.MouseListener;

import processing.core.PApplet;

public class ModuleList {
	
	private List<Module> moduleList;
	
	public ModuleList(){
		this.moduleList = new ArrayList<Module>();
	}
	
	public void addModule(Module m){
		this.moduleList.add(m);
	}
	
	public void draw(PApplet g){
		for(Module m: moduleList){
			m.update();
			m.draw(g);
			System.out.println("1");
		}
	}
	
	public void setMouseListener(int i, MouseListener listener)
	{
		this.moduleList.get(i).setListener(listener);
	}
	
	public Module getComponent(int i)
	{
		return this.moduleList.get(i);
	}
	
	public Module getComponent(String name)
	{
		for(Module m : moduleList)
		{
			if(m.getName() == name)
				return m;
		}
		return null;
	}
	public void registerModules(Platbit p){
		
		for(Module m : moduleList){
			p.registerListener(m);
		}
		
	}
 
}
