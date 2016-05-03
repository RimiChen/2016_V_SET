package Events;

import java.awt.Color;
import java.awt.Image;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.ImageIcon;

import CharacterScreen.G_Chara;
import Conditions.ConditionNoButton;
import Conditions.ConditionYesButton;
import FunctionActions.DragPanelMouseAction;
import FunctionActions.MovePanelMouseAction;
import FunctionActions.PlaceMenuAction;
import ImageMaterial.G_Material;
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
	
	public static DragFrame MovePanel;
	public MovePanelMouseAction moveAction;
	
	
	public static DragArea region;
	
	//event editting
	public static GroupFrame EventEditingPanel;
	
	//Event editing panel
	// event name
	public static GroupFrame EventNamePanel;
	public static EventNameField EventName;
	
	// jump from event to event
	public static GroupFrame EventJumpField;
	public static SubLabel EventJumpTitle;
	
	public static SubLabel EventJumpPage0;
	public static SubTextField EventJumpPage;
	public static SubLabel EventJump0;
	public static SubTextField EventJump;

	//influence variables
	public static GroupFrame EventVariableField;
	public static SubLabel EventVariableTitle;
	public static SubLabel EventVariableName0;
	public static SubTextField EventVariableName;
	public static SubLabel EventVariableOperator0;
	public static SubTextField EventVariableOperator;
	public static SubLabel EventVariableValue0;
	public static SubTextField EventVariableValue;
	
	
	//checked conditions
	public static GroupFrame EventConditionPanel;
	public static SubLabel EventConditionTitle;
	public static EventConditionAddButton EventAddCondition;
	public static GroupFrame EventConditionListPanel;
	
	public static GroupFrame EventConditionEdittingPanel;
	
	
	
	
	
	// function button
	public static GroupFrame EventFunPanel;
	public EventYesButton EventYes;
	public EventNoButton EventNo;
	
	//Place panel
	public static GroupFrame EventPlacePanel;
	public static SubLabel PlaceImageLabel;
	public static SubLabel PlaceTextLabel;
	public static GivenMenu PlaceMenu;
	
	//Dialogue function panel
	public static GroupFrame DialogueFunctionPanel;
	public static DialogueAddButton DialogueAdd;
	public static ChoiceAddButton ChoiceAdd;
	
	//Dialogue panel
	public static GroupFrame ContentOutPanel;
	public static GroupFrame DialoguePanel;
	public static GroupFrame ChoiceOutPanel;
	public static GroupFrame ChoicePanel;
	public static GroupFrame ChoiceNamePanel;
	
	//public static Condition panel
	public static GroupFrame ConditionPanel;
	public static GroupFrame ConditionContentPanel;
	public static GroupFrame ConditionFunctionPanel;
	public static ConditionNoButton ConditionNo;
	public static ConditionYesButton ConditionYes;
	
	
	public static SubLabel ConditionVariable0;
	public static SubTextField ConditionVariable;
	public static SubLabel ConditionOper0;
	public static SubTextField  ConditionOper;
	public static SubLabel ConditionValue0;
	public static SubTextField ConditionValue;
	public static SubLabel ConditionPage0;
	public static SubTextField ConditionPage;
	public static SubLabel ConditionEvent0;
	public static SubTextField ConditionEvent;
	
	
	
	

	

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

		//move panel
		MovePanel = new DragFrame(
				0,
				0,
				StorylinePanel.getWidth(),
				StorylinePanel.getHeight(),
				-150,
				false
		);		
		MovePanel.setBackground(new Color(255, 255,0,125));
		moveAction = new MovePanelMouseAction();
		MovePanel.addMouseListener(moveAction);
		MovePanel.addMouseMotionListener(moveAction);		
		
		
		
		
		
		EventPageMap = new TreeMap<Integer,EventPageFrame>();
		
		// put the first page
		tempEventPage = new EventPageFrame(0, 0, StorylinePanel.getWidth(), StorylinePanel.getHeight(), GlobalV.NumberEventPage, GlobalV.NumberEventPage);
		//tempEventPage.setBackground(new Color(255, 0, 0, 125));
		EventPageMap.put(GlobalV.NumberEventPage, tempEventPage);
		//add event page to storyline
		StorylinePanel.addToMap(EventPageMap.get(GlobalV.CurrentEdittingPage).getDepth(), EventPageMap.get(GlobalV.CurrentEdittingPage));
		StorylinePanel.addThings();
		
		
		/*
		 * Event editing panel
		 */
		EventEditingPanel = new GroupFrame(0,0, G_Components.currentContent.getWidth(), G_Components.currentContent.getHeight(), 0);
		EventEditingPanel.setBackground(new Color(255, 255, 0, 125));
		
		//event name
		EventNamePanel = new GroupFrame(0, 0, 100, 30, 0);
		EventNamePanel.setBackground(new Color(255, 0, 0));
		EventName = new EventNameField(EventNamePanel.getX(), EventNamePanel.getY(), EventNamePanel.getWidth(), EventNamePanel.getHeight(), 0);
		EventNamePanel.addToMap(EventName.getDepth(), EventName);
		EventNamePanel.addThings();

		EventEditingPanel.addToMap(EventNamePanel.getDepth(), EventNamePanel);
		
		// function button
		EventFunPanel = new GroupFrame(EventNamePanel.getWidth()+10, 0, 200, 30, 1);
		EventFunPanel.setBackground(new Color(255, 0, 0));
		EventFunPanel.setOpaque(true);
		EventYes = new EventYesButton(0, 0, 100, EventFunPanel.getHeight(), 0);
		EventYes.setText("Save");
		EventFunPanel.addToMap(EventYes.getDepth(), EventYes);
		EventNo = new EventNoButton(100, 0, 100, EventFunPanel.getHeight(), 1);
		EventNo.setText("Cancel");
		EventFunPanel.addToMap(EventNo.getDepth(), EventNo);
		EventFunPanel.addThings();

		EventEditingPanel.addToMap(EventFunPanel.getDepth(), EventFunPanel);
		
		//Place panel
		EventPlacePanel = new GroupFrame(EventEditingPanel.getWidth()*2/4, 10 , EventEditingPanel.getWidth()*2/4, EventEditingPanel.getHeight()/4, 2);
		EventPlacePanel.setBackground(new Color(255, 0, 0));
		//public SubLabel(int LocationX, int LocationY, int SizeX, int SizeY, int Depth, String text, Color color, boolean opaque)
		PlaceTextLabel = new SubLabel(0, 0, 100, 30, 0, "Place", new Color(0, 255, 255, 255), true);
		EventPlacePanel.addToMap(PlaceTextLabel.getDepth(), PlaceTextLabel);
		PlaceImageLabel = new SubLabel(PlaceTextLabel.getWidth(), 0, EventPlacePanel.getWidth() - PlaceTextLabel.getWidth(), EventPlacePanel.getHeight(), 1, "This is image", new Color(255, 255,0, 255), true);
		setPlacePreview(GlobalV.CurrentChosenPlace);
		EventPlacePanel.addToMap(PlaceImageLabel.getDepth(), PlaceImageLabel);
		
		//Should be used in this order
		PlaceMenu = new GivenMenu(0, PlaceTextLabel.getHeight(), PlaceTextLabel.getWidth(), EventPlacePanel.getHeight() - PlaceTextLabel.getHeight(), 2, "Place", LookUp.PlaceNameMap);		
		PlaceMenuAction placeAct = new PlaceMenuAction(PlaceMenu);
		PlaceMenu.setAction(placeAct);
		EventPlacePanel.addToMap(PlaceMenu.getDepth(), PlaceMenu);

		EventPlacePanel.addThings();
		
		EventEditingPanel.addToMap(EventPlacePanel.getDepth(), EventPlacePanel);
		
		

		//Dialogue panel
		ContentOutPanel = new GroupFrame(0, EventEditingPanel.getHeight()/4+30 , EventEditingPanel.getWidth(), EventEditingPanel.getHeight()*3/4 - 30, 3);
		DialoguePanel = new GroupFrame(0, 0 , ContentOutPanel.getWidth(), ContentOutPanel.getHeight(), 0);
		//DialoguePanel.setBackground(new Color(255, 0, 0));
		//DialoguePanel.setOpaque(true);
		ChoiceOutPanel = new GroupFrame(0, 0 , ContentOutPanel.getWidth(), ContentOutPanel.getHeight(), -1);
		//ChoiceOutPanel.setBackground(new Color(0,0, 255, 255));
		//ChoiceOutPanel.setOpaque(true);
		
		ChoicePanel = new GroupFrame(0, 0 , ContentOutPanel.getWidth()*4/5, ContentOutPanel.getHeight(), 0);
		//ChoicePanel.setBackground(new Color(0,0, 255, 100));
		//ChoicePanel.setOpaque(true);
		
		ChoiceNamePanel = new GroupFrame(ChoicePanel.getWidth(), 0 , ChoiceOutPanel.getWidth()/4, ChoiceOutPanel.getHeight(), 1);
		//ChoicePanel.setBackground(new Color(0,255, 255, 100));
		//ChoicePanel.setOpaque(true);

		ChoiceOutPanel.addToMap(ChoicePanel.getDepth(), ChoicePanel);
		ChoiceOutPanel.addToMap(ChoiceNamePanel.getDepth(), ChoiceNamePanel);
		ChoiceOutPanel.addThings();
		
		ContentOutPanel.addToMap(DialoguePanel.getDepth(), DialoguePanel);
		ContentOutPanel.addThings();
		
		//DialoguePanel.setOpaque(true);
		EventEditingPanel.addToMap(ContentOutPanel.getDepth(), ContentOutPanel);

		//Dialogue function panel
		DialogueFunctionPanel = new GroupFrame(0, EventEditingPanel.getHeight()/4+30-30 , 200, 30, 4);
		DialogueFunctionPanel.setBackground(new Color(255, 0, 0));
		DialogueAdd = new DialogueAddButton(0, 0, DialogueFunctionPanel.getWidth()/2, DialogueFunctionPanel.getHeight(), 0, GlobalV.CurrentEdittingPage); 
		DialogueAdd.setText("Add Dialogue");
		ChoiceAdd = new ChoiceAddButton(DialogueAdd.getWidth(), 0, DialogueFunctionPanel.getWidth()/2, DialogueFunctionPanel.getHeight(), 1, GlobalV.CurrentEdittingPage); 
		ChoiceAdd.setText("Add Choice");

		DialogueFunctionPanel.addToMap(ChoiceAdd.getDepth(), ChoiceAdd);
		DialogueFunctionPanel.addToMap(DialogueAdd.getDepth(), DialogueAdd);
		DialogueFunctionPanel.addThings();
		
		EventEditingPanel.addToMap(DialogueFunctionPanel.getDepth(), DialogueFunctionPanel);

		// jump from event to event
		EventJumpField = new GroupFrame(0, EventNamePanel.getHeight()+10, EventPlacePanel.getX()-150, (DialogueFunctionPanel.getY()- EventNamePanel.getY())/4, 5);
		EventJumpField.setBackground(new Color(255,255 ,255, 125));
		EventJumpField.setOpaque(true);
		EventEditingPanel.addToMap(EventJumpField.getDepth(), EventJumpField);

		EventJumpTitle = new SubLabel(0, 0, 200, EventJumpField.getHeight()/2-3, 0, "Default Jump To:", new Color(0, 255, 255,255), true);

		EventJumpPage0 = new SubLabel(0, EventJumpTitle.getHeight()+3, 50, EventJumpField.getHeight()/2-3, 1, "Page:", new Color(0, 255, 255, 125), false);
		EventJumpPage = new SubTextField(EventJumpPage0.getWidth(), EventJumpTitle.getHeight()+3, 50, EventJumpField.getHeight()/2-3, 2) ;

		EventJump0 = new SubLabel(EventJumpPage.getWidth()*2, EventJumpTitle.getHeight()+3, 50, EventJumpField.getHeight()/2-3, 3, "Event:", new Color(0, 255, 255, 125), false);
		EventJump = new SubTextField(EventJump0.getX()+EventJump0.getWidth(), EventJumpTitle.getHeight()+3, 80, EventJumpField.getHeight()/2-3, 4) ;
		
		EventJumpField.addToMap(EventJumpTitle.getDepth(), EventJumpTitle);
		
		EventJumpField.addToMap(EventJumpPage0.getDepth(), EventJumpPage0);
		EventJumpField.addToMap(EventJumpPage.getDepth(), EventJumpPage);

		EventJumpField.addToMap(EventJump0.getDepth(), EventJump0);
		EventJumpField.addToMap(EventJump.getDepth(), EventJump);
		EventJumpField.addThings();
		

		//influence variables
		EventVariableField = new GroupFrame(0, EventJumpField.getY()+EventJumpField.getHeight()+10,EventPlacePanel.getX()-150, ((DialogueFunctionPanel.getY()- EventNamePanel.getY())/2)-10, 6 ) ;
		EventVariableField.setBackground(new Color(255,255 ,255, 125));
		EventVariableField.setOpaque(true);
		
		EventVariableTitle = new SubLabel(0,0, 100, EventVariableField.getHeight()/3-3, 0,"Influence:",  new Color(0, 255, 255, 125), true);
		EventVariableName0 = new SubLabel(0,EventVariableTitle.getHeight()+3, 80, EventVariableField.getHeight()/3-5, 1, "Variable", new Color(0, 255, 255, 125), false);
		EventVariableName = new SubTextField(EventVariableName0.getX(), (EventVariableName0.getY()+EventVariableName0.getHeight())+3, 80, EventVariableField.getHeight()/3-5, 2) ;
		EventVariableOperator0 =new SubLabel(EventVariableName0.getWidth()+3,EventVariableTitle.getHeight()+3, 100, EventVariableField.getHeight()/3-5, 3, "Operator", new Color(0, 255, 255, 125), false);
		EventVariableOperator = new SubTextField(EventVariableOperator0.getX()+30, EventVariableOperator0.getY()+EventVariableOperator0.getHeight()+3, 30, EventVariableField.getHeight()/3-5, 4) ;

		EventVariableValue0 =new SubLabel(EventVariableOperator0.getX()+EventVariableOperator0.getWidth()+3,EventVariableOperator0.getHeight()+3, 60, EventVariableField.getHeight()/3-5, 5, "Value", new Color(0, 255, 255, 125), false);
		EventVariableValue = new SubTextField(EventVariableValue0.getX(), EventVariableValue0.getY()+EventVariableValue0.getHeight()+3, 60, EventVariableField.getHeight()/3-5, 6) ;

		//public static SubTextField EventVariableValue;
		
		EventVariableField.addToMap(EventVariableTitle.getDepth(), EventVariableTitle);
		EventVariableField.addToMap(EventVariableName0.getDepth(), EventVariableName0);
		EventVariableField.addToMap(EventVariableName.getDepth(), EventVariableName);
		EventVariableField.addToMap(EventVariableOperator0.getDepth(), EventVariableOperator0);
		EventVariableField.addToMap(EventVariableOperator.getDepth(), EventVariableOperator);
		EventVariableField.addToMap(EventVariableValue0.getDepth(), EventVariableValue0);
		EventVariableField.addToMap(EventVariableValue.getDepth(), EventVariableValue);
		EventVariableField.addThings();
		
		EventEditingPanel.addToMap(EventVariableField.getDepth(), EventVariableField);
		
		
	

		//checked conditions
		EventConditionPanel = new GroupFrame(EventJumpField.getX()+EventJumpField.getWidth()+5, EventJumpField.getY(), 140,EventJumpField.getHeight()*2+30, 7 );
		EventConditionPanel.setBackground(new Color(0,0 ,255, 125));
		EventConditionPanel.setOpaque(true);

		EventConditionTitle = new SubLabel(0, 0, EventConditionPanel.getWidth(),  EventConditionPanel.getHeight()/6, 2, "Conditions",  new Color(0, 255, 255, 125), true) ;
		EventAddCondition = new EventConditionAddButton(0, EventConditionTitle.getHeight()+3, EventConditionPanel.getWidth(), EventConditionPanel.getHeight()/6, 1, GlobalV.CurrentEdittingPage) ;
		EventAddCondition.setText("Add Condition");
		EventConditionListPanel = new GroupFrame(0, EventAddCondition.getY()+EventAddCondition.getHeight()+2, EventConditionPanel.getWidth(),EventConditionPanel.getHeight()*4/6, 0) ;
		EventConditionListPanel.setBackground(new Color(255, 255, 255, 255));
		EventConditionListPanel.setOpaque(true);
		//StoryCondition test = new StoryCondition(0, 0, EventConditionListPanel.getWidth(), EventConditionListPanel.getHeight()/GlobalV.MaxConditionNumber, 0, 0);
		//EventConditionListPanel.addToMap(test.getDepth(), test);
		//EventConditionListPanel.addThings();
		
		ConditionPanel = new GroupFrame(EventPlacePanel.getX(), EventPlacePanel.getY(),EventPlacePanel.getWidth()-20, EventPlacePanel.getHeight()-10, -20);
		ConditionFunctionPanel = new GroupFrame(0, ConditionPanel.getHeight()-70,ConditionPanel.getWidth(),50, 0 );
		
		ConditionContentPanel = new GroupFrame(0, 0,ConditionPanel.getWidth(),ConditionFunctionPanel.getY(), 1 );
		//ConditionContentPanel.setBackground(new Color(255, 255, 0, 200));
		//ConditionContentPanel.setOpaque(true);
		
		ConditionPanel.addToMap(ConditionFunctionPanel.getDepth(), ConditionFunctionPanel);
		ConditionPanel.addToMap(ConditionContentPanel.getDepth(), ConditionContentPanel);
		ConditionPanel.addThings();
		
		ConditionYes = new ConditionYesButton(0, 0, ConditionFunctionPanel.getWidth()/2, ConditionFunctionPanel.getHeight(), 0);	
		ConditionYes.setText("Save");
		ConditionNo = new ConditionNoButton(ConditionYes.getWidth(), 0, ConditionFunctionPanel.getWidth()/2, ConditionFunctionPanel.getHeight(), 1);
		ConditionNo.setText("Cancel");
		ConditionFunctionPanel.addToMap(ConditionYes.getDepth(), ConditionYes);
		ConditionFunctionPanel.addToMap(ConditionNo.getDepth(), ConditionNo);
		ConditionFunctionPanel.addThings();

		//EventVariableName0 = new SubLabel(0,EventVariableTitle.getHeight()+3, 80, EventVariableField.getHeight()/3-5, 1, "Variable", new Color(0, 255, 255, 125), false);
		//EventVariableName = new SubTextField(EventVariableName0.getX(), (EventVariableName0.getY()+EventVariableName0.getHeight())+3, 80, EventVariableField.getHeight()/3-5, 2) ;		
		ConditionVariable0  = new SubLabel(0,0, ConditionContentPanel.getWidth()/3, ConditionContentPanel.getHeight()/6, 0, "Variable", new Color(0, 255, 255, 125), true);
		ConditionVariable= new SubTextField(0, ConditionContentPanel.getHeight()/6, ConditionContentPanel.getWidth()/3, ConditionContentPanel.getHeight()/6, 1) ;
		ConditionOper0 = new SubLabel(ConditionVariable0.getX()+ConditionVariable0.getWidth(),0, ConditionContentPanel.getWidth()/3, ConditionContentPanel.getHeight()/6, 2, "Operator", new Color(0, 255, 255, 125), true);
		ConditionOper= new SubTextField(ConditionVariable0.getX()+ConditionVariable0.getWidth(), ConditionContentPanel.getHeight()/6, ConditionContentPanel.getWidth()/3, ConditionContentPanel.getHeight()/6, 3) ;
		ConditionValue0 = new SubLabel(ConditionOper0.getX()+ConditionOper0.getWidth(),0, ConditionContentPanel.getWidth()/3, ConditionContentPanel.getHeight()/6, 4, "Value", new Color(0, 255, 255, 125), true);
		ConditionValue= new SubTextField(ConditionOper0.getX()+ConditionOper0.getWidth(), ConditionContentPanel.getHeight()/6, ConditionContentPanel.getWidth()/3, ConditionContentPanel.getHeight()/6, 5) ;

		ConditionPage0 = new SubLabel(0,ConditionContentPanel.getHeight()*3/6, ConditionContentPanel.getWidth()/4, ConditionContentPanel.getHeight()/6, 6, "Page", new Color(0, 255, 255, 125), true);
		ConditionPage= new SubTextField(ConditionContentPanel.getWidth()*1/4,ConditionContentPanel.getHeight()*3/6, ConditionContentPanel.getWidth()/4, ConditionContentPanel.getHeight()/6, 7) ;
		ConditionEvent0 =new SubLabel(ConditionContentPanel.getWidth()*2/4,ConditionContentPanel.getHeight()*3/6, ConditionContentPanel.getWidth()/4, ConditionContentPanel.getHeight()/6, 8, "Event", new Color(0, 255, 255, 125), true);
		ConditionEvent= new SubTextField(ConditionContentPanel.getWidth()*3/4,ConditionContentPanel.getHeight()*3/6, ConditionContentPanel.getWidth()/4, ConditionContentPanel.getHeight()/6, 9) ;
	
		
		ConditionContentPanel.addToMap(ConditionVariable0.getDepth(), ConditionVariable0);
		ConditionContentPanel.addToMap(ConditionVariable.getDepth(), ConditionVariable);
		ConditionContentPanel.addToMap(ConditionOper0.getDepth(), ConditionOper0);
		ConditionContentPanel.addToMap(ConditionOper.getDepth(), ConditionOper);
		ConditionContentPanel.addToMap(ConditionValue0.getDepth(), ConditionValue0);
		ConditionContentPanel.addToMap(ConditionValue.getDepth(), ConditionValue);
		ConditionContentPanel.addToMap(ConditionPage0.getDepth(), ConditionPage0);
		ConditionContentPanel.addToMap(ConditionPage.getDepth(), ConditionPage);
		ConditionContentPanel.addToMap(ConditionEvent0.getDepth(), ConditionEvent0);
		ConditionContentPanel.addToMap(ConditionEvent.getDepth(), ConditionEvent);
		ConditionContentPanel.addThings();
		
		
		EventConditionPanel.addToMap(EventConditionTitle.getDepth(), EventConditionTitle);
		EventConditionPanel.addToMap(EventAddCondition.getDepth(), EventAddCondition);
		EventConditionPanel.addToMap(EventConditionListPanel.getDepth(), EventConditionListPanel);
		EventConditionPanel.addThings();
		
		EventEditingPanel.addToMap(EventConditionPanel.getDepth(), EventConditionPanel);
				
		EventEditingPanel.addThings();

	}
	public static void createNewEvent(int startX, int startY, int width, int height, String name, String place, int eventIndex){
		GlobalV.NumberEvent++;
		System.out.println("System: Create Event " + eventIndex +" at page "+ GlobalV.CurrentEdittingPage);
		
		StoryEvent tempEvent = new StoryEvent(eventIndex, startY);
		if(name == ""){
			
		}
		else{
			tempEvent.eventName = name;
		}
		
		if(place == ""){
			
		}
		else{
			tempEvent.place = place;
		}
		EventButton tempButton;
		EventLabel tempLabel;

		LookUp.EventPositionMap.get(GlobalV.CurrentEdittingPage).put(tempEvent.eventName, startY);
		LookUp.EventMap.put(tempEvent.index, tempEvent);
		LookUp.EventNameMap.put(tempEvent.eventName, tempEvent.index);
		LookUp.EventPageMap.put(tempEvent.eventName, GlobalV.CurrentEdittingPage);
		LookUp.EventTimeMap.get(GlobalV.CurrentEdittingPage).put(startY, tempEvent.eventName);
		
		tempButton = new EventButton(startX, startY, width, height, tempEvent.index, GlobalV.CurrentEdittingPage, tempEvent.eventName);
		
		EventPageMap.get(GlobalV.CurrentEdittingPage).EventButtonMap.put(tempEvent.eventName, tempButton);

		
		tempLabel = new EventLabel(startX, startY, width, height, tempEvent.index, GlobalV.CurrentEdittingPage, tempEvent.eventName, new Color(0, 0, 255, 255));
		
		EventPageMap.get(GlobalV.CurrentEdittingPage).EventLabelMap.put(tempEvent.eventName, tempLabel);
		paintEventButton();
		
		//printEventMap();
		//printEventTime();
		updateEventLinks2();
	}
	public static void paintEventButton(){
		//System.out.println("*****"+EventPageMap.get(GlobalV.CurrentEdittingPage).EventButtonMap);
		EventPageMap.get(GlobalV.CurrentEdittingPage).removeAll();
		EventPageMap.get(GlobalV.CurrentEdittingPage).map.clear();
		EventPageMap.get(GlobalV.CurrentEdittingPage).addChagnePage();
		
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

		for(String stringKey : G_Chara.CharacterButtonMap.keySet()){
			G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).addToMap(G_Chara.CharacterButtonMap.get(stringKey).line.getDepth(), G_Chara.CharacterButtonMap.get(stringKey).line);

			//System.out.println(G_Chara.CharacterButtonMap.get(stringKey).line.locationX);
		}
		
		G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).removeAll();
		G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).addThings();
		G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).repaint();		
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

		for(String stringKey : G_Chara.CharacterButtonMap.keySet()){
			G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).addToMap(G_Chara.CharacterButtonMap.get(stringKey).line.getDepth(), G_Chara.CharacterButtonMap.get(stringKey).line);

			//System.out.println(G_Chara.CharacterButtonMap.get(stringKey).line.locationX);
		}
		
		G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).removeAll();
		G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).addThings();
		G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).repaint();		
	}
	
	public static void changeEventName(String name, int index)
	{
		
	}
	public static void printEventTime(){
		for(int key : LookUp.EventTimeMap.get(GlobalV.CurrentEdittingPage).keySet())
		{
		     System.out.println(key + " : " +LookUp.EventTimeMap.get(GlobalV.CurrentEdittingPage).get(key));
		}		
	}
	public static void printEventMap(){
		for(int key : LookUp.EventMap.keySet())
		{
		     System.out.println(key + " : " +LookUp.EventMap.get(key));
		}		
	}
	public static void setPlacePreview(String placeName){
    	//resize image
    	int imageIndex = LookUp.PlaceNameMap.get(placeName);
    	ImageIcon img = G_Material.Place.materialImage.get(imageIndex);
    	Image tempImg = img.getImage();
    	tempImg = tempImg.getScaledInstance(PlaceImageLabel.getWidth(), PlaceImageLabel.getHeight(), Image.SCALE_DEFAULT);
    	img = new ImageIcon(tempImg);	
    	
       	//Show place preview
    	PlaceImageLabel.setIcon(img);
    	
	}
	public static void updateEventLinks2(){
		if(LookUp.EventTimeMap.get(GlobalV.CurrentEdittingPage).size()>0){
			for(int key: LookUp.EventTimeMap.get(GlobalV.CurrentEdittingPage).keySet()){
				String targetEvent = LookUp.EventTimeMap.get(GlobalV.CurrentEdittingPage).get(key);
				int currentIndex = LookUp.EventNameMap.get(targetEvent);
				StoryEvent currentUseEvent = LookUp.EventMap.get(currentIndex);
				int nextIndex = getNextEvent(key);				
				//if(currentUseEvent.nextEvent == "" || currentUseEvent.nextEventIndex <0 ){
				if(currentUseEvent.nextPage == GlobalV.CurrentEdittingPage){
					if(nextIndex>=0){
						System.out.println("System: Event "+targetEvent+" has no next, update next to "+LookUp.EventMap.get(nextIndex).eventName);
						LookUp.EventMap.get(currentIndex).nextPage = GlobalV.CurrentEdittingPage;
						LookUp.EventMap.get(currentIndex).nextEvent = LookUp.EventMap.get(nextIndex).eventName;
						LookUp.EventMap.get(currentIndex).nextEventIndex = nextIndex;
					}
					else{
						System.out.println("System: Event "+targetEvent+" has no next, update next to null");
						LookUp.EventMap.get(currentIndex).nextPage = GlobalV.CurrentEdittingPage;
						LookUp.EventMap.get(currentIndex).nextEvent = "";
						LookUp.EventMap.get(currentIndex).nextEventIndex = -1;
					}
				}
				else{
					
				}
				
			}
		}

	}

	public static int getNextEvent(int position){
		int nextIndex = -1;
		int count =0;
		int currentHeight =	position;
		if(LookUp.EventPositionMap.get(GlobalV.CurrentEdittingPage).size()>0){
			for(int key : LookUp.EventTimeMap.get(GlobalV.CurrentEdittingPage).keySet()){
				//System.out.println("key = " +key +" current"+position);
				if(count == 0){
					if(key > currentHeight){
						String targetEvent = LookUp.EventTimeMap.get(GlobalV.CurrentEdittingPage).get(key);
						nextIndex = LookUp.EventNameMap.get(targetEvent);
						count++;
					}
					else{
						nextIndex = -1;
					}
				}
			}
			
			if(count == 0){
				//no key is found
				nextIndex = -1;
			}
		}
		else{
			nextIndex = -1;
		}
		return nextIndex;
	}	
	
	
}
