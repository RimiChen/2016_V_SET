package Events;

import java.awt.Color;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import CharacterScreen.G_Chara;
import FunctionActions.DragPanelMouseAction;
import MainScreen.G_Components;
import MainScreen.GroupFrame;
import Variables.GlobalV;
import Variables.LookUp;

public class G_Event {
	public static GroupFrame StorylinePanel;
	public static Map<Integer, EventPageFrame> EventPageMap;
	public EventPageFrame tempEventPage;
	
	//For drag event
	public static DragFrame DragPanel;
	public DragPanelMouseAction dragAction;
	public static GroupFrame DragFunctionPanel;
	
	public static DragArea region;
	
	
	//public static Map<String, EventButton> EventButtonMap;
	//public static Map<String, EventLabel> EventLabelMap;
	//public static AnimateFrame dragPanel;
	
	

	//public
	
	public G_Event(){
		
		//By default we will have one
		StorylinePanel = new GroupFrame(0, G_Chara.charaButtonPanel.getHeight(), G_Components.currentContent.getWidth(), G_Components.currentContent.getHeight()-G_Chara.charaButtonPanel.getHeight()-30, -1);
		
		DragPanel = new DragFrame(
				0,
				0,
				StorylinePanel.getWidth(),
				StorylinePanel.getHeight(),
				-100,
				false
		);
		DragPanel.setBackground(new Color(0, 255, 255,125));
		dragAction = new DragPanelMouseAction();
		DragPanel.addMouseListener(dragAction);
		DragPanel.addMouseMotionListener(dragAction);		
		//function bar for drag panel
		DragFunctionPanel = new GroupFrame(0, DragPanel.getHeight() *9/10, DragPanel.getWidth(), 50, 0);
		DragFunctionPanel.setBackground(new Color(0, 0, 255, 125));

		region = new DragArea(0 ,0, 100, 100,  1, new Color(0, 0, 255, 100));
		
		DragPanel.addToMap(DragFunctionPanel.getDepth(), DragFunctionPanel);
		//DragPanel.addToMap(region.getDepth(), region);
		DragPanel.addThings();

		
		EventPageMap = new TreeMap<Integer,EventPageFrame>();
		
		// put the first page
		tempEventPage = new EventPageFrame(0, 0, StorylinePanel.getWidth(), StorylinePanel.getHeight(), GlobalV.NumberEventPage, GlobalV.NumberEventPage);
		//tempEventPage.setBackground(new Color(255, 0, 0, 125));
		EventPageMap.put(GlobalV.NumberEventPage, tempEventPage);
		//add event page to storyline
		StorylinePanel.addToMap(EventPageMap.get(GlobalV.CurrentEdittingPage).getDepth(), EventPageMap.get(GlobalV.CurrentEdittingPage));
		StorylinePanel.addThings();
		
		

		
	}
	public static void createNewEvent(int startX, int startY, int width, int height){
		GlobalV.NumberEvent++;
		System.out.println("System: Create Event " + GlobalV.NumberEvent);
		
		StoryEvent tempEvent = new StoryEvent(GlobalV.NumberEvent);
		EventButton tempButton;
		EventLabel tempLabel;
		
		LookUp.EventMap.put(tempEvent.index, tempEvent);
		LookUp.EventNameMap.put(tempEvent.eventName, tempEvent.index);
		LookUp.EventPageMap.put(tempEvent.eventName, GlobalV.CurrentEdittingPage);
		LookUp.EventPositionMap.put(tempEvent.eventName, startY);
		LookUp.EventTimeMap.put(startY, tempEvent.eventName);
		
		tempButton = new EventButton(startX, startY, width, height, tempEvent.index, GlobalV.CurrentEdittingPage, tempEvent.eventName);
		
		EventPageMap.get(GlobalV.CurrentEdittingPage).EventButtonMap.put(tempEvent.eventName, tempButton);

		
		tempLabel = new EventLabel(startX, startY, width, height, tempEvent.index, GlobalV.CurrentEdittingPage, tempEvent.eventName, new Color(0, 0, 255, 255));
		
		EventPageMap.get(GlobalV.CurrentEdittingPage).EventLabelMap.put(tempEvent.eventName, tempLabel);
		paintEventButton();
		
		//printEventMap();
		printEventTime();
	}
	public static void paintEventButton(){
		EventPageMap.get(GlobalV.CurrentEdittingPage).removeAll();
		EventPageMap.get(GlobalV.CurrentEdittingPage).map.clear();
		for(String key : EventPageMap.get(GlobalV.CurrentEdittingPage).EventButtonMap.keySet())
		{
		     //System.out.println(key + " : " +EventPageMap.get(GlobalV.CurrentEdittingPage).EventButtonMap.get(key));
			EventPageMap.get(GlobalV.CurrentEdittingPage).addToMap(
					EventPageMap.get(GlobalV.CurrentEdittingPage).EventButtonMap.get(key).getDepth(),
					EventPageMap.get(GlobalV.CurrentEdittingPage).EventButtonMap.get(key)
			);
		}		
		EventPageMap.get(GlobalV.CurrentEdittingPage).addThings();
		EventPageMap.get(GlobalV.CurrentEdittingPage).repaint();
	}
	
	public static void paintEventLabel(){
		EventPageMap.get(GlobalV.CurrentEdittingPage).removeAll();
		EventPageMap.get(GlobalV.CurrentEdittingPage).map.clear();
		for(String key : EventPageMap.get(GlobalV.CurrentEdittingPage).EventLabelMap.keySet())
		{
		     //System.out.println(key + " : " +EventPageMap.get(GlobalV.CurrentEdittingPage).EventButtonMap.get(key));
			EventPageMap.get(GlobalV.CurrentEdittingPage).addToMap(
					EventPageMap.get(GlobalV.CurrentEdittingPage).EventLabelMap.get(key).getDepth(),
					EventPageMap.get(GlobalV.CurrentEdittingPage).EventLabelMap.get(key)
			);
		}		
		EventPageMap.get(GlobalV.CurrentEdittingPage).addThings();
		EventPageMap.get(GlobalV.CurrentEdittingPage).repaint();
	}
	
	public static void changeEventName(String name, int index)
	{
		
	}
	public static void printEventTime(){
		for(int key : LookUp.EventTimeMap.keySet())
		{
		     System.out.println(key + " : " +LookUp.EventTimeMap.get(key));
		}		
	}
	public static void printEventMap(){
		for(int key : LookUp.EventMap.keySet())
		{
		     System.out.println(key + " : " +LookUp.EventMap.get(key));
		}		
	}
	
	
	
}
