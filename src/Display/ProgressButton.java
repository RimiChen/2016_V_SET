package Display;

import javax.swing.JButton;

import FunctionActions.DialogueAddAction;
import FunctionActions.ProgressButtonAction;

public class ProgressButton extends JButton{
	int locationX;
	int locationY;
	int sizeX;
	int sizeY;
	
	int depth;
	int index;
	
	//String name;
	
	 ProgressButtonAction act;
	
	public  ProgressButton(int LocationX, int LocationY, int SizeX, int SizeY, int Depth ){
		this.locationX = LocationX;
		this.locationY = LocationY;
		this.sizeX = SizeX;
		this.sizeY = SizeY;
		this.depth = Depth;
		this.index = Depth;
		//this.name = name;
		
		act = new  ProgressButtonAction();
		
		addActionListener(act);
		
		//setText(name);
		setLocation(locationX, locationY);
		setSize(sizeX, sizeY);		
	}
	public void setDepth(int Depth){
		this.depth = Depth;
	}
	public int getDepth(){
		return depth;
	}
/*	
	public void updateName(String name){
		this.name = name;
	}
*/
}