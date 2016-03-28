package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CharaMake.CustomCharacter;
import MainScreen.CharacterButton;
import MainScreen.FunctionButton;
import CharacterScreen.G_Chara;
import Events.G_Event;
import MainScreen.G_Components;
import MainScreen.MainFrame;
import Variables.GlobalV;
import Variables.LookUp;

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
			//initialize
			tempChara = new CustomCharacter(GlobalV.CharaNumber, G_Chara.Man.initCharaImageSet);
			LookUp.CharaMap.put(GlobalV.CharaNumber, tempChara);
			LookUp.CharaNameMap.put(tempChara.name, GlobalV.CharaNumber);
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
		for(int key : LookUp.CharaMap.keySet())
		{
		     System.out.println(key + " : " +LookUp.CharaMap.get(key).name);
		}
	}
	public static void updateButtonSize(){
		int depth;
		for(int key : G_Chara.charaButtonPanel.map.keySet())
		{
			depth = key;
			G_Chara.charaButtonPanel.map.get(key).setLocation(
					G_Chara.charaButtonPanel.getWidth()*(depth-1)/ GlobalV.CharaNumber,
					0
			);
			G_Chara.charaButtonPanel.map.get(key).setSize(G_Chara.charaButtonPanel.getWidth()/ GlobalV.CharaNumber, G_Chara.charaButtonPanel.getHeight()* 90/100);
			
			int tempLocationX = G_Chara.charaButtonPanel.getWidth()*(depth-1)/ GlobalV.CharaNumber;
			int tempSizeX = G_Chara.charaButtonPanel.getWidth()/ GlobalV.CharaNumber;
			
			G_Chara.CharacterButtonMap.get(LookUp.CharaMap.get(key).name).locationX = G_Chara.charaButtonPanel.getWidth()*(depth-1)/ GlobalV.CharaNumber;
			G_Chara.CharacterButtonMap.get(LookUp.CharaMap.get(key).name).locationY = 0;
			G_Chara.CharacterButtonMap.get(LookUp.CharaMap.get(key).name).sizeX = G_Chara.charaButtonPanel.getWidth()/ GlobalV.CharaNumber;
			G_Chara.CharacterButtonMap.get(LookUp.CharaMap.get(key).name).sizeY = G_Chara.charaButtonPanel.getHeight()* 90/100;
			
			G_Chara.CharacterButtonMap.get(LookUp.CharaMap.get(key).name).line.setLocation(tempLocationX + tempSizeX/2 -2, 0);
			
			
			//System.out.println("---" +G_Chara.CharacterButtonMap.get(LookUp.CharaMap.get(key).name).getX());
			//G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).map.get(100+key).setLocation(tempLocationX + tempSizeX/2 -2, 0);
			G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).addToMap(G_Chara.CharacterButtonMap.get(LookUp.CharaMap.get(key).name).line.getDepth(), G_Chara.CharacterButtonMap.get(LookUp.CharaMap.get(key).name).line);
			
			G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).removeAll();
			G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).addThings();
			G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).repaint();
			
		}		
	}

}
