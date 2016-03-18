package Events;

import java.awt.Component;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JPanel;

public class StoryDialogue extends JPanel{
	int locationX;
	int locationY;
	int sizeX;
	int sizeY;
	int depth;
	public Map<Integer, Component> map;
	
	public int index;
	
	public String charaName;
	public String content;	
	
	public StoryDialogue(int LocationX, int LocationY, int SizeX, int SizeY, int Depth){
		this.locationX = LocationX;
		this.locationY = LocationY;
		this.sizeX = SizeX;
		this.sizeY = SizeY;
		this.depth = Depth;
		map = new TreeMap<Integer, Component>();
		
		setLayout(null);
		setLocation(locationX, locationY);
		setSize(sizeX, sizeY);		
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
