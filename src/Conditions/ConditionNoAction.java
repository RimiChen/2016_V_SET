package Conditions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import EdittingBuffer.EditingBuffer;
import Events.G_Event;
import MainScreen.G_Components;
import Variables.GlobalV;

public class ConditionNoAction  implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//GlobalV.isEditting = false;

				
		
		G_Event.EventEditingPanel.removeAll();
		G_Event.EventEditingPanel.addToMap(G_Event.EventPlacePanel.getDepth(), G_Event.EventPlacePanel);
		G_Event.EventEditingPanel.map.remove(G_Event.ConditionPanel.getDepth());
		G_Event.EventEditingPanel.addThings();
		G_Event.EventEditingPanel.repaint();	
		
	}

}
