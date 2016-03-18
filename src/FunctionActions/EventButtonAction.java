package FunctionActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventButtonAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//GlobalV.CurrentFun ++;
		//System.out.println(GlobalV.CurrentFun);
		System.out.println("This is " + arg0.getActionCommand());

	}
}
