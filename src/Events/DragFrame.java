package Events;

import javax.swing.Timer;

import FunctionActions.BackgroundTimerFrameActions;
import MainScreen.MainFrame;
import Variables.GlobalV;

@SuppressWarnings("serial")
public class DragFrame extends MainFrame{

	public BackgroundTimerFrameActions mainAct;
	public int depth;
	public boolean isClock;

	public  Timer clock;
	
	//public Rectangle selectionBounds;
	//public Point clickPoint;
	
	public DragFrame(int WindowX, int WindowY, int WindowWidth, int WindowHeight, int depth, boolean isClock){
		super(0);
		
		this.depth = depth;
		this.isClock = isClock;
		
		setLayout(null);
		setLocation(WindowX, WindowY);
		setSize( WindowWidth, WindowHeight);	
		
		
		mainAct = new BackgroundTimerFrameActions();
		clock = new Timer(GlobalV.ClockDelay, mainAct);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(isClock == true){
			clock.start();
		}

	}	
	public int getDepth(){
		return depth;
	}
	public void removeFromMap(int index){
		this.map.remove(index);
	}
}
