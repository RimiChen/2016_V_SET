package Events;

import java.util.ArrayList;
import java.util.List;

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
	
	public int nextPage;
	public String nextEvent;
	
	public StoryEvent( int index){
		System.out.println("System: Event "+ index +" was created");
		this.index = index;
		this.eventName = "event" +index;
		
		//initial
		this.place = LookUp.PlaceMap.get(0);
		this.tempPlace = LookUp.PlaceMap.get(0);
		dialogueQueue = new ArrayList<StoryDialogue>();
		nextPage = GlobalV.CurrentEdittingPage;
		nextEvent = "";
		
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
