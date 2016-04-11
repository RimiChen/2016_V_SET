package Events;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class EventNameField extends JTextField{
	int locationX;
	int locationY;
	int sizeX;
	int sizeY;
	
	int depth;
	
	public EventNameField(int LocationX, int LocationY, int SizeX, int SizeY, int Depth){
		this.locationX = LocationX;
		this.locationY = LocationY;
		this.sizeX = SizeX;
		this.sizeY = SizeY;
		this.depth = Depth;
		
		setLayout(null);
		setLocation(locationX, locationY);
		setSize(sizeX, sizeY);		
	}
	public void setDepth(int Depth){
		this.depth = Depth;
	}
	public int getDepth(){
		return depth;
	}
		
}
