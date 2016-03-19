package FunctionActions;

import javax.swing.event.ListSelectionEvent;

import Events.DialogueMenu;
import Events.G_Event;
import Events.GivenMenu;
import Variables.GlobalV;
import Variables.LookUp;

public class DialogueCharaAction extends GivanMenuAction{

	int dialogueIndex;
	
	public DialogueCharaAction(DialogueMenu targetList, int dialogueIndex) {
		super(targetList);
		this.dialogueIndex = dialogueIndex;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
        if(arg0.getValueIsAdjusting()){  
    		//System.out.println("New From list "+targetList.getSelectedValue());
        	int temp = LookUp.CharaNameMap.get(targetList.getSelectedValue());
        	GlobalV.BufferedDialogue.get(dialogueIndex).tempCharaIndex = temp;
           	
        }  		
	}	

}
