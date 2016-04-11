package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CharaMake.CustomCharacter;
import Events.G_Event;
import MainScreen.G_Components;
import Variables.GlobalV;


public class MoveEventAction implements ActionListener{
	CustomCharacter nowChara;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if( GlobalV.isEditting == false && G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).EventLabelMap.size()>0){
			//System.out.println("System: "+ "Now moving event " +arg0.getActionCommand());

			GlobalV.isEditting = true;
			
			G_Event.paintEventLabel();
			
			G_Event.StorylinePanel.addToMap(G_Event.MovePanel.getDepth(), G_Event.MovePanel);
			G_Event.StorylinePanel.removeAll();
			G_Event.StorylinePanel.addThings();
			G_Event.StorylinePanel.repaint();
			G_Components.mainScreen.repaint();			
		}

	}
	public void printMap(){
		for(int key : G_Components.mainScreen.map.keySet())
		{
		     System.out.println(key + " : " +G_Components.mainScreen.map.get(key));
		}
	}
}
