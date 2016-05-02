package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Display.G_Display;
import Variables.GlobalV;
import Variables.LookUp;

public class BackgroundTimerFrameActions2 implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//GlobalV.CurrentFun ++;
		//System.out.println(G_Display.DisplayQueue.size());
		
		G_Display.BasicFrame.setVisible(true);
		G_Display.StoryFrame.repaint();
	
		if(G_Display.DisplayQueue.size()>0){
			if(G_Display.DisplayQueue.get(0).choiceQueue.size()==0){
				//dialogue
				GlobalV.DisplayDialogueNumber = G_Display.DisplayQueue.get(0).dialogueQueue.size();
				GlobalV.currentDisplayEvent = G_Display.DisplayQueue.get(0).index;
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
					//GlobalV.DisplayEventCount++;
					//apply change
					//check condition
					
					if(G_Display.DisplayQueue.get(0).nextEventIndex<0 ){
						//System.out.println("Going to end");
						G_Display.DisplayQueue.remove(0);

					}
					else{
						System.out.println("System: event "+G_Display.DisplayQueue.get(0).eventName+" end. Next is Event "+G_Display.DisplayQueue.get(0).nextEvent+" in page "+ G_Display.DisplayQueue.get(0).nextPage );
						int next = LookUp.EventNameMap.get(G_Display.DisplayQueue.get(0).nextEvent);
						G_Display.DisplayQueue.clear();
						G_Display.DisplayQueue.add(LookUp.EventMap.get(next));
					}
					GlobalV.DisplayDialogueCount = 0;

					
					//jump to next event
				}
			}
			else{
				//choice
				//GlobalV.DisplayEventCount = G_Display.DisplayQueue.get(0).index;
				GlobalV.DisplayDialogueNumber = G_Display.DisplayQueue.get(0).choiceQueue.size();
				GlobalV.currentDisplayEvent = G_Display.DisplayQueue.get(0).index;
				if(GlobalV.DisplayDialogueCount <GlobalV.DisplayDialogueNumber){

						G_Display.displayChoiceInQueueWithButton(GlobalV.DisplayEventCount, GlobalV.DisplayDialogueCount);

				}
				else{
					//GlobalV.DisplayEventCount++;
					//apply change
					//check condition
					
					if(G_Display.DisplayQueue.get(0).nextEventIndex<0 ){
						//System.out.println("Going to end");
						G_Display.DisplayQueue.remove(0);

					}
					else{
						System.out.println("System: event "+G_Display.DisplayQueue.get(0).eventName+" end. Next is Event "+G_Display.DisplayQueue.get(0).nextEvent+" in page "+ G_Display.DisplayQueue.get(0).nextPage );
						//int next = LookUp.EventNameMap.get(G_Display.DisplayQueue.get(0).nextEvent);
						//G_Display.DisplayQueue.clear();
						//G_Display.DisplayQueue.add(LookUp.EventMap.get(next));
					}
					GlobalV.DisplayDialogueCount = 0;
					
					//jump to next event
				}				
			}
			
		}
		else{
			System.out.println("System: story end.");
			G_Display.BackgroundPanel.disableTimer();
			G_Display.DisplayQueue.clear();
			GlobalV.isEditting = false;
		}
/*		
		if(GlobalV.DisplayEventCount <GlobalV.DisplayEventNumber){
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
*/
	}
	
}
