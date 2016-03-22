package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CharaMake.CustomCharacter;
import CharacterScreen.G_Chara;
import MainScreen.G_Components;
import Variables.GlobalV;
import Variables.LookUp;

public class TypeButtonAction implements ActionListener{
	
	CustomCharacter nowChara;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		nowChara = LookUp.CharaMap.get(LookUp.CharaNameMap.get(GlobalV.CurrentEditingChara ));
		
		
		System.out.println("System: "+"Change caracter type of "+nowChara.name +" to  "+arg0.getActionCommand());
		
		nowChara.type = arg0.getActionCommand();
		if(LookUp.MaterialTypeIndex.get(arg0.getActionCommand()) == 0){
			nowChara.imageIndex.clear();
			nowChara.imageIndex.addAll(G_Chara.Man.initCharaImageSet);
		}
		else if(LookUp.MaterialTypeIndex.get(arg0.getActionCommand()) == 1){
			nowChara.imageIndex.clear();
			nowChara.imageIndex.addAll(G_Chara.Woman.initCharaImageSet);
		}
		else if(LookUp.MaterialTypeIndex.get(arg0.getActionCommand()) == 2){
			nowChara.imageIndex.clear();
			nowChara.imageIndex.addAll(G_Chara.Narrator.initCharaImageSet);
		}
		
		G_Chara.updateCharaPanel(nowChara);
		
		LookUp.CharaMap.remove(nowChara.index);
		LookUp.CharaMap.put(nowChara.index, nowChara);
		
		
	}

}
