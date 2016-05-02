package Events;

import java.awt.Component;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


import javax.swing.JTabbedPane;

import MainScreen.GroupFrame;

@SuppressWarnings("serial")
public class DialogueChoiceTabPanel  extends JTabbedPane{
	int locationX;
	int locationY;
	int sizeX;
	int sizeY;
	int depth;
	public Map<Integer, Component> map;
	public Map<Integer, String> mapName;
	
	public GroupFrame DialogueTab;
	public GroupFrame ChoiceTab;
	
	public DialogueChoiceTabPanel(int LocationX, int LocationY, int SizeX, int SizeY, int Depth){
		this.locationX = LocationX;
		this.locationY = LocationY;
		this.sizeX = SizeX;
		this.sizeY = SizeY;
		this.depth = Depth;
		map = new TreeMap<Integer, Component>();
		mapName = new TreeMap<Integer, String>();
		
		setLayout(null);
		setOpaque(false);
		setLocation(locationX, locationY);
		setSize(sizeX, sizeY);		
		
		DialogueTab = new GroupFrame(0,0, SizeX, SizeY, -2);
		ChoiceTab = new GroupFrame(0,0, SizeX, SizeY, -1);
	
		addToMap(DialogueTab.getDepth(), DialogueTab, "Dialogue");
		addToMap(ChoiceTab.getDepth(), ChoiceTab, "Choice");
		
		addThings();
	}
	
	public void addThings(){
		Set<Integer> set=map.keySet();
		for(Object obj:set)
		{
			addTab(mapName.get(obj), map.get(obj));
		}		
	}
	public void addToMap(int Depth, Component obj, String Name){
		map.put(Depth, obj);
		mapName.put(Depth, Name);
	}
	public void removeFromMap(int Depth){
		map.remove(Depth);
		mapName.remove(Depth);
	}
	
	public void setDepth(int Depth){
		this.depth = Depth;
	}
	public int getDepth(){
		return depth;
	}
		
}
