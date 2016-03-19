package Display;

import java.awt.Component;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JPanel;
import javax.swing.Timer;

import FunctionActions.MainFrameActions;
import MainScreen.MainFrame;
import Variables.GlobalV;

public class BackgoundTimerFrame extends JPanel{
	int locationX;
	int locationY;
	int sizeX;
	int sizeY;
	int depth;
	public Map<Integer, Component> map;

	public MainFrameActions mainAct;
	public  Timer clock;
	
	public boolean isTimer;
	
	public BackgoundTimerFrame(int LocationX, int LocationY, int SizeX, int SizeY, int Depth,boolean isTimer){
		this.locationX = LocationX;
		this.locationY = LocationY;
		this.sizeX = SizeX;
		this.sizeY = SizeY;
		this.depth = Depth;
		map = new TreeMap<Integer, Component>();

		mainAct = new MainFrameActions();
		clock = new Timer(GlobalV.ClockDelay, mainAct);
		
		this.isTimer = isTimer;
		
		if(isTimer == false){
			disableTimer();
		}
		else{
			enableTimer();
		}
		
		
		setLayout(null);
		setLocation(locationX, locationY);
		setSize(sizeX, sizeY);		
	}
	public void enableTimer(){
		isTimer = true;
		clock.start();
	}
	public void disableTimer(){
		isTimer = false;
		clock.stop();
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
