package Events;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.Timer;

import FunctionActions.MainFrameActions;
import MainScreen.MainFrame;
import Variables.GlobalV;

public class DragFrame extends MainFrame{

	public MainFrameActions mainAct;
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
	public void removeFromMap(int index){
		this.map.remove(index);
	}
}