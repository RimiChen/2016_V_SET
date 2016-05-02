package Conditions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import EdittingBuffer.EditingBuffer;
import Events.G_Event;
import Events.StoryEvent;
import MainScreen.G_Components;
import Variables.GlobalV;
import Variables.LookUp;

public class StoryConditionAction implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//GlobalV.isEditting = false;
		G_Event.EventEditingPanel.removeAll();
		//System.out.println("In event "+GlobalV.CurrentEditingEvent+" condition "+ arg0.getActionCommand()+ " is choosen ");
		String eventName = GlobalV.CurrentEditingEvent;
		int eventIndex = LookUp.EventNameMap.get(eventName);
		int buttonID = Integer.parseInt(arg0.getActionCommand().substring(9, arg0.getActionCommand().length()));
		GlobalV.currentEdittingButton = buttonID;
		
		//System.out.println(arg0.getActionCommand().substring(9, arg0.getActionCommand().length()));
		
		
		G_Event.ConditionVariable.setText(EditingBuffer.BufferedCondition.get(GlobalV.currentEdittingButton).variable);
		G_Event.ConditionOper.setText(EditingBuffer.BufferedCondition.get(GlobalV.currentEdittingButton).operator);
		G_Event.ConditionValue.setText(EditingBuffer.BufferedCondition.get(GlobalV.currentEdittingButton).value);
		G_Event.ConditionPage.setText(""+EditingBuffer.BufferedCondition.get(GlobalV.currentEdittingButton).nextPage);
		int id = EditingBuffer.BufferedCondition.get(GlobalV.currentEdittingButton).nextEventIndex;
		G_Event.ConditionEvent.setText(LookUp.EventMap.get(id).eventName);
		
		G_Event.EventEditingPanel.map.remove(G_Event.EventPlacePanel.getDepth());
		G_Event.EventEditingPanel.addToMap(G_Event.ConditionPanel.getDepth(), G_Event.ConditionPanel);
		G_Event.EventEditingPanel.addThings();
		G_Event.EventEditingPanel.repaint();
		
	}

}
