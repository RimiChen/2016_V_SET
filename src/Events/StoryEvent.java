package Events;

import java.util.ArrayList;
import java.util.List;

import Variables.LookUp;

public class StoryEvent {
	public int index;
	public String eventName;
	
	//place
	public String place;
	//dialogue
	public List<StoryDialogue> dialogueQueue;
	
	public StoryEvent( int index){
		System.out.println("System: Event "+ index +" was created");
		this.index = index;
		this.eventName = "event" +index;
		
		//initial
		this.place = LookUp.PlaceMap.get(0);
		dialogueQueue = new ArrayList<StoryDialogue>();
		
	}
	
}
