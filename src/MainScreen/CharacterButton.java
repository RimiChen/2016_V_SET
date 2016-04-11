package MainScreen;

import java.awt.Color;

import javax.swing.JButton;

import Events.G_Event;
import Events.SubLabel;
import Variables.GlobalV;

@SuppressWarnings("serial")
public class CharacterButton extends JButton{
	/**
	 * 
	 */
	public int locationX;
	public int locationY;
	public int sizeX;
	public int sizeY;
	
	int depth;
	
	public SubLabel line;
	
	public CharacterButton(int LocationX, int LocationY, int SizeX, int SizeY, int Depth){
		this.locationX = LocationX;
		this.locationY = LocationY;
		this.sizeX = SizeX;
		this.sizeY = SizeY;
		this.depth = Depth;
		line = new SubLabel(LocationX+SizeX/2-2, 0, 5, G_Event.StorylinePanel.getHeight(), 100+depth, "", new Color(0, 40, 147, 125), true);
		line.setVisible(true);
		G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).addToMap(line.getDepth(), line);
		
		G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).removeAll();
		G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).addThings();
		G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).repaint();
		
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