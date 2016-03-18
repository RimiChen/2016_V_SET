package Events;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import FunctionActions.EventButtonAction;

public class EventLabel extends JLabel{
	int locationX;
	int locationY;
	int sizeX;
	int sizeY;
	
	int depth;
	int index;
	int page;
	
	String name;
	
	
	public  EventLabel(int LocationX, int LocationY, int SizeX, int SizeY, int Depth, int page, String name, Color color){
		this.locationX = LocationX;
		this.locationY = LocationY;
		this.sizeX = SizeX;
		this.sizeY = SizeY;
		this.depth = Depth;
		this.index = Depth;
		this.page = page;
		this.name = name;
		
		
		setVisible(true);
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		setText(name);
		setBackground(color);
		setOpaque(true);
		setLocation(locationX, locationY);
		setSize(sizeX, sizeY);		
	}
	public void setDepth(int Depth){
		this.depth = Depth;
	}
	public int getDepth(){
		return depth;
	}
	public void updateName(String name){
		this.name = name;
	}	
	
}