package Events;

import javax.swing.JButton;

import FunctionActions.EventNoAction;

public class EventPageUpButton  extends JButton{
	int locationX;
	int locationY;
	int sizeX;
	int sizeY;
	
	int depth;
	
	//EventNoAction act;
	
	public EventPageUpButton(int LocationX, int LocationY, int SizeX, int SizeY, int Depth){
		this.locationX = LocationX;
		this.locationY = LocationY;
		this.sizeX = SizeX;
		this.sizeY = SizeY;
		this.depth = Depth;
		//act = new EventNoAction();
		
		setLayout(null);
		setLocation(locationX, locationY);
		setSize(sizeX, sizeY);	
		setVisible(true);
		//addActionListener(act);	
	}
	public void setDepth(int Depth){
		this.depth = Depth;
	}
	public int getDepth(){
		return depth;
	}
}