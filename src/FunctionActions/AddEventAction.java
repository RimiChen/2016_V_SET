package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CharaMake.CustomCharacter;
import CharacterScreen.G_Chara;
import Events.G_Event;
import MainScreen.G_Components;
import Variables.GlobalV;
import Variables.LookUp;

public class AddEventAction implements ActionListener{
	CustomCharacter nowChara;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("System: "+ "Now adding event " +arg0.getActionCommand().toString());
		System.out.println("System: "+ "Now adding event " + GlobalV.CurrentEditingEvent);
		

		if(GlobalV.isEditting == false){
			GlobalV.isEditting = true;
			
			G_Event.paintEventLabel();
			
			G_Event.StorylinePanel.addToMap(G_Event.DragPanel.getDepth(), G_Event.DragPanel);
			G_Event.StorylinePanel.removeAll();
			G_Event.StorylinePanel.addThings();
			G_Event.StorylinePanel.repaint();
			G_Components.mainScreen.repaint();
			//printMap();
		}
	}
	public void printMap(){
		for(int key : G_Components.mainScreen.map.keySet())
		{
		     System.out.println(key + " : " +G_Components.mainScreen.map.get(key));
		}
	}
}
