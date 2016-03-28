package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CharaMake.CustomCharacter;
import Events.G_Event;
import Events.StoryDialogue;
import Events.StoryEvent;
import MainScreen.G_Components;
import Variables.GlobalV;
import Variables.LookUp;

public class DialogueAddAction  implements ActionListener{

	StoryEvent nowEvent;
	StoryDialogue tempDialogue;
	
	int numberInAPage;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		numberInAPage = GlobalV.MaxDialogueNumber;
		
		nowEvent = LookUp.EventMap.get(LookUp.EventNameMap.get(GlobalV.CurrentEditingEvent));
		if(GlobalV.BufferedDialogue.size() == 0){
			tempDialogue = new StoryDialogue(0, 0, G_Event.DialoguePanel.getWidth(), G_Event.DialoguePanel.getHeight()/numberInAPage, GlobalV.BufferedDialogue.size(),GlobalV.BufferedDialogue.size());
			GlobalV.BufferedDialogue.add(tempDialogue);
			int current = GlobalV.BufferedDialogue.size();
			G_Event.DialoguePanel.removeAll();
			G_Event.DialoguePanel.addToMap(GlobalV.BufferedDialogue.get(current-1).getDepth(), GlobalV.BufferedDialogue.get(current-1));
			G_Event.DialoguePanel.addThings();
			G_Event.DialoguePanel.repaint();
		}
		else{
			int current = GlobalV.BufferedDialogue.size();
			tempDialogue = new StoryDialogue(
					0,
					GlobalV.BufferedDialogue.get(current-1).getY()+GlobalV.BufferedDialogue.get(current-1).getHeight()+5,
					G_Event.DialoguePanel.getWidth(),
					G_Event.DialoguePanel.getHeight()/numberInAPage,
					GlobalV.BufferedDialogue.size(),
					GlobalV.BufferedDialogue.size()
			);
			GlobalV.BufferedDialogue.add(tempDialogue);
			current = GlobalV.BufferedDialogue.size();
			G_Event.DialoguePanel.removeAll();
			G_Event.DialoguePanel.addToMap(GlobalV.BufferedDialogue.get(current-1).getDepth(), GlobalV.BufferedDialogue.get(current-1));
			G_Event.DialoguePanel.addThings();
			G_Event.DialoguePanel.repaint();
		}
		System.out.println("System: Add new dialogue in "+ nowEvent.eventName);
		
	}

}
