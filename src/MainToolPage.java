/*
 * License information:
 * 
 * ===================
 * Project Information
 * ===================
 * Name: CSC 582, Mid Project
 * 
 * Topic:
 * This pr1ogram is created for 2016 spring, CSC 582 Project
 * V-Set is a visual story editing tool.
 *
 *  
 * ==================
 * Author information
 * ==================
 * Name: Yi-Chun Chen
 * UnityID: ychen74
 * Student ID:200110436
 * 
 * ==========
 * References
 * ==========
 */


/*
 * Program Descriptions
 * =================
 * Coding Convention
 * =================
 * - global: Pascal casing.
 * - local: Camel casing
 * - function input: Pascal casing
 * - function output: Pascal casing
 * - function name: Camel casing
 * - class name: Pascal casing  
 *
 *=====
 *Logic
 *=====
 *
 *
 */

/*
 * ==============
 * Import Library
 * ==============
 */
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.*;

import FunctionActions.AddCharaAction;
import FunctionActions.BackgroundTimerFrameActions;
import ImageMaterial.G_Material;
import Main.OutFrame;
import MainScreen.*;
import CharacterScreen.*;
import Display.G_Display;
import Events.G_Event;
import Variables.G_Fun;
import Variables.GlobalV;
import Variables.LookUp;

public class MainToolPage{
/*
 * variables
 */
	public static GlobalV global;
	public static G_Components globalC;
	public static G_Chara globalChara;
	public static G_Fun globalFun;
	public static LookUp globalLook;
	public static G_Event globalEvent;
	public static G_Material globalMaterial;
	public static G_Display globalDisplay;
	
	public static BackgroundTimerFrameActions test = new BackgroundTimerFrameActions();
	
	private static JFrame OutFrame;
	
	public static void initialSetting(){
		//initialize
		globalLook = new LookUp();
		globalFun = new G_Fun();
		global = new GlobalV();
		globalC = new G_Components();
		globalMaterial = new G_Material();
		globalChara = new G_Chara();
		globalEvent = new G_Event();
		globalDisplay = new G_Display();

	}
	//This is the start point of the tool
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		initialSetting();

		/*
		 * Out Frame
		 */
		OutFrame = new JFrame();
		OutFrame.setTitle("V-SET");
		OutFrame.setSize(GlobalV.WindowWidth, GlobalV.WindowHeight);
		OutFrame.setVisible(true);
		OutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		OutFrame.setLayout(null);
		//Main Panel
		OutFrame.add(G_Components.mainFrame);
		
		/*
		 * Main panel
		 */
		//depth is smaller, the thing is more front
		G_Components.mainFrame.addToMap(G_Components.menuList.getDepth(), G_Components.menuList);
		G_Components.mainFrame.addToMap(G_Components.currentContent.getDepth(), G_Components.currentContent);
		G_Components.mainFrame.addThings();		
		
	
		/*
		 * Left and Right Panel (menu and content)
		 */

		/*
		 * Function menus
		 */
		G_Components.menuList.addToMap(G_Components.addChara.getDepth(), G_Components.addChara);
		G_Components.menuList.addToMap(G_Components.deleteChara.getDepth(), G_Components.deleteChara);
		G_Components.menuList.addToMap(G_Components.addPlace.getDepth(), G_Components.addPlace);
		G_Components.menuList.addToMap(G_Components.deletePlace.getDepth(), G_Components.deletePlace);
		G_Components.menuList.addToMap(G_Components.addEvent.getDepth(), G_Components.addEvent);
		G_Components.menuList.addToMap(G_Components.deleteEvent.getDepth(), G_Components.deleteEvent);
		G_Components.menuList.addToMap(G_Components.save.getDepth(), G_Components.save);
		G_Components.menuList.addToMap(G_Components.compileStory.getDepth(), G_Components.compileStory);
		G_Components.menuList.addThings();

		/*
		 * current Contents
		 */
		G_Components.mainScreen.addToMap(G_Chara.charaButtonPanel.getDepth(), G_Chara.charaButtonPanel);
		G_Components.mainScreen.addToMap(G_Event.StorylinePanel.getDepth(), G_Event.StorylinePanel);
		G_Components.mainScreen.addThings();
		
		G_Components.currentContent.addToMap(G_Components.mainScreen.getDepth(), G_Components.mainScreen);
		G_Components.currentContent.addThings();


	}
}
