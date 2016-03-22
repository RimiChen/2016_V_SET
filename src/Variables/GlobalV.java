package Variables;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import CharaMake.CustomCharacter;
import Events.StoryDialogue;
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
	
	public static int NumberEventPage;
	public static int CurrentEdittingPage;
	
	public static int NumberEvent;
	public static String CurrentEditingEvent;
	public static List<StoryDialogue> BufferedDialogue;
	
	public static String CurrentChosenPlace;
	
	public static int DisplayEventCount;
	public static int DisplayEventNumber;
	public static int DisplayDialogueCount;
	public static int DisplayDialogueNumber;
	
	public static String CurrentEditingType;


	
	public GlobalV(){
		
		
		UsablePropotion = 95;
		WindowWidth = 1000;
		WindowHeight = 600;
		UsableWidth = WindowWidth *UsablePropotion /100; 
		UsableHeight = WindowHeight *UsablePropotion /100;	
		
		isEditting = false;
		NumberFeatures = 13;

		
		ClockDelay = 800;
		
		MenuPropotion = 5;
		NumberOfFunctions = 8;
		
		CurrentFun = 0;
		
		CharaNumber = 0;

		CharaPropotion = 10;
		CurrentEditingChara = "";
		
		CurrentEditingType = "";
		
		//initial is 1
		NumberEventPage = 1;
		CurrentEdittingPage = 1;
		
		// initial is 0
		NumberEvent = 0;
		CurrentEditingEvent = "";
		BufferedDialogue = new ArrayList<StoryDialogue>();
		
		//initial place
		CurrentChosenPlace = LookUp.PlaceMap.get(0);
		//System.out.println("initial place = " + LookUp.PlaceMap.get(0));
		
		
		// parameter for display
		DisplayEventCount = 0;
		DisplayDialogueCount = 0;
		
		DisplayEventNumber = 0;
		DisplayDialogueNumber = 0;
		
	}
	

}
