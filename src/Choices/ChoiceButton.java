package Choices;

import javax.swing.JButton;


@SuppressWarnings("serial")
public class ChoiceButton  extends JButton{
	int locationX;
	int locationY;
	int sizeX;
	int sizeY;
	
	int depth;
	int index;
	
	ChoiceAction act;
	
	public ChoiceButton (int LocationX, int LocationY, int SizeX, int SizeY, int Depth, int index){
		this.index = index;
		this.locationX = LocationX;
		this.locationY = LocationY;
		this.sizeX = SizeX;
		this.sizeY = SizeY;
		this.depth = Depth;
		act = new ChoiceAction(index);
		
		setLayout(null);
		setLocation(locationX, locationY);
		setSize(sizeX, sizeY);	
		setVisible(true);
		addActionListener(act);	
	}
	public void setDepth(int Depth){
		this.depth = Depth;
	}
	public int getDepth(){
		return depth;
	}
}