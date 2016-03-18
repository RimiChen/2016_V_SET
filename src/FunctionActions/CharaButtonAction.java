package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CharaMake.CustomCharacter;
import CharacterScreen.G_Chara;
import MainScreen.G_Components;
import Variables.GlobalV;
import Variables.LookUp;

public class CharaButtonAction implements ActionListener{
	CustomCharacter nowChara;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(GlobalV.isEditting == false){
			System.out.println("System: "+ "Now editing Character " +arg0.getActionCommand().toString());
			
			// set editing = true
			GlobalV.isEditting = true;
			
			G_Components.currentContent.map.clear();
			G_Components.currentContent.addToMap(G_Chara.charaEdittingPanel.getDepth(), G_Chara.charaEdittingPanel);
			G_Components.currentContent.removeAll();
			G_Components.currentContent.addThings();
			G_Components.currentContent.repaint();
			
			//current editing
			GlobalV.CurrentEditingChara = arg0.getActionCommand();
			//printMap();
			//printMap2();
			nowChara = LookUp.CharaMap.get(LookUp.CharaNameMap.get(GlobalV.CurrentEditingChara ));
			//System.out.println("now edit "+nowChara.name);
			G_Chara.nameField.setText(nowChara.name);
			//initial character editting panel
			G_Chara.updateCharaPanel(nowChara);
		}

		
	}
	public void printMap(){
		for(int key : LookUp.CharaMap.keySet())
		{
		     System.out.println(key + " : " +LookUp.CharaMap.get(key).name);
		}
	}
	public void printMap2(){
		for(String key : LookUp.CharaNameMap.keySet())
		{
		     System.out.println(key + " : " +LookUp.CharaNameMap.get(key));
		}
	}
}
