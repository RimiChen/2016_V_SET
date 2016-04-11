package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CharaMake.CustomCharacter;
import MainScreen.G_Components;
import Variables.GlobalV;
import Variables.LookUp;

public class CharaNoAction implements ActionListener{
	
	CustomCharacter nowChara;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		nowChara = LookUp.CharaMap.get(LookUp.CharaNameMap.get(GlobalV.CurrentEditingChara ));
		
		
		System.out.println("System: "+"Cancel editing Character "+nowChara.name);
		
		
		
		// TODO: back to main menu
		G_Components.currentContent.map.clear();
		G_Components.currentContent.removeAll();
		G_Components.currentContent.addToMap(G_Components.mainScreen.getDepth(), G_Components.mainScreen);
		G_Components.currentContent.addThings();
		G_Components.currentContent.repaint();
		
		GlobalV.isEditting = false;
	
		
	}

}
