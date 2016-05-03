package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Conditions.StoryCondition;
import EdittingBuffer.EditingBuffer;
import Events.G_Event;
import Events.StoryEvent;
import Variables.GlobalV;
import Variables.LookUp;

public class EventConditionAddAction  implements ActionListener{

	StoryEvent nowEvent;
	StoryCondition tempCondition;
	int numberInAPage;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		numberInAPage = GlobalV.MaxConditionNumber;
		
		nowEvent = LookUp.EventMap.get(LookUp.EventNameMap.get(GlobalV.CurrentEditingEvent));
		if(EditingBuffer.BufferedCondition.size() == 0){
			tempCondition = new StoryCondition(0, 2, G_Event.EventConditionListPanel.getWidth(), G_Event.EventConditionListPanel.getHeight()/numberInAPage-4, EditingBuffer.BufferedCondition.size(),EditingBuffer.BufferedCondition.size());
			EditingBuffer.BufferedCondition.add(tempCondition);
			int current = EditingBuffer.BufferedCondition.size();
			G_Event.EventConditionListPanel.removeAll();
			G_Event.EventConditionListPanel.addToMap(EditingBuffer.BufferedCondition.get(current-1).getDepth(), EditingBuffer.BufferedCondition.get(current-1));
			G_Event.EventConditionListPanel.addThings();
			G_Event.EventConditionListPanel.repaint();
		}
		else{
			int current = EditingBuffer.BufferedCondition.size();
			tempCondition = new StoryCondition(
					0,
					EditingBuffer.BufferedCondition.get(current-1).getY()+EditingBuffer.BufferedCondition.get(current-1).getHeight()+1,
					G_Event.EventConditionListPanel.getWidth(),
					G_Event.EventConditionListPanel.getHeight()/numberInAPage-4,
					EditingBuffer.BufferedCondition.size(),
					EditingBuffer.BufferedCondition.size()
			);
			EditingBuffer.BufferedCondition.add(tempCondition);
			current = EditingBuffer.BufferedCondition.size();
			G_Event.EventConditionListPanel.removeAll();
			G_Event.EventConditionListPanel.addToMap(EditingBuffer.BufferedCondition.get(current-1).getDepth(), EditingBuffer.BufferedCondition.get(current-1));
			G_Event.EventConditionListPanel.addThings();
			G_Event.EventConditionListPanel.repaint();			
		}

	}

}
