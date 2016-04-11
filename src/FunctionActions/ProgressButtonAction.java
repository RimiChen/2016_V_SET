package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Variables.GlobalV;

public class ProgressButtonAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		GlobalV.DisplayDialogueCount++;
		//System.out.println("Test¡@"+ GlobalV.DisplayDialogueCount);
	}
}