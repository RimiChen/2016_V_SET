package Events;

import java.awt.Color;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class DragArea extends JLabel{
	int locationX;
	int locationY;
	int sizeX;
	int sizeY;
	
	int depth;
	String name;
	
	int startX;
	int startY;
	
	int currentX;
	int currentY;
	

	public  DragArea(int LocationX, int LocationY, int SizeX, int SizeY, int Depth, Color backColor){
		this.locationX = LocationX;
		this.locationY = LocationY;
		this.sizeX = SizeX;
		this.sizeY = SizeY;
		this.depth = Depth;
		
		this.startX = LocationX;
		this.startY = LocationY;
		this.currentX = SizeX;
		this.currentY = SizeY;
		
	
		setBackground(backColor);
		setOpaque(true);
		
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
	public void updateStartPos(int x, int y){
		startX = x;
		startY = y;
		setLocation(startX, startY);
	}
	public void updateSize(int x, int y){
		currentX = x;
		currentY = y;
		setSize(currentX, currentY);
	}
}
