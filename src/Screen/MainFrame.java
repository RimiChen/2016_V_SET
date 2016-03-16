package Screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.*;
public class MainFrame extends JPanel implements ActionListener{
	private int depth;
	Map<Integer, Component> map;
	
	public MainFrame(int Depth){
		//super(title);
		map = new TreeMap<Integer, Component>();
		this.depth = Depth;
		//setDefaultCloseOperation(JFrame.JFrame.EXIT_ON_CLOSE);		
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
