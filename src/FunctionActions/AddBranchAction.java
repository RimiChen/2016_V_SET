package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;

import CharaMake.CustomCharacter;
import Events.EventPageFrame;
import Events.G_Event;
import MainScreen.G_Components;
import Variables.GlobalV;
import Variables.LookUp;

public class AddBranchAction implements ActionListener{
	CustomCharacter nowChara;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("System: "+ "Now adding event " +arg0.getActionCommand().toString());
		

		if(GlobalV.isEditting == false){
			// add a new page
			//System.out.println("System: create a new Story Page "+GlobalV.NumberEventPage);
			GlobalV.NumberEventPage++;
			System.out.println("System: create a new Story Page "+GlobalV.NumberEventPage);
			EventPageFrame tempEventPage = new EventPageFrame(0, 0, G_Event.StorylinePanel.getWidth(), G_Event.StorylinePanel.getHeight(), GlobalV.NumberEventPage, GlobalV.NumberEventPage);
			G_Event.EventPageMap.put(GlobalV.NumberEventPage, tempEventPage);
			Map< Integer, String> tempTime = new TreeMap<Integer, String>();
			LookUp.EventTimeMap.add(tempTime);
		}
	}
	public void printMap(){
		for(int key : G_Components.mainScreen.map.keySet())
		{
		     System.out.println(key + " : " +G_Components.mainScreen.map.get(key));
		}
	}
}
