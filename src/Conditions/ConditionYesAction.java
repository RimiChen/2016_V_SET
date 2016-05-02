package Conditions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Choices.G_Variables;
import EdittingBuffer.EditingBuffer;
import Events.G_Event;
import MainScreen.G_Components;
import Variables.GlobalV;
import Variables.LookUp;

public class ConditionYesAction  implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//GlobalV.isEditting = false;
		
		EditingBuffer.BufferedCondition.get(GlobalV.currentEdittingButton).variable = G_Event.ConditionVariable.getText();
		
		if(G_Variables.checkVariableExist(EditingBuffer.BufferedCondition.get(GlobalV.currentEdittingButton).variable)==false){
			G_Variables.addNewVariable(EditingBuffer.BufferedCondition.get(GlobalV.currentEdittingButton).variable);
		}
		
		EditingBuffer.BufferedCondition.get(GlobalV.currentEdittingButton).operator = G_Event.ConditionOper.getText();
		EditingBuffer.BufferedCondition.get(GlobalV.currentEdittingButton).value =G_Event.ConditionValue.getText();
		EditingBuffer.BufferedCondition.get(GlobalV.currentEdittingButton).nextPage = Integer.parseInt(G_Event.ConditionPage.getText());
		
		int id =LookUp.EventNameMap.get(G_Event.ConditionEvent.getText());
				
		EditingBuffer.BufferedCondition.get(GlobalV.currentEdittingButton).nextEventIndex =	id;
		
		G_Event.EventEditingPanel.removeAll();
		G_Event.EventEditingPanel.addToMap(G_Event.EventPlacePanel.getDepth(), G_Event.EventPlacePanel);
		G_Event.EventEditingPanel.map.remove(G_Event.ConditionPanel.getDepth());
		G_Event.EventEditingPanel.addThings();
		G_Event.EventEditingPanel.repaint();			
		
	}

}
