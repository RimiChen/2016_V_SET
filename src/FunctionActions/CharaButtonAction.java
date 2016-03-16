package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Screen.G_Chara;
import Screen.G_Components;
import Variables.GlobalV;

public class CharaButtonAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("show this " +arg0.getActionCommand());
		GlobalV.isEditting = true;
		G_Components.currentContent.map.clear();
		G_Components.currentContent.addToMap(G_Chara.charaEdittingPanel.getDepth(), G_Chara.charaEdittingPanel);
		G_Components.currentContent.removeAll();
		G_Components.currentContent.addThings();
		G_Components.currentContent.repaint();
	}

}
