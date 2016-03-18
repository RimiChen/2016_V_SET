package Events;

import java.util.Map;

import javax.swing.JList;
import javax.swing.JMenuBar;

public class GivenMenu extends JList{
	String menuName;
	
	public GivenMenu(int LocationX, int LocationY, int SizeX, int SizeY, int Depth, String MenuName, Map<String, Integer> Map){
		this.menuName = MenuName;
	}
	public void updateMenu(String MenuName, Map<String, Integer> NewMap){
		
	}
}
