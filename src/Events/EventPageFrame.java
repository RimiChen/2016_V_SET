package Events;

import java.awt.Component;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class EventPageFrame extends JPanel{
	int locationX;
	int locationY;
	int sizeX;
	int sizeY;
	int depth;
	int pageNumber;
	JLabel pageLabel;
	
	public Map<Integer, Component> map;
	
	public EventPageFrame(int LocationX, int LocationY, int SizeX, int SizeY, int Depth, int index){
		this.locationX = LocationX;
		this.locationY = LocationY;
		this.sizeX = SizeX;
		this.sizeY = SizeY;
		this.depth = Depth;
		this.pageNumber = index;

		map = new TreeMap<Integer, Component>();		
		setLayout(null);
		setLocation(locationX, locationY);
		setSize(sizeX, sizeY);		


		// page label
		pageLabel = new JLabel();
		pageLabel.setText("Page "+pageNumber);
		pageLabel.setLocation(0,  0);
		pageLabel.setSize(50, 20);
		addToMap(-1, pageLabel);
		addThings();
		
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
