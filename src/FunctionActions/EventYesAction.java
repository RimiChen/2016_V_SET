package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import EdittingBuffer.EditingBuffer;
import Events.EventButton;
import Events.EventLabel;
import Events.G_Event;
import Events.StoryEvent;
import MainScreen.G_Components;
import Variables.GlobalV;
import Variables.LookUp;

public class EventYesAction implements ActionListener{
	StoryEvent nowEvent;	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		nowEvent = LookUp.EventMap.get(LookUp.EventNameMap.get(GlobalV.CurrentEditingEvent));
		//update saved dialogue
		for(int i = 0; i < EditingBuffer.BufferedDialogue.size(); i++){
			EditingBuffer.BufferedDialogue.get(i).content = EditingBuffer.BufferedDialogue.get(i).contentBox.getText();
		}
		
		nowEvent.dialogueQueue.clear();
		for(int i = 0; i < EditingBuffer.BufferedDialogue.size(); i++){
			EditingBuffer.BufferedDialogue.get(i).charaIndex = EditingBuffer.BufferedDialogue.get(i).tempCharaIndex;
		}
		nowEvent.dialogueQueue.addAll(EditingBuffer.BufferedDialogue);
		
		nowEvent.place = nowEvent.tempPlace;
		
		//check name update
		
		String oldName = nowEvent.eventName;
		String newName = G_Event.EventName.getText();
	
		
		nowEvent.eventName = newName;
		
		int index = LookUp.EventNameMap.get(oldName);
		LookUp.EventNameMap.remove(oldName);
		LookUp.EventNameMap.put(newName, index);
		
		index = LookUp.EventPageMap.get(oldName);
		LookUp.EventPageMap.remove(oldName);
		LookUp.EventPageMap.put(newName, index);

		index = LookUp.EventPositionMap.get(GlobalV.CurrentEdittingPage).get(oldName);
		LookUp.EventPositionMap.get(GlobalV.CurrentEdittingPage).remove(oldName);
		LookUp.EventPositionMap.get(GlobalV.CurrentEdittingPage).put(newName, index);

		index = LookUp.EventPositionMap.get(GlobalV.CurrentEdittingPage).get(newName);
		LookUp.EventTimeMap.get(GlobalV.CurrentEdittingPage).remove(index);
		LookUp.EventTimeMap.get(GlobalV.CurrentEdittingPage).put(index, newName);
		
		//update button and label
		EventButton tempButton;
		tempButton = G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).EventButtonMap.get(oldName);
		tempButton.setText(newName);
		G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).EventButtonMap.remove(oldName);
		G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).EventButtonMap.put(newName, tempButton);

		EventLabel tempLabel;
		tempLabel = G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).EventLabelMap.get(oldName);
		tempLabel.setText(newName);
		G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).EventLabelMap.remove(oldName);
		G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).EventLabelMap.put(newName, tempLabel);
		
		
		//System.out.println(G_Event.EventName.getText());
		
/*
		public static Map<Integer, StoryEvent> EventMap;
		public static Map<String, Integer> +EventNameMap;
		public static Map<String, Integer> EventPageMap;
		public static Map<String, Integer> EventPositionMap;
		public static Map<Integer, String> EventTimeMap; 		
*/
		
		
		
		
		G_Components.currentContent.map.clear();
		G_Components.currentContent.removeAll();
		G_Components.currentContent.addToMap(G_Components.mainScreen.getDepth(), G_Components.mainScreen);
		G_Components.currentContent.addThings();
		G_Components.currentContent.repaint();
		
		//Clear Buffer
		EditingBuffer.BufferedDialogue.clear();
		G_Event.DialoguePanel.map.clear();
		G_Event.DialoguePanel.removeAll();
		
		
		GlobalV.isEditting = false;
		System.out.println("System: "+ nowEvent.eventName + " was saved.");
	}

}
