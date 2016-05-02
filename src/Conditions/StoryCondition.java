package Conditions;

import java.awt.Color;

import javax.swing.JButton;



@SuppressWarnings("serial")
public class StoryCondition  extends JButton{
	int locationX;
	int locationY;
	int sizeX;
	int sizeY;
	
	int depth;
	int index;
	
	int page;
	String name;
	
	//StoryConditionAction act;
	
	public  StoryCondition(int LocationX, int LocationY, int SizeX, int SizeY, int Depth, int ConditionIndex){
		this.locationX = LocationX;
		this.locationY = LocationY;
		this.sizeX = SizeX;
		this.sizeY = SizeY;
		this.depth = Depth;
		this.index = Depth;
		this.name = "Condition"+ConditionIndex;

		setBackground(new Color(148, 249, 255,255));
		//act = new EventButtonAction();
		
		//addActionListener(act);
		
		setText(name);
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