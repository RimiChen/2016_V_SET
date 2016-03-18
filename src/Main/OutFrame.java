package Main;

import java.awt.event.*;

import javax.swing.*;

import FunctionActions.MainFrameActions;
import MainScreen.*;
import Variables.GlobalV;

public class OutFrame extends MainFrame{

	public MainFrameActions mainAct;
	//public  Timer clock;
	public OutFrame(int WindowX, int WindowY, int WindowWidth, int WindowHeight){
		super(0);
		mainAct = new MainFrameActions();
		//clock = new Timer(GlobalV.ClockDelay, mainAct);
		setLayout(null);
		setLocation(WindowX, WindowY);
		setSize( WindowWidth, WindowHeight);	
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//clock.start();
	}	
}
