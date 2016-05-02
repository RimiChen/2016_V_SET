package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Display.G_Display;
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
			//System.out.println("System: event "+G_Display.DisplayQueue.get(GlobalV.DisplayEventCount).eventName+" end. Next is Event "+G_Display.DisplayQueue.get(GlobalV.DisplayEventCount).nextEvent+" in page "+ G_Display.DisplayQueue.get(GlobalV.DisplayEventCount).nextPage );

			GlobalV.DisplayDialogueNumber = G_Display.DisplayQueue.get(GlobalV.DisplayEventCount).dialogueQueue.size();

			//System.out.println(GlobalV.DisplayEventCount+", "+GlobalV.DisplayEventNumber +" ---"+ GlobalV.DisplayDialogueCount+", "+GlobalV.DisplayDialogueNumber);
			
			if(GlobalV.DisplayDialogueCount <GlobalV.DisplayDialogueNumber){
				if(GlobalV.displayButtonMode == 0){
				
					G_Display.displayEventInQueueWithTimer(GlobalV.DisplayEventCount, GlobalV.DisplayDialogueCount);
					GlobalV.DisplayDialogueCount++;
				}
				else{
					G_Display.displayEventInQueueWithButton(GlobalV.DisplayEventCount, GlobalV.DisplayDialogueCount);
				}
			}
			else if(GlobalV.DisplayDialogueCount == GlobalV.DisplayDialogueNumber){

				GlobalV.DisplayEventCount++;
				GlobalV.DisplayDialogueCount = 0;
			}
		}
		else{
			G_Display.BackgroundPanel.disableTimer();
			//GlobalV.DisplayEventNumber = 0;
			G_Display.DisplayQueue.clear();
			GlobalV.isEditting = false;
		}
	}
}
