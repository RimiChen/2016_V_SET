package Choices;

import java.awt.Color;
import java.awt.Component;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JPanel;


import Events.SubLabel;
import Events.SubTextField;


@SuppressWarnings("serial")
public class StoryChoice extends JPanel{
	int locationX;
	int locationY;
	int sizeX;
	int sizeY;
	int depth;
	
	public String variable;
	public String operator;
	public String value;
	public String content;
	
	public Map<Integer, Component> map;
	
	public int index;
	
	public int choiceIndex;
	
	public SubLabel ChoiceContent0;
	public SubTextField ChoiceContent;
	
	public SubLabel ChoiceVariable0;
	public SubTextField ChoiceVariable;
	
	public SubLabel ChoiceOper0;
	public SubTextField ChoiceOper;
	
	public SubLabel ChoiceValue0;
	public SubTextField ChoiceValue;
	
	public StoryChoice(int LocationX, int LocationY, int SizeX, int SizeY, int Depth, int ChoiceIndex){
		//System.out.println("Create a Dialogue" +LookUp.CharaMap.size() +", " +LookUp.CharaMap.get(1).index);
		
		this.locationX = LocationX;
		this.locationY = LocationY;
		this.sizeX = SizeX;
		this.sizeY = SizeY;
		this.depth = Depth;
		map = new TreeMap<Integer, Component>();
		this.choiceIndex = ChoiceIndex;
		
		setLayout(null);
		setLocation(locationX, locationY);
		setSize(sizeX, sizeY);

		ChoiceContent0 =  new SubLabel(0, 0, sizeX/4, sizeY/4, 0, "Choice Content", new Color(0, 255, 255, 125), true);
		ChoiceContent = new SubTextField(ChoiceContent0.getX(), sizeY/2, sizeX/4, sizeY/4, 1);
		
		ChoiceVariable0 = new SubLabel(ChoiceContent0.getX()+ChoiceContent0.getWidth(), 0, sizeX/4, sizeY/4, 2, "Influenced Variable", new Color(0, 255, 255, 125), true);

		ChoiceVariable = new SubTextField(ChoiceVariable0.getX(), sizeY/2, sizeX/4, sizeY/4, 3);
		
		ChoiceOper0 = new SubLabel(ChoiceVariable0.getX()+ChoiceVariable0.getWidth(), 0, sizeX/4, sizeY/4, 4, "Operator", new Color(0, 255, 255, 125), true);
		ChoiceOper= new SubTextField(ChoiceOper0.getX(), sizeY/2, sizeX/4, sizeY/4, 5);
		
		ChoiceValue0 = new SubLabel(ChoiceOper0.getX()+ChoiceOper0.getWidth(), 0, sizeX/4, sizeY/4, 6, "Value", new Color(0, 255, 255, 125), true);;
		ChoiceValue = new SubTextField(ChoiceValue0.getX(), sizeY/2, sizeX/4, sizeY/4, 7);
		
		
		addToMap(ChoiceContent0.getDepth(), ChoiceContent0);
		addToMap(ChoiceVariable0.getDepth(), ChoiceVariable0);
		addToMap(ChoiceOper0.getDepth(), ChoiceOper0);
		addToMap(ChoiceValue0.getDepth(), ChoiceValue0);
		
		addToMap(ChoiceContent.getDepth(), ChoiceContent);
		addToMap(ChoiceVariable.getDepth(), ChoiceVariable);
		addToMap(ChoiceOper.getDepth(), ChoiceOper);
		addToMap(ChoiceValue.getDepth(), ChoiceValue);		
		
		addThings();
		//setBackground(new Color(0, 0, 0));
		//setOpaque(true);
		//initial content
		
	}
	public void addThings(){
		Set<Integer> set=map.keySet();
		for(Object obj:set)
		{
			add(map.get(obj));
		}		
	}
	public void addToMap(int Depth, Component obj){
		map.put(Depth, obj);
	}
	
	public void setDepth(int Depth){
		this.depth = Depth;
	}
	public int getDepth(){
		return depth;
	}
		
}
