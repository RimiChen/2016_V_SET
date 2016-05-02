package Conditions;

import java.awt.Color;

import javax.swing.JButton;

import Variables.GlobalV;



@SuppressWarnings("serial")
public class StoryCondition  extends JButton{
	int locationX;
	int locationY;
	int sizeX;
	int sizeY;
	
	int depth;
	int index;
	
	public String variable;
	public String operator;
	public String value;	
	
	public int nextPage;
	public int nextEventIndex;
	public String eventName;
	
	String name;
	
	StoryConditionAction act;
	
	public  StoryCondition(int LocationX, int LocationY, int SizeX, int SizeY, int Depth, int ConditionIndex){
		this.locationX = LocationX;
		this.locationY = LocationY;
		this.sizeX = SizeX;
		this.sizeY = SizeY;
		this.depth = Depth;
		this.index = Depth;
		this.name = "Condition"+ConditionIndex;

		setBackground(new Color(148, 249, 255,255));
		act = new StoryConditionAction();
		
		addActionListener(act);
		
		setText(name);
		setLocation(locationX, locationY);
		setSize(sizeX, sizeY);
		
		variable = "Test";
		operator = ">";
		value =""+ConditionIndex;	
		
		nextPage = GlobalV.CurrentEdittingPage;
		nextEventIndex =1;
		
		
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