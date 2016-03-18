package CharacterScreen;

import javax.swing.JLabel;

import FunctionActions.CharaNoAction;

public class BodyNameLabel extends JLabel{
	int locationX;
	int locationY;
	int sizeX;
	int sizeY;
	
	int depth;
	String name;
	
	CharaNoAction act;
	
	public  BodyNameLabel(int LocationX, int LocationY, int SizeX, int SizeY, int Depth, String name){
		this.locationX = LocationX;
		this.locationY = LocationY;
		this.sizeX = SizeX;
		this.sizeY = SizeY;
		this.depth = Depth;
		this.name = name;
		act = new CharaNoAction();
		
		setLayout(null);
		setLocation(locationX, locationY);
		setSize(sizeX, sizeY);
		setText(name);
		setVisible(true);

	}
	public void setDepth(int Depth){
		this.depth = Depth;
	}
	public int getDepth(){
		return depth;
	}
}
