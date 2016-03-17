package Variables;

import java.util.Map;
import java.util.TreeMap;

import CharaMake.CustomCharacter;
import Main.*;

public class GlobalV {
	public static int WindowWidth;
	public static int WindowHeight;
	public static int UsableWidth;
	public static int UsableHeight;
	
	public static int UsablePropotion;
	
	public static int ClockDelay;
	
	public static int CurrentFun;
	
	public static int MenuPropotion;
	
	public static int NumberOfFunctions;
	
	public static int CharaNumber;

	public static int CharaPropotion;
	public static String CurrentEditingChara;
	
	public static boolean isEditting;
	
	public static int NumberFeatures;


	
	public GlobalV(){
		
		
		UsablePropotion = 95;
		WindowWidth = 800;
		WindowHeight = 600;
		UsableWidth = WindowWidth *UsablePropotion /100; 
		UsableHeight = WindowHeight *UsablePropotion /100;	
		
		isEditting = false;
		NumberFeatures = 13;

		
		ClockDelay = 100;
		
		MenuPropotion = 5;
		NumberOfFunctions = 8;
		
		CurrentFun = 0;
		
		CharaNumber = 0;

		CharaPropotion = 10;
		CurrentEditingChara = "";
		
		
		
		
	}
	

}
