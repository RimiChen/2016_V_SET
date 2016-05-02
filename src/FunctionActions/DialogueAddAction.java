package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import EdittingBuffer.EditingBuffer;
import Events.G_Event;
import Events.StoryDialogue;
import Events.StoryEvent;

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
		if(nowEvent.choiceQueue.size()==0){
			if(EditingBuffer.BufferedDialogue.size() == 0){
				tempDialogue = new StoryDialogue(0, 0, G_Event.DialoguePanel.getWidth(), G_Event.DialoguePanel.getHeight()/numberInAPage, EditingBuffer.BufferedDialogue.size(),EditingBuffer.BufferedDialogue.size());
				EditingBuffer.BufferedDialogue.add(tempDialogue);
				int current = EditingBuffer.BufferedDialogue.size();
				G_Event.DialoguePanel.removeAll();
				G_Event.DialoguePanel.addToMap(EditingBuffer.BufferedDialogue.get(current-1).getDepth(), EditingBuffer.BufferedDialogue.get(current-1));
				G_Event.DialoguePanel.addThings();
				G_Event.DialoguePanel.repaint();
			}
			else{
				int current = EditingBuffer.BufferedDialogue.size();
				tempDialogue = new StoryDialogue(
						0,
						EditingBuffer.BufferedDialogue.get(current-1).getY()+EditingBuffer.BufferedDialogue.get(current-1).getHeight()+5,
						G_Event.DialoguePanel.getWidth(),
						G_Event.DialoguePanel.getHeight()/numberInAPage,
						EditingBuffer.BufferedDialogue.size(),
						EditingBuffer.BufferedDialogue.size()
				);
				EditingBuffer.BufferedDialogue.add(tempDialogue);
				current = EditingBuffer.BufferedDialogue.size();
				G_Event.DialoguePanel.removeAll();
				G_Event.DialoguePanel.addToMap(EditingBuffer.BufferedDialogue.get(current-1).getDepth(), EditingBuffer.BufferedDialogue.get(current-1));
				G_Event.DialoguePanel.addThings();
				G_Event.DialoguePanel.repaint();
			}
			System.out.println("System: Add new dialogue in "+ nowEvent.eventName);
		}
		else{
			System.out.println("Now this event work on choices, Please create new event to edit dialogues");
		}
	}

}
