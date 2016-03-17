package Events;

import javax.swing.Timer;

import FunctionActions.MainFrameActions;
import MainScreen.MainFrame;
import Variables.GlobalV;

public class DragFrame extends MainFrame{

	public MainFrameActions mainAct;
	public int depth;
	public boolean isClock;

	public  Timer clock;
	
	public DragFrame(int WindowX, int WindowY, int WindowWidth, int WindowHeight, int depth, boolean isClock){
		super(0);
		
		this.depth = depth;
		this.isClock = isClock;
		
		setLocation(WindowX, WindowY);
		setSize( WindowWidth, WindowHeight);	
		
		
		mainAct = new MainFrameActions();
		clock = new Timer(GlobalV.ClockDelay, mainAct);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(isClock == true){
			clock.start();
		}

	}	
	public int getDepth(){
		return depth;
	}
}
