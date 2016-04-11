package Variables;



public class GlobalV {
	public static int WindowWidth;
	public static int WindowHeight;
	public static int UsableWidth;
	public static int UsableHeight;
	public static int DisplayWidth;
	public static int DisplayHeight;
	
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

	public static String CurrentChosenPlace;
	
	public static int DisplayEventCount;
	public static int DisplayEventNumber;
	public static int DisplayDialogueCount;
	public static int DisplayDialogueNumber;
	public static int MaxDialogueNumber;
	
	public static String CurrentEditingType;
	
	public static int displayButtonMode;


	
	public GlobalV(){
		
		
		UsablePropotion = 95;
		WindowWidth = 1000;
		WindowHeight = 800;
		UsableWidth = WindowWidth *UsablePropotion /100; 
		UsableHeight = WindowHeight *UsablePropotion /100;
		
		DisplayWidth = 800;
		DisplayHeight = 600;
		
		
		isEditting = false;
		NumberFeatures = 13;

		
		ClockDelay = 1000;
		
		MenuPropotion = 5;
		NumberOfFunctions = 9;
		
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

		
		//initial place
		CurrentChosenPlace = LookUp.PlaceMap.get(0);
		//System.out.println("initial place = " + LookUp.PlaceMap.get(0));
		
		MaxDialogueNumber = 4;
		
		// parameter for display
		DisplayEventCount = 0;
		DisplayDialogueCount = 0;
		
		DisplayEventNumber = 0;
		DisplayDialogueNumber = 0;
		
		// 0 timer, 1 button
		displayButtonMode = 1;
	}
	

}
