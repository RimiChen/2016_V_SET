package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CharaMake.CustomCharacter;
import Screen.CharacterButton;
import Screen.FunctionButton;
import Screen.G_Chara;
import Screen.G_Components;
import Screen.MainFrame;
import Variables.GlobalV;

public class AddCharaAction implements ActionListener{
	public CustomCharacter tempChara;
	public CharacterButton tempCharaButton;
	public CharaButtonAction tempCharaButtonAct;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//String test = arg0.getActionCommand();
		

		if(GlobalV.isEditting == false){
			// Add new character
			GlobalV.CharaNumber = GlobalV.CharaNumber+1;
			tempChara = new CustomCharacter(GlobalV.CharaNumber);
			GlobalV.CharaMap.put(GlobalV.CharaNumber, tempChara);
			// create Character button
			tempCharaButton = new CharacterButton(
					G_Chara.charaButtonPanel.getWidth()*(tempChara.index-1)/ GlobalV.CharaNumber,
					0 ,
					G_Chara.charaButtonPanel.getWidth()/ GlobalV.CharaNumber,
					G_Chara.charaButtonPanel.getHeight()* 90/100,
					tempChara.index
					);
			tempCharaButton.setVisible(true);
			tempCharaButton.setText(tempChara.name);
			tempCharaButtonAct = new CharaButtonAction();
			tempCharaButton.addActionListener(tempCharaButtonAct);
			G_Chara.CharacterButtonMap.put(tempChara.name, tempCharaButton);
			
			updateButtonSize();
			G_Chara.charaButtonPanel.addToMap(tempCharaButton.getDepth(),G_Chara.CharacterButtonMap.get(tempChara.name));
			G_Chara.charaButtonPanel.removeAll();
			G_Chara.charaButtonPanel.addThings();
			G_Chara.charaButtonPanel.repaint();
			//printAllChara();
		}
		
		
	}
	public void printAllChara(){
		for(int key : GlobalV.CharaMap.keySet())
		{
		     System.out.println(key + " : " +GlobalV.CharaMap.get(key).name);
		}
	}
	public void updateButtonSize(){
		int depth;
		for(int key : G_Chara.charaButtonPanel.map.keySet())
		{
			depth = key;
			G_Chara.charaButtonPanel.map.get(key).setLocation(
					G_Chara.charaButtonPanel.getWidth()*(depth-1)/ GlobalV.CharaNumber,
					0
			);
			G_Chara.charaButtonPanel.map.get(key).setSize(G_Chara.charaButtonPanel.getWidth()/ GlobalV.CharaNumber, G_Chara.charaButtonPanel.getHeight()* 90/100);
		}		
	}

}
