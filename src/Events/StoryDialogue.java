package Events;

import java.awt.Color;
import java.awt.Component;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JPanel;

import FunctionActions.DialogueCharaAction;
import Variables.LookUp;

public class StoryDialogue extends JPanel{
	int locationX;
	int locationY;
	int sizeX;
	int sizeY;
	int depth;
	public Map<Integer, Component> map;
	
	public int index;
	
	public String charaName;
	public int tempCharaIndex;
	
	public int charaIndex;
	public String content;	
	
	public DialogueContentField contentBox;
	public SubLabel charaMenuLabel;
	public DialogueMenu charaNameList;
	public DialogueCharaAction act;
	
	public int dialogueIndex;
	
	public StoryDialogue(int LocationX, int LocationY, int SizeX, int SizeY, int Depth, int DialogueIndex){
		//System.out.println("Create a Dialogue" +LookUp.CharaMap.size() +", " +LookUp.CharaMap.get(1).index);
		
		this.locationX = LocationX;
		this.locationY = LocationY;
		this.sizeX = SizeX;
		this.sizeY = SizeY;
		this.depth = Depth;
		map = new TreeMap<Integer, Component>();
		this.dialogueIndex = DialogueIndex;
		
		setLayout(null);
		setLocation(locationX, locationY);
		setSize(sizeX, sizeY);
		
		//initial content
		content = "";
		charaIndex =LookUp.CharaMap.get(1).index;
		tempCharaIndex = LookUp.CharaMap.get(1).index;
		
		contentBox = new DialogueContentField(10, 10, this.getWidth()-130, this.getHeight()-20, 0);
		charaMenuLabel = new SubLabel(contentBox.getWidth()+20, 0, 100, 30, 1, "Character", new Color(0, 255, 255), true);
		charaNameList = new DialogueMenu(contentBox.getWidth()+20, 30, 100, this.getHeight()-30, 2, "Character", dialogueIndex, LookUp.CharaNameMap);
		act = new DialogueCharaAction(charaNameList, dialogueIndex);
		charaNameList.setAction(act);
		
		addToMap(contentBox.getDepth(), contentBox);
		addToMap(charaMenuLabel.getDepth(), charaMenuLabel);
		addToMap(charaNameList.getDepth(), charaNameList);
		addThings();
		
	}
	public void updateContent(){
		content = contentBox.getText();
	}
	public void updateContentBox(String input){
		contentBox.setText(input);
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
