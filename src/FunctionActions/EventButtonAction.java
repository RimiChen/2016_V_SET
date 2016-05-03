package FunctionActions;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import EdittingBuffer.EditingBuffer;
import Events.G_Event;
import Events.StoryEvent;

import MainScreen.G_Components;
import Variables.GlobalV;
import Variables.LookUp;

public class EventButtonAction implements ActionListener{
	StoryEvent nowEvent;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//GlobalV.CurrentFun ++;
		//System.out.println(GlobalV.CurrentFun);
		System.out.println("System: Editing " + arg0.getActionCommand());
		GlobalV.CurrentEditingEvent = arg0.getActionCommand();
		GlobalV.isEditting = true;
		
		G_Event.EventName.setText(arg0.getActionCommand());
		G_Event.EventNamePanel.repaint();
		
		nowEvent = LookUp.EventMap.get(LookUp.EventNameMap.get(GlobalV.CurrentEditingEvent));
		G_Event.setPlacePreview(nowEvent.place);
		
		
		
		G_Components.currentContent.map.clear();
		G_Components.currentContent.removeAll();
		G_Components.currentContent.addToMap(G_Event.EventEditingPanel.getDepth(), G_Event.EventEditingPanel);
		G_Components.currentContent.addThings();
		G_Components.currentContent.repaint();
		G_Components.mainFrame.repaint();
		
		//prepare to edit dialogue content
		//clear buffer
		EditingBuffer.BufferedDialogue.clear();
		EditingBuffer.BufferedDialogue.addAll(nowEvent.dialogueQueue);

		EditingBuffer.BufferedCondition.clear();
		EditingBuffer.BufferedCondition.addAll(nowEvent.conditionQueue);
		
		EditingBuffer.BufferedChoice.clear();
		EditingBuffer.BufferedChoice.addAll(nowEvent.choiceQueue);


		
		//diaplay previous dialogue
		displayPrevious();

	}
	public void displayPrevious(){
		if(nowEvent.dialogueQueue.size() !=0){
			// no choice
			G_Event.ContentOutPanel.map.clear();
			G_Event.ContentOutPanel.addToMap(G_Event.DialoguePanel.getDepth(), G_Event.DialoguePanel);
			G_Event.ContentOutPanel.removeAll();
			G_Event.ContentOutPanel.addThings();
			G_Event.ContentOutPanel.repaint();
			
			for(int i = 0; i< EditingBuffer.BufferedDialogue.size(); i++){
				//System.out.print(GlobalV.BufferedDialogue.get(i).charaIndex);
				//System.out.println("old " + GlobalV.BufferedDialogue.get(i).content +" Chara: " + LookUp.CharaMap.get(GlobalV.BufferedDialogue.get(i).charaIndex));
				EditingBuffer.BufferedDialogue.get(i).charaNameList.updateMenu("Character", LookUp.CharaNameMap);
				EditingBuffer.BufferedDialogue.get(i).charaNameList.setSelectedIndex(EditingBuffer.BufferedDialogue.get(i).charaIndex-1);
				EditingBuffer.BufferedDialogue.get(i).charaNameList.repaint();
				EditingBuffer.BufferedDialogue.get(i).contentBox.setText(EditingBuffer.BufferedDialogue.get(i).content);
				G_Event.DialoguePanel.addToMap(EditingBuffer.BufferedDialogue.get(i).getDepth(), EditingBuffer.BufferedDialogue.get(i));
			}
			G_Event.DialoguePanel.addThings();
			G_Event.DialoguePanel.repaint();

		}
		
		if(nowEvent.choiceQueue.size() !=0){
			G_Event.ContentOutPanel.map.clear();
			G_Event.ContentOutPanel.addToMap(G_Event.ChoiceOutPanel.getDepth(), G_Event.ChoiceOutPanel);
			G_Event.ContentOutPanel.removeAll();
			G_Event.ContentOutPanel.addThings();
			G_Event.ContentOutPanel.repaint();
	
			for(int i = 0; i< EditingBuffer.BufferedChoice.size(); i++){
				//System.out.print(GlobalV.BufferedDialogue.get(i).charaIndex);
				//System.out.println("old " + GlobalV.BufferedDialogue.get(i).content +" Chara: " + LookUp.CharaMap.get(GlobalV.BufferedDialogue.get(i).charaIndex));
				
				EditingBuffer.BufferedChoice.get(i).ChoiceContent.setText(EditingBuffer.BufferedChoice.get(i).content);
				EditingBuffer.BufferedChoice.get(i).ChoiceVariable.setText(EditingBuffer.BufferedChoice.get(i).variable);
				EditingBuffer.BufferedChoice.get(i).ChoiceOper.setText(EditingBuffer.BufferedChoice.get(i).operator);
				EditingBuffer.BufferedChoice.get(i).ChoiceValue.setText(EditingBuffer.BufferedChoice.get(i).value);
				G_Event.ChoicePanel.addToMap(EditingBuffer.BufferedChoice.get(i).getDepth(), EditingBuffer.BufferedChoice.get(i));
			}
			G_Event.ChoicePanel.addThings();
			G_Event.ChoicePanel.repaint();
		}
		
		for(int i = 0; i< EditingBuffer.BufferedCondition.size(); i++){
			//System.out.print(GlobalV.BufferedDialogue.get(i).charaIndex);
			//System.out.println("old " + GlobalV.BufferedDialogue.get(i).content +" Chara: " + LookUp.CharaMap.get(GlobalV.BufferedDialogue.get(i).charaIndex));
			G_Event.EventConditionListPanel.addToMap(EditingBuffer.BufferedCondition.get(i).getDepth(), EditingBuffer.BufferedCondition.get(i));
		}
		G_Event.EventJumpPage.setText(Integer.toString(nowEvent.nextPage));
		G_Event.EventJump.setText(nowEvent.nextEvent);

		G_Event.EventVariableName.setText(nowEvent.influencedVariable); 
		G_Event.EventVariableOperator.setText(nowEvent.operator);
		G_Event.EventVariableValue.setText(nowEvent.value);		
		
		System.out.println("Now Event" +nowEvent.index +" has "+nowEvent.conditionQueue.size()+" conditions");
		G_Event.EventConditionListPanel.addThings();
		G_Event.EventConditionListPanel.repaint();
		//System.out.println("In place: " + nowEvent.place +", " +LookUp.PlaceNameMap.get(nowEvent.place));
		G_Event.PlaceMenu.setSelectedIndex(LookUp.PlaceNameMap.get(nowEvent.place));
		G_Event.PlaceMenu.repaint();
	}
}
