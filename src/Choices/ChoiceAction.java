package Choices;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Display.G_Display;
import Variables.GlobalV;
import Variables.LookUp;

public class ChoiceAction  implements ActionListener{
	public int index;
	
	public ChoiceAction(int index){
		this.index = index;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//GlobalV.isEditting = false;
		System.out.println("System: IN event "+LookUp.EventMap.get(GlobalV.currentDisplayEvent).eventName +"  choose choice "+ index);
		GlobalV.DisplayDialogueCount =GlobalV.DisplayDialogueNumber;
		//apply change in choice
		if(LookUp.EventMap.get(GlobalV.currentDisplayEvent).choiceQueue.get(index).variable.equals("")==false){
			//has variable
			String varName = LookUp.EventMap.get(GlobalV.currentDisplayEvent).choiceQueue.get(index).variable;
			if(G_Variables.checkVariableExist(varName)==true){
				//variableMap
				int varIndex = LookUp.VariableNameMap.get(varName);
				//System.out.println("Test value Before"+ G_Variables.variableMap.get(varIndex).getCurrentValue());
				G_Variables.variableMap.get(varIndex).makeChange(LookUp.EventMap.get(GlobalV.currentDisplayEvent).choiceQueue.get(index).operator, LookUp.EventMap.get(GlobalV.currentDisplayEvent).choiceQueue.get(index).value);
				//System.out.println("Test value After"+ G_Variables.variableMap.get(varIndex).getCurrentValue());
			}
		}
		
		//check conditions
		if(LookUp.EventMap.get(GlobalV.currentDisplayEvent).conditionQueue.size()>0){
			for(int i = 0; i < LookUp.EventMap.get(GlobalV.currentDisplayEvent).conditionQueue.size();i++){
				//System.out.println("*** " + LookUp.EventMap.get(GlobalV.currentDisplayEvent).conditionQueue.get(i).variable);
				String varName = LookUp.EventMap.get(GlobalV.currentDisplayEvent).conditionQueue.get(i).variable;
				if(G_Variables.checkVariableExist(varName)==true){
					//variableMap
					int varIndex = LookUp.VariableNameMap.get(varName);
					if(G_Variables.variableMap.get(varIndex).checkMatch( LookUp.EventMap.get(GlobalV.currentDisplayEvent).conditionQueue.get(i).operator, LookUp.EventMap.get(GlobalV.currentDisplayEvent).conditionQueue.get(i).value)==true){
						//condition match
						//System.out.println("Condition "+ i+ " matched.");
						//int eventIndex = LookUp.EventMap.get(GlobalV.currentDisplayEvent).conditionQueue.get(i).nextEventIndex;
						//String name = LookUp.EventMap.get(eventIndex).eventName;
						//int next = LookUp.EventNameMap.get(LookUp.EventMap.get(GlobalV.currentDisplayEvent).conditionQueue.get(i));
						G_Display.DisplayQueue.clear();
						G_Display.DisplayQueue.add(LookUp.EventMap.get(LookUp.EventMap.get(GlobalV.currentDisplayEvent).conditionQueue.get(i).nextEventIndex));
						GlobalV.DisplayDialogueCount = 0;
						//G_Display.DisplayQueue.remove(0);						
					}
				}
			}
		}
		
		G_Display.DialoguePanel.removeAll();
		G_Display.DialoguePanel.addToMap(G_Display.DialogueProgress.getDepth(),G_Display.DialogueProgress);
		G_Display.DialoguePanel.addThings();
		G_Display.BasicFrame.removeAll();
		G_Display.BasicFrame.map.remove(G_Display.ChoicePanel.getDepth());
		G_Display.BasicFrame.addThings();
		G_Display.BasicFrame.repaint();		
		
				
	}

}
