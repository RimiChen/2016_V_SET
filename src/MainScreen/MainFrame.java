package MainScreen;

import java.awt.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.*;
@SuppressWarnings("serial")
public class MainFrame extends JPanel{
	public  Map<Integer, Component> map;
	
	public MainFrame(int Depth){
		//super(title);
		map = new TreeMap<Integer, Component>();
		setLayout(null);
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

}
