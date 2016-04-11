package Events;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SubLabel extends JLabel{
	int locationX;
	int locationY;
	int sizeX;
	int sizeY;
	
	int depth;
	
	String text;
	
	
	
	public SubLabel(int LocationX, int LocationY, int SizeX, int SizeY, int Depth, String text, Color color, boolean opaque){
		this.locationX = LocationX;
		this.locationY = LocationY;
		this.sizeX = SizeX;
		this.sizeY = SizeY;
		this.depth = Depth;
		this.text = text;
		
		setVisible(true);
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		setBackground(color);
		setText(text);
		setOpaque(opaque);
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