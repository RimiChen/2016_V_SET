package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import Display.G_Display;

import Variables.GlobalV;


public class CompileAction implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(GlobalV.isEditting == false){
			G_Display.compileStory();
		}
		
	}

}
