package Events;

import java.awt.Color;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import CharacterScreen.G_Chara;
import MainScreen.G_Components;
import MainScreen.GroupFrame;
import Variables.GlobalV;

public class G_Event {
	public static GroupFrame StorylinePanel;
	public static Map<Integer, EventPageFrame> EventPageMap;
	public EventPageFrame tempEventPage;
	
	//For drag event
	public static DragFrame DragPanel;
	public static GroupFrame DragFunctionPanel;
	
	
	public static Map<String, EventButton> EventButtonMap;
	public static Map<String, EventLabel> EventLabelMap;
	//public static AnimateFrame dragPanel;
	
	

	//public
	
	public G_Event(){
		
		//By default we will have one
		StorylinePanel = new GroupFrame(0, 0, G_Components.currentContent.getWidth(), G_Components.currentContent.getHeight()-G_Chara.charaButtonPanel.getHeight()-30, -1);
		
		DragPanel = new DragFrame(
				0,
				0,
				StorylinePanel.getWidth(),
				StorylinePanel.getHeight(),
				-100,
				true
		);
		DragPanel.setBackground(new Color(0, 255, 255,125));
		//function bar for drag panel
		DragFunctionPanel = new GroupFrame(0, 0, DragPanel.getWidth(), 50, 0);
		DragFunctionPanel.setBackground(new Color(0, 0, 255, 125));
		
		DragPanel.addToMap(DragFunctionPanel.getDepth(), DragFunctionPanel);
		DragPanel.addThings();

		
		EventPageMap = new TreeMap<Integer,EventPageFrame>();
		
		// put the first page
		tempEventPage = new EventPageFrame(0, 0, StorylinePanel.getWidth(), StorylinePanel.getHeight(), GlobalV.NumberEventPage, GlobalV.NumberEventPage);
		//tempEventPage.setBackground(new Color(255, 0, 0, 125));
		EventPageMap.put(GlobalV.NumberEventPage, tempEventPage);
		//add event page to storyline
		StorylinePanel.addToMap(EventPageMap.get(GlobalV.CurrentEdittingPage).getDepth(), EventPageMap.get(GlobalV.CurrentEdittingPage));
		StorylinePanel.addThings();
		
		
		//each event have a event object, and a label, a button for display
		EventButtonMap = new TreeMap<String, EventButton>();
		EventLabelMap = new TreeMap<String, EventLabel>();
		
	}
	
	
	
	
}
