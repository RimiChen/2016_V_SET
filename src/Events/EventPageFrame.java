package Events;

import java.awt.Component;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

import FunctionActions.EventPageDownAction;
import FunctionActions.EventPageUpAction;
import MainScreen.GroupFrame;

@SuppressWarnings("serial")
public class EventPageFrame extends JPanel{
	int locationX;
	int locationY;
	int sizeX;
	int sizeY;
	int depth;
	int pageNumber;
	JLabel pageLabel;
	
	public Map<Integer, Component> map;
	
	public GroupFrame changePagePanel;
	public EventPageUpButton pageUp;
	public EventPageDownButton pageDown;
	
	public Map<String, EventButton> EventButtonMap;
	public Map<String, EventLabel> EventLabelMap;
	
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
		
		//each event have a event object, and a label, a button for display
		EventButtonMap = new TreeMap<String, EventButton>();
		EventLabelMap = new TreeMap<String, EventLabel>();
		
		changePagePanel = new GroupFrame(this.sizeX *8 /10, this.sizeY *9 /10, 100, 30, -2 ); 

		pageDown = new EventPageDownButton(0, 0, changePagePanel.getWidth()/2, changePagePanel.getHeight(), 1);
		pageDown.setText("<");
		EventPageDownAction pageDownAct = new EventPageDownAction(); 
		pageDown.addActionListener(pageDownAct);
		
		pageUp = new EventPageUpButton(changePagePanel.getWidth()/2, 0, changePagePanel.getWidth()/2, changePagePanel.getHeight(), 0);
		pageUp.setText(">");
		EventPageUpAction pageUpAct = new EventPageUpAction(); 
		pageUp.addActionListener(pageUpAct);
		
		
		changePagePanel.addToMap(pageUp.getDepth(), pageUp);
		changePagePanel.addToMap(pageDown.getDepth(), pageDown);
		changePagePanel.addThings();
		addChagnePage();
		
	}
	public void addChagnePage(){
		addToMap(-1, pageLabel);
		addToMap(changePagePanel.getDepth(),changePagePanel);
		//addThings();
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
