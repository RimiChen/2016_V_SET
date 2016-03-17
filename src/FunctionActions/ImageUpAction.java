package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CharaMake.CustomCharacter;
import CharacterScreen.G_Chara;
import MainScreen.G_Components;
import Variables.GlobalV;
import Variables.LookUp;

public class ImageUpAction implements ActionListener{

	int index;
	CustomCharacter nowChara;
	
	public ImageUpAction(int Index){
		this.index = Index;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(index + " change last");
		nowChara = LookUp.CharaMap.get(LookUp.CharaNameMap.get(GlobalV.CurrentEditingChara ));
		nowChara = G_Chara.getLastPic(index, nowChara);
		
		// upadte character
		LookUp.CharaMap.put(nowChara.index, nowChara);
		G_Chara.updateCharaPanel(nowChara);		
	}
}
