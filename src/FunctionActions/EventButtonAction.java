package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Events.G_Event;
import MainScreen.G_Components;
import Variables.GlobalV;

public class EventButtonAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//GlobalV.CurrentFun ++;
		//System.out.println(GlobalV.CurrentFun);
		//System.out.println("This is " + arg0.getActionCommand());
		GlobalV.isEditting = true;
		
		G_Event.EventName.setText(arg0.getActionCommand());
		G_Event.EventNamePanel.repaint();
		
		G_Components.currentContent.map.clear();
		G_Components.currentContent.removeAll();
		G_Components.currentContent.addToMap(G_Event.EventEditingPanel.getDepth(), G_Event.EventEditingPanel);
		G_Components.currentContent.addThings();
		G_Components.currentContent.repaint();
		G_Components.mainFrame.repaint();

	}
}
