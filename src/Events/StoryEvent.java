package Events;

import java.util.ArrayList;
import java.util.List;

import Choices.StoryChoice;
import Conditions.StoryCondition;
import Variables.GlobalV;
import Variables.LookUp;

public class StoryEvent {
	public int index;
	public String eventName;
	
	//place
	public String tempPlace;
	public String place;
	//dialogue
	public List<StoryDialogue> dialogueQueue;
	public List<StoryChoice> choiceQueue;

	public int nextPage;
	public int nextEventIndex;
	public String nextEvent;
	
	public String influencedVariable;
	public String operator; // + or - or =
	public String value;
	
	public List<StoryCondition> conditionQueue;
	
	public int choiceChara;
	
	public boolean isDialogue = true;
	public boolean isChoice = true;
	
	
	public StoryEvent( int index, int startY){
		//default will go to next event
	
		influencedVariable = "";
		operator = ""; // + or - or =
		value ="";
		
		System.out.println("System: Event "+ index +" was created");
		this.index = index;
		this.eventName = "event" +index;
		
		
		
		//initial
		this.place = LookUp.PlaceMap.get(0);
		this.tempPlace = LookUp.PlaceMap.get(0);
		dialogueQueue = new ArrayList<StoryDialogue>();
		conditionQueue = new ArrayList<StoryCondition>();
		choiceQueue = new ArrayList<StoryChoice>() ;
		//if next event is empty, default to next event
		nextPage = GlobalV.CurrentEdittingPage;
		nextEventIndex = G_Event.getNextEvent(startY);
		nextEvent = "";
		
		if(nextEventIndex <0){
			System.out.println("next is page" +nextPage  +" event: null");
		}
		else{
			System.out.println("next is page" +nextPage  +" event: "+LookUp.EventMap.get(nextEventIndex).eventName);
		}
		influencedVariable = "Test";
		operator ="+"; // + or - or =
		value ="30";		
		
		choiceChara = 0;
		
	}
	public void setTransfer(int PageNumber, String EventName){
		nextPage = PageNumber;
		nextEvent = EventName;
	}
	public boolean hasNextEvent(){
		if(nextPage <= 0 || nextEvent == ""){
			return false;
		}
		else{
			return true;
		}
	}

	
	
}
