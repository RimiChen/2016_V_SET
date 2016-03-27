package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CharaMake.CustomCharacter;
import CharacterScreen.G_Chara;
import Variables.GlobalV;
import Variables.LookUp;

public class ImageDownAction implements ActionListener{

	int index;
	CustomCharacter nowChara;
	
	public ImageDownAction(int Index){
		this.index = Index;

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("System: "+ LookUp.FeatureName.get(index) + " changed to next ");
		nowChara = LookUp.CharaMap.get(LookUp.CharaNameMap.get(GlobalV.CurrentEditingChara ));
		nowChara = G_Chara.getNextPic(index, nowChara);
	
		//System.out.println("type = " + nowChara.type);
		// upadte character
		LookUp.CharaMap.put(nowChara.index, nowChara);
		G_Chara.updateCharaPanel(nowChara);
		
	}
}