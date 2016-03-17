package CharacterScreen;

import javax.swing.JButton;

import FunctionActions.ImageDownAction;
import FunctionActions.ImageUpAction;
import Variables.GlobalV;

public class ImageUpButton extends JButton{
	int locationX;
	int locationY;
	int sizeX;
	int sizeY;
	
	int depth;
	
	String partName;
	
	ImageUpAction act;
	
	public ImageUpButton(int LocationX, int LocationY, int SizeX, int SizeY, int Depth, String Part){
		this.locationX = LocationX;
		this.locationY = LocationY;
		this.sizeX = SizeX;
		this.sizeY = SizeY;
		this.depth = Depth;
		this.partName = Part;
		
		act = new ImageUpAction(depth);
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
