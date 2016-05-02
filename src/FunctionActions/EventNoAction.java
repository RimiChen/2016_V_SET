package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import EdittingBuffer.EditingBuffer;
import Events.G_Event;
import MainScreen.G_Components;
import Variables.GlobalV;


public class EventNoAction implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//GlobalV.isEditting = false;
		
		G_Components.currentContent.map.clear();
		G_Components.currentContent.removeAll();
		G_Components.currentContent.addToMap(G_Components.mainScreen.getDepth(), G_Components.mainScreen);
		G_Components.currentContent.addThings();
		G_Components.currentContent.repaint();
		
		//Clear Buffer
		EditingBuffer.BufferedDialogue.clear();
		EditingBuffer.BufferedCondition.clear();
		EditingBuffer.BufferedChoice.clear();
		
		G_Event.EventConditionListPanel.map.clear();
		G_Event.EventConditionListPanel.removeAll();

		G_Event.DialoguePanel.map.clear();
		G_Event.DialoguePanel.removeAll();
		
		G_Event.ChoicePanel.map.clear();
		G_Event.ChoicePanel.removeAll();
		
		
		GlobalV.isEditting = false;		
		
	}

}
