package com.platinum.graphics.modules;

import java.util.ArrayList;
import java.util.List;

import com.platinum.graphics.display.Display;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PVector;

public class Table extends Module{
	
	private int rows, columns;
	private List<Integer> rowsList, columnsList;
	private List<ArrayList<String>> vals;
	private String[][] values;
	private PGraphics table;

	
	
	public Table(PVector pos, PVector size, int rows, int columns, PApplet that){
		values = new String[rows][columns];
		this.pos = new PVector(Display.getPosFromFloat(pos.x), Display.getPosFromFloat(pos.y));
		this.size = new PVector(Display.getPosFromFloat(size.x), Display.getPosFromFloat(size.y));
		this.rows = rows;
		this.columns = columns;
		System.out.println("size/rows: " + (this.size.y/this.rows));
		table = that.createGraphics((int) this.size.x + 1, (int) this.size.y + 1);
		
		table.beginDraw();
		table.stroke(0);
		table.strokeWeight(1f);
		table.noFill();
		table.rect(0, 0, this.size.x, this.size.y);
		for(int i = 1; i < rows; i++){
			int y = (int) (i *  (this.size.y/this.rows));
			System.out.println("i" + i + ". y: " + y);
			table.line(0, y, this.size.x, y);
		}
		for(int i = 1; i < columns; i++){
			int x = (int) (i *  (this.size.x/this.columns));
			table.line(x, 0, x, this.size.y);
		}
		table.endDraw();
		
		
		
		
	}
	
	public Table(PVector pos, PVector size, PApplet that){
		values = new String[rows][columns];
		this.pos = new PVector(Display.getPosFromFloat(pos.x), Display.getPosFromFloat(pos.y));
		this.size = new PVector(Display.getPosFromFloat(size.x), Display.getPosFromFloat(size.y));
		table = that.createGraphics((int) this.size.x + 1, (int) this.size.y + 1);
		this.rowsList = new ArrayList<Integer>();
		this.columnsList = new ArrayList<Integer>();
		this.vals = new ArrayList<ArrayList<String>>();
	}
	
	public void addRow(float height){
		this.rowsList.add(getHeightFromFloat(height));		
	}
	public void addEvenRows(int amount){
		int y = (int) (this.size.y / amount);
		for(int i = 0; i <= amount; i++){
			this.rowsList.add(y);
		}
	}
	
	public void addColumn(float width){
		this.columnsList.add(getWidthFromFloat(width));
	}
	
	public void updateTable(){

		this.table.beginDraw();
		table.stroke(0);
		table.strokeWeight(1f);
		table.noFill();
		table.rect(0, 0, this.size.x, this.size.y);
		table.pushMatrix();
		for(Integer r: rowsList){
			table.translate(0, r);
			table.line(0, 0, this.size.x, 0);
		}
		table.popMatrix();
		table.pushMatrix();
		for(Integer c: columnsList){
			table.translate(c, 0);
			table.line(0, 0, 0, this.size.y);
			//System.out.println("drawing cols from 0, 0 to 0," + this.size.y);
		}
		table.popMatrix();
		table.endDraw();
		
		
	}
	
	@Override
	public void draw(PApplet g) {
		g.imageMode(PApplet.CORNER);
		g.image(table, this.pos.x, this.pos.y);
		
	}
	
	public PGraphics getTable(){
		return this.table;
	}
	
	public PVector getPos(){
		return this.pos;
	}

	public String getValues(int i, int j){
		return this.values[i][j];
	}
	public void setValues(int i, int j, String val){
		this.values[i][j] = val;
	}
	
	public int getRows(){
		return this.rows;
	}
	public int getColumns(){
		return this.columns;
	}
	
	private int getWidthFromFloat(float in){
		return (int) (this.size.x * in);
	}	
	
	private int getHeightFromFloat(float in){
		return (int) (this.size.y * in);
	}	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void update(PApplet g) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onMousePressed(PApplet g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMouseReleased(PApplet g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMouseDragged(PApplet g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMouseClicked(PApplet g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMouseMoved(PApplet g) {
		// TODO Auto-generated method stub
		
	}


}
