package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Events.G_Event;
import Variables.GlobalV;

public class EventPageUpAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(GlobalV.CurrentEdittingPage < GlobalV.NumberEventPage){
			G_Event.StorylinePanel.map.remove(G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).getDepth());
			
			GlobalV.CurrentEdittingPage++;
			G_Event.StorylinePanel.addToMap(G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).getDepth(), G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage));			
			System.out.println("Current page: " +GlobalV.CurrentEdittingPage);
			G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage-1).removeAll();
			G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage-1).repaint();
			G_Event.paintEventButton();
			G_Event.StorylinePanel.removeAll();
			G_Event.StorylinePanel.addThings();			
			G_Event.StorylinePanel.repaint();
			
		}
	}
}