package com.platinum.mouse;

public class MouseTracker {
	private boolean isHovering;
	private boolean isDown;
	private boolean enabled;
	
	public MouseTracker()
	{
		this.enabled = true;
		this.isDown = false;
		this.isHovering = false;
	}
	
	public boolean isDownAndHovering()
	{
		return isDown && isHovering;
	}
	
	public boolean isHovering()
	{
		return isHovering;
	}
	
	public boolean isDown()
	{
		return isDown;
	}
	
	public void setIdle()
	{
		this.isDown = false;
	}
	
	public void setDown(boolean b)
	{
		this.isDown = b;
	}
	
	public void setHovering(boolean b)
	{
		this.isHovering = b;
	}
	
	public void disable()
	{
		this.enabled = false;
	}
	
	public void enable()
	{
		this.enabled = true;
	}
	
	public boolean isEnabled()
	{
		return this.enabled;
	}
}
