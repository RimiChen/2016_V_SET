/*
 * This contains panel for main screen
 */
package MainScreen;

import java.awt.Color;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.*;

import FunctionActions.AddCharaAction;
import FunctionActions.AddEventAction;
import FunctionActions.CompileAction;
import FunctionActions.MoveEventAction;
import Main.OutFrame;
import Variables.GlobalV;


public class G_Components {
	//out frame
	public static OutFrame mainFrame;

	// left and right panel
	public static GroupFrame menuList;
	public static GroupFrame currentContent;
	
	public static GroupFrame mainScreen;
	
	// function menu
	public static Map<String, FunctionButton> FunctionButtonManager;

	public static FunctionButton addChara;     
	public static FunctionButton deleteChara;
	public static FunctionButton addPlace;
	public static FunctionButton deletePlace;
	public static FunctionButton addEvent;
	public static FunctionButton moveEvent;
	public static FunctionButton save;
	public static FunctionButton compileStory;


	
	//function button
	public G_Components(){
		//out frame
		mainFrame = new  OutFrame(0, 0, GlobalV.WindowWidth, GlobalV.WindowHeight);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
		
		
		
		
		// left and right panel
		initialMenu(0);
		initialCurrentContent(1);
		
		mainScreen = new GroupFrame(0, 0, currentContent.getWidth(), currentContent.getHeight(), 0);

		
		//function button
		FunctionButtonManager = new TreeMap<String, FunctionButton>();
		initialFunctionMenu(0);
		


		
	}
	public void initialMenu(int depth){

		int menuPropotion = GlobalV.MenuPropotion;
		int menuListX = GlobalV.WindowWidth/menuPropotion;
		int menuListY = GlobalV.WindowHeight;

		
		menuList = new GroupFrame(0 , 0, menuListX, menuListY, depth);
		menuList.setLayout(null);
		menuList.setVisible(true);
		
	}
	public void initialCurrentContent(int depth){
		currentContent = new GroupFrame(menuList.getWidth(), 0, GlobalV.WindowWidth - menuList.getWidth(), menuList.getHeight(), depth);
		System.out.println("----"+menuList.getX());
		currentContent.setLayout(null);
		currentContent.setVisible(true);	
	}
	public void initialFunctionMenu(int depth){
		int buttonSizeX = G_Components.menuList.getWidth();
		int buttonSizeY = (int)GlobalV.UsableHeight / GlobalV.NumberOfFunctions;
		
		addChara =     
		new FunctionButton(0, 0 * GlobalV.UsableHeight/ GlobalV.NumberOfFunctions, buttonSizeX, buttonSizeY, depth+0);
		addChara.setText("Add Character");
		AddCharaAction addCharaAct = new AddCharaAction();
		addChara.addActionListener(addCharaAct);
			
		deleteChara =
		new FunctionButton(0, 1 * GlobalV.UsableHeight/ GlobalV.NumberOfFunctions, buttonSizeX, buttonSizeY, depth+1);
		deleteChara.setText("Delete Character");
			
		addPlace =
		new FunctionButton(0, 2 * GlobalV.UsableHeight/ GlobalV.NumberOfFunctions, buttonSizeX, buttonSizeY, depth+2);
		addPlace.setText("Add Place");
			
		deletePlace =
		new FunctionButton(0, 3 * GlobalV.UsableHeight/ GlobalV.NumberOfFunctions, buttonSizeX, buttonSizeY, depth+3);
		deletePlace.setText("Delete Place");
			
		addEvent =
		new FunctionButton(0, 4 * GlobalV.UsableHeight/ GlobalV.NumberOfFunctions, buttonSizeX, buttonSizeY, depth+4);
		addEvent.setText("Add Event");
		AddEventAction addEventAct = new AddEventAction();
		addEvent.addActionListener(addEventAct);

		moveEvent = 
		new FunctionButton(0, 5 * GlobalV.UsableHeight/ GlobalV.NumberOfFunctions, buttonSizeX, buttonSizeY, depth+5);
		moveEvent.setText("Move Event");
		MoveEventAction moveEventAct = new MoveEventAction();
		moveEvent.addActionListener(moveEventAct);
		
		
		save =
		new FunctionButton(0, 6 * GlobalV.UsableHeight/ GlobalV.NumberOfFunctions, buttonSizeX, buttonSizeY, depth+6);
		save.setText("Save");

		compileStory =
		new FunctionButton(0, 7 * GlobalV.UsableHeight/ GlobalV.NumberOfFunctions, buttonSizeX, buttonSizeY, depth+7);
		compileStory.setText("Compile Story");		
		CompileAction compileStoryAct = new CompileAction();
		compileStory.addActionListener(compileStoryAct);
		
		FunctionButtonManager.put("Add Character", addChara);
		FunctionButtonManager.put("Delete Character", deleteChara);
		FunctionButtonManager.put("Add Place", addPlace);
		FunctionButtonManager.put("Delete Place", deletePlace);
		FunctionButtonManager.put("Add Event", addEvent);
		FunctionButtonManager.put("Delete Event", moveEvent);
		FunctionButtonManager.put("Save", save);
		FunctionButtonManager.put("Compile Story", compileStory);
	}

}
