package CharacterScreen;

import javax.swing.JButton;

import FunctionActions.ImageDownAction;
import Variables.GlobalV;

public class ImageDownButton extends JButton{
	int locationX;
	int locationY;
	int sizeX;
	int sizeY;
	
	//also used to be index
	int depth;
	
	String partName;
	
	ImageDownAction act;
	
	public ImageDownButton(int LocationX, int LocationY, int SizeX, int SizeY, int Depth, String Part){
		this.locationX = LocationX;
		this.locationY = LocationY;
		this.sizeX = SizeX;
		this.sizeY = SizeY;
		this.depth = Depth;
		this.partName = Part;
		
		act = new ImageDownAction(depth);
		addActionListener(act);
		
		setLocation(locationX, locationY);
		setSize(sizeX, sizeY);
		setVisible(true);
	}
	public void setDepth(int Depth){
		this.depth = Depth;
	}
	public int getDepth(){
		return depth;
	}

}
