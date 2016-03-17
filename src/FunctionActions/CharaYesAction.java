package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import CharaMake.CustomCharacter;
import CharacterScreen.G_Chara;
import MainScreen.CharacterButton;
import MainScreen.G_Components;
import Variables.GlobalV;
import Variables.LookUp;

public class CharaYesAction implements ActionListener{
	
	CustomCharacter nowChara;
	CharacterButton nowButton;
	List<Integer> tempIndex;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("save current charcter change");
		
		// TODO: save character information
		
		//System.out.println("current name "+ GlobalV.CurrentEditingChara);
		
		GlobalV.isEditting = false;
		
		nowChara = LookUp.CharaMap.get(LookUp.CharaNameMap.get(GlobalV.CurrentEditingChara ));
		//System.out.println("---" + nowChara.imageIndex.size());	
		//record images
		
		nowChara.recordedImage.clear();
		//System.out.println("---" + nowChara.imageIndex.size());			
		
		tempIndex = nowChara.imageIndex;
		nowChara.recordedImage.addAll(tempIndex);
		
		//System.out.println("---" + nowChara.imageIndex.size());			

		
		//update name
		nowChara.name = G_Chara.nameField.getText();
		
		int tempIndex;
		tempIndex = LookUp.CharaNameMap.get(GlobalV.CurrentEditingChara);
		//System.out.println("index  "+ tempIndex);
		//put new name in map
		//remove old
		LookUp.CharaNameMap.remove(GlobalV.CurrentEditingChara);
		LookUp.CharaNameMap.put(nowChara.name, tempIndex);

		
		
		nowButton = G_Chara.CharacterButtonMap.get(GlobalV.CurrentEditingChara);
		// remove from panel
		G_Chara.charaButtonPanel.map.remove(nowButton.getDepth());
		//change text
		nowButton.setText(nowChara.name);
		//remove old data
		G_Chara.CharacterButtonMap.remove(GlobalV.CurrentEditingChara);
		//record in map
		G_Chara.CharacterButtonMap.put(nowChara.name, nowButton);

		G_Chara.charaButtonPanel.addToMap(nowButton.getDepth(), nowButton);
		G_Chara.charaButtonPanel.addThings();
		G_Chara.charaButtonPanel.repaint();
	
		G_Components.currentContent.map.clear();
		G_Components.currentContent.removeAll();
		//G_Components.currentContent.addToMap(G_Chara.charaButtonPanel.getDepth(), G_Chara.charaButtonPanel);
		G_Components.currentContent.addToMap(G_Components.mainScreen.getDepth(), G_Components.mainScreen);
		G_Components.currentContent.addThings();
		G_Components.currentContent.repaint();
	
		System.out.println("System: "+"Chara " +nowChara.name+ " info saved.");
	}

}
