package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Choices.StoryChoice;
import EdittingBuffer.EditingBuffer;
import Events.G_Event;
import Events.StoryDialogue;
import Events.StoryEvent;
import Variables.GlobalV;
import Variables.LookUp;

public class ChoiceAddAction  implements ActionListener{

	StoryEvent nowEvent;
	StoryChoice tempChoice;
	
	int numberInAPage;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		numberInAPage = GlobalV.MaxDialogueNumber;
		
		nowEvent = LookUp.EventMap.get(LookUp.EventNameMap.get(GlobalV.CurrentEditingEvent));
		 
		//if(EditingBuffer.BufferedChoice.size()==0 && EditingBuffer.BufferedDialogue.size()==0){
			//G_Event.ContentOutPanel.remove(G_Event.ChoicePanel.getDepth());
			G_Event.ContentOutPanel.map.remove(G_Event.DialoguePanel.getDepth());
			G_Event.ContentOutPanel.addToMap(G_Event.ChoiceOutPanel.getDepth(), G_Event.ChoiceOutPanel);
			G_Event.ContentOutPanel.removeAll();
			G_Event.ContentOutPanel.addThings();
			G_Event.ContentOutPanel.repaint();
	
		if(nowEvent.dialogueQueue.size()==0){
			
			if(EditingBuffer.BufferedChoice.size() <GlobalV.MaxDialogueNumber-1){
				if(EditingBuffer.BufferedChoice.size() == 0){
					tempChoice = new StoryChoice(0, 0, G_Event.ChoicePanel.getWidth(), G_Event.ChoicePanel.getHeight()/numberInAPage, EditingBuffer.BufferedChoice.size(),EditingBuffer.BufferedChoice.size());
					EditingBuffer.BufferedChoice.add(tempChoice);
					int current = EditingBuffer.BufferedChoice.size();
					G_Event.ChoicePanel.removeAll();
					G_Event.ChoicePanel.addToMap(EditingBuffer.BufferedChoice.get(current-1).getDepth(), EditingBuffer.BufferedChoice.get(current-1));
					G_Event.ChoicePanel.addThings();
					G_Event.ChoicePanel.repaint();
				}
				else{
					int current = EditingBuffer.BufferedChoice.size();
					tempChoice = new StoryChoice(
							0,
							EditingBuffer.BufferedChoice.get(current-1).getY()+EditingBuffer.BufferedChoice.get(current-1).getHeight()+5,
							G_Event.ChoicePanel.getWidth(),
							G_Event.ChoicePanel.getHeight()/numberInAPage,
							EditingBuffer.BufferedChoice.size(),
							EditingBuffer.BufferedChoice.size()
					);
					EditingBuffer.BufferedChoice.add(tempChoice);
					current = EditingBuffer.BufferedChoice.size();
					G_Event.ChoicePanel.removeAll();
					G_Event.ChoicePanel.addToMap(EditingBuffer.BufferedChoice.get(current-1).getDepth(), EditingBuffer.BufferedChoice.get(current-1));
					G_Event.ChoicePanel.addThings();
					G_Event.ChoicePanel.repaint();
				}
				System.out.println("System: Add new choice in "+ nowEvent.eventName +" buffer size ");
			}
			else{
				System.out.println("System: too many choices");
			}
		}
		else{
			System.out.println("System: Now this event work on dialogues, Please create new event to edit choices");
		}
	}

}
