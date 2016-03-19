package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

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
		for(int i = 0; i < GlobalV.BufferedDialogue.size(); i++){
			GlobalV.BufferedDialogue.get(i).content = GlobalV.BufferedDialogue.get(i).contentBox.getText();
		}
		
		nowEvent.dialogueQueue.clear();
		for(int i = 0; i < GlobalV.BufferedDialogue.size(); i++){
			GlobalV.BufferedDialogue.get(i).charaIndex = GlobalV.BufferedDialogue.get(i).tempCharaIndex;
		}
		nowEvent.dialogueQueue.addAll(GlobalV.BufferedDialogue);
		
		nowEvent.place = nowEvent.tempPlace;
		
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
		GlobalV.BufferedDialogue.clear();
		G_Event.DialoguePanel.map.clear();
		G_Event.DialoguePanel.removeAll();
		
		
		GlobalV.isEditting = false;
		System.out.println("System: "+ nowEvent.eventName + " was saved.");
	}

}
