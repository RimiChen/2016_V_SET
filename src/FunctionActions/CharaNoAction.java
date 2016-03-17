package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CharacterScreen.G_Chara;
import MainScreen.G_Components;
import Variables.GlobalV;

public class CharaNoAction implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("cancel editing character");
		
		// TODO: back to main menu
		G_Components.currentContent.map.clear();
		G_Components.currentContent.removeAll();
		G_Components.currentContent.addToMap(G_Chara.charaButtonPanel.getDepth(), G_Chara.charaButtonPanel);
		G_Components.currentContent.addThings();
		G_Components.currentContent.repaint();
		
		GlobalV.isEditting = false;
	
		
	}

}
