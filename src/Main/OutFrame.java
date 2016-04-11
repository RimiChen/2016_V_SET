package Main;

import FunctionActions.BackgroundTimerFrameActions;
import MainScreen.*;

@SuppressWarnings("serial")
public class OutFrame extends MainFrame{

	public BackgroundTimerFrameActions mainAct;
	//public  Timer clock;
	public OutFrame(int WindowX, int WindowY, int WindowWidth, int WindowHeight){
		super(0);
		mainAct = new BackgroundTimerFrameActions();
		//clock = new Timer(GlobalV.ClockDelay, mainAct);
		setLayout(null);
		setLocation(WindowX, WindowY);
		setSize( WindowWidth, WindowHeight);	
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//clock.start();
	}	
}
