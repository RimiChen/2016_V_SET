package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MainScreen.G_Components;
import Variables.GlobalV;

public class MainFrameActions implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		GlobalV.CurrentFun ++;
		System.out.println(GlobalV.CurrentFun);
	}

}
