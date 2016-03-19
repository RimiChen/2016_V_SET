package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Display.G_Display;
import Events.G_Event;
import MainScreen.G_Components;
import Variables.GlobalV;

public class BackgroundTimerFrameActions implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//GlobalV.CurrentFun ++;
		//System.out.println(GlobalV.CurrentFun);
		
		G_Display.BasicFrame.setVisible(true);
		G_Display.StoryFrame.repaint();
		if(GlobalV.DisplayEventCount <GlobalV.DisplayEventNumber){
			GlobalV.DisplayDialogueNumber = G_Display.DisplayQueue.get(GlobalV.DisplayEventCount).dialogueQueue.size();

			//System.out.println(GlobalV.DisplayEventCount+", "+GlobalV.DisplayEventNumber +" ---"+ GlobalV.DisplayDialogueCount+", "+GlobalV.DisplayDialogueNumber);
			
			if(GlobalV.DisplayDialogueCount <GlobalV.DisplayDialogueNumber){
				G_Display.displayEventInQueueWithButton(GlobalV.DisplayEventCount, GlobalV.DisplayDialogueCount);
				GlobalV.DisplayDialogueCount++;
			}
			else if(GlobalV.DisplayDialogueCount == GlobalV.DisplayDialogueNumber){
				GlobalV.DisplayEventCount++;
				GlobalV.DisplayDialogueCount = 0;
			}
		}
		else{
			G_Display.BackgroundPanel.disableTimer();
			GlobalV.isEditting = false;
		}
	}
}
