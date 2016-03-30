package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CharaMake.CustomCharacter;
import CharacterScreen.G_Chara;
import Variables.GlobalV;
import Variables.LookUp;

public class ProgressButtonAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		GlobalV.DisplayDialogueCount++;
		//System.out.println("Test¡@"+ GlobalV.DisplayDialogueCount);
	}
}