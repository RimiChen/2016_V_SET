package Display;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JFrame;

import CharaMake.CustomCharacter;
import CharacterScreen.G_Chara;
import Choices.ChoiceButton;
import Events.StoryEvent;
import Events.SubLabel;
import FunctionActions.CloseStoryAction;
import ImageMaterial.G_Material;
import MainScreen.GroupFrame;
import Variables.GlobalV;
import Variables.LookUp;

public class G_Display {
	public static List<StoryEvent> DisplayQueue;
	public static Map<Integer, StoryEvent> DisplayTimeMap;
	public static JFrame StoryFrame;
	
	
	public static GroupFrame BasicFrame;
	//Background
	// Add Timer in here
	public static BackgoundTimerFrame BackgroundPanel;
	public static SubLabel BackgroundImageLabel;

	//Character Image, future to extend to two
	public static GroupFrame CharacterPanel;
	public static SubLabel[] CharacterBodyParts;
	
	//Character Name
	public static GroupFrame CharacterNamePanel;
	public static SubLabel CharacterNameLabelImage;
	public static SubLabel CharacterNameLabelText;
	
	//Dialogue 
	public static GroupFrame DialoguePanel;
	public static SubLabel DialogueLabelImage;
	public static SubLabel DialogueLabelText;

	public static GroupFrame ChoicePanel;
	public static ChoiceButton ChoiceButton0;
	public static ChoiceButton ChoiceButton1;
	public static ChoiceButton ChoiceButton2;
	
	
	public static ProgressButton DialogueProgress;
	
	public G_Display(){
		DisplayQueue = new ArrayList<StoryEvent>();
		DisplayTimeMap = new TreeMap<Integer, StoryEvent>();
		StoryFrame = new JFrame();
		StoryFrame.setTitle("Story Display");
		StoryFrame.setSize(GlobalV.DisplayWidth, GlobalV.DisplayHeight);
		StoryFrame.setLocation(300, 300);
		StoryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		StoryFrame.setLayout(null);
		CloseStoryAction closeAct;
		closeAct = new CloseStoryAction();
		StoryFrame.addWindowListener(closeAct);
		
		// depth is smaller, is more front
		
		BasicFrame = new GroupFrame(0, 0, StoryFrame.getWidth(), StoryFrame.getHeight(), 0);
		//BasicFrame .setBackground(new Color(255, 255, 255));

		
		
		
		//Character name
		CharacterNamePanel = new GroupFrame(50, StoryFrame.getHeight()-250, 150, 50, 0);
		CharacterNamePanel.setBackground(new Color(0, 0, 0));

		CharacterNameLabelImage = new SubLabel(0, 0, CharacterNamePanel.getWidth(), CharacterNamePanel.getHeight(), 1, "", new Color(0, 0, 0), false);
		CharacterNameLabelImage.setIcon(G_Material.resizeImage(G_Material.NameCard.materialImage.get(0), CharacterNameLabelImage.getWidth(), CharacterNameLabelImage.getHeight()));
		
		CharacterNameLabelText = new SubLabel(0, 0, CharacterNamePanel.getWidth(), CharacterNamePanel.getHeight(), 0,"See", new Color(0, 0, 0), false);
		CharacterNameLabelText.setFont(new Font("Arial", Font.BOLD, 20));
		CharacterNameLabelText.setForeground(new Color(141, 54, 0));
		
		CharacterNamePanel.addToMap(CharacterNameLabelImage.getDepth(), CharacterNameLabelImage);
		CharacterNamePanel.addToMap(CharacterNameLabelText.getDepth(), CharacterNameLabelText);
		CharacterNamePanel.addThings();

		BasicFrame.addToMap(CharacterNamePanel.getDepth(), CharacterNamePanel);


		//Dialogue
		DialoguePanel = new GroupFrame(100, CharacterNamePanel.getY() +  CharacterNamePanel.getHeight() +5, BasicFrame.getWidth()-200, 150, 1);
		ChoicePanel = new GroupFrame(100, CharacterNamePanel.getY() +  CharacterNamePanel.getHeight() +5, BasicFrame.getWidth()-200, 150, -1);

		
		DialogueLabelImage = new SubLabel(0, 0, DialoguePanel.getWidth(), DialoguePanel.getHeight(), 1, "", new Color(0, 0, 0), false);
		DialogueLabelImage.setIcon(G_Material.resizeImage(G_Material.Dialogue.materialImage.get(0), DialogueLabelImage.getWidth(), DialogueLabelImage.getHeight()));

		DialogueLabelText = new SubLabel(0, 0, DialoguePanel.getWidth(), DialoguePanel.getHeight(), 0,"Test Content", new Color(0, 0, 0), false);
		DialogueLabelText.setFont(new Font("Arial", Font.BOLD, 20));
		DialogueLabelText.setForeground(new Color(141, 54, 0));
		
		DialogueProgress = new ProgressButton(450, 100, 100, 30, -1);
		DialogueProgress.setText("Progress");

		ChoiceButton0 = new ChoiceButton(ChoicePanel.getWidth()/4, ChoicePanel.getHeight()/5, ChoicePanel.getWidth()*2/4, ChoicePanel.getHeight()/5, 0, 0);
		ChoiceButton1 = new ChoiceButton(ChoicePanel.getWidth()/4, ChoicePanel.getHeight()*2/5, ChoicePanel.getWidth()*2/4, ChoicePanel.getHeight()/5, 1, 1);
		ChoiceButton2 = new ChoiceButton(ChoicePanel.getWidth()/4, ChoicePanel.getHeight()*3/5, ChoicePanel.getWidth()*2/4, ChoicePanel.getHeight()/5, 2, 2);
		
		ChoicePanel.addToMap(ChoiceButton0.getDepth(), ChoiceButton0);
		ChoicePanel.addToMap(ChoiceButton1.getDepth(), ChoiceButton1);
		ChoicePanel.addToMap(ChoiceButton2.getDepth(), ChoiceButton2);
		
		ChoicePanel.addThings();
		
		
		if(GlobalV.displayButtonMode == 0){
			
		}
		else{
			GlobalV.ClockDelay = 20;
			DialoguePanel.addToMap(DialogueProgress.getDepth(), DialogueProgress);
		}
		DialoguePanel.addToMap(DialogueLabelImage.getDepth(), DialogueLabelImage);
		DialoguePanel.addToMap(DialogueLabelText.getDepth(), DialogueLabelText);
		DialoguePanel.addThings();		
		
		BasicFrame.addToMap(DialoguePanel.getDepth(), DialoguePanel);

	
		//Character
		CharacterPanel = new GroupFrame(BasicFrame.getWidth()*3/5, BasicFrame.getHeight()-550,  200, 550, 2);
		CharacterPanel.setBackground(new Color(0, 0, 255));
		CharacterBodyParts = new SubLabel[GlobalV.NumberFeatures] ;
		for(int i = 0; i < GlobalV.NumberFeatures; i++){
			CharacterBodyParts[i] = new SubLabel(0, 0, CharacterPanel.getWidth(), CharacterPanel.getHeight(), -i, "", new Color(0,0,0), false);
			CharacterPanel.addToMap(CharacterBodyParts[i].getDepth(), CharacterBodyParts[i]);
		}
		CharacterPanel.addThings();
		
		BasicFrame.addToMap(CharacterPanel.getDepth(), CharacterPanel);
		
	
		//Background
		BackgroundPanel = new BackgoundTimerFrame(0, 0, BasicFrame.getWidth(), BasicFrame.getHeight(), 3, false);
		BackgroundPanel.setBackground(new Color(0, 0, 0));
		BackgroundImageLabel = new SubLabel(0, 0, BackgroundPanel.getWidth(), BackgroundPanel.getHeight(), 0, "", new Color(0, 0, 0), false) ;

		BackgroundPanel.addToMap(BackgroundImageLabel.getDepth(), BackgroundImageLabel);
		BackgroundPanel.addThings();
		
		BasicFrame.addToMap(BackgroundPanel.getDepth(), BackgroundPanel);

		BasicFrame.addThings();
		BasicFrame.setVisible(false);
		
	}
	public static void compileStory(){

		GlobalV.isEditting = true;
		BasicFrame.setVisible(false);
		StoryFrame.setVisible(true);

		loadStoryInQueue();
		//displayEventInQueue();
		
		GlobalV.DisplayEventNumber = DisplayQueue.size();
		GlobalV.DisplayEventCount = 0;
		GlobalV.DisplayDialogueCount =0;
		
		BackgroundPanel.enableTimer();
		
		StoryFrame.add(BasicFrame);
		StoryFrame.repaint();
	}
	public static void loadStoryInQueue(){
		// In first version start from page 1
		String currentEventName; 
		int currentEventIndex;
		StoryEvent tempEvent;
		//for(int i = 1; i <= GlobalV.NumberEventPage; i++){
			//int currentPage = i;
			int currentPage = GlobalV.CurrentEdittingPage;
			for(int key : LookUp.EventTimeMap.get(currentPage).keySet())
			{
				currentEventName = LookUp.EventTimeMap.get(currentPage).get(key);
				System.out.println("Add "+ currentEventName);
				currentEventIndex = LookUp.EventNameMap.get(currentEventName);
				tempEvent = LookUp.EventMap.get(currentEventIndex);
				DisplayQueue.add(tempEvent);
				DisplayTimeMap.put(key, tempEvent);
			}
		//}
	}
	public static void displayEventInQueue(){
		int iconIndex;
		String iconString;
		if(DisplayTimeMap.size() == 0){
			System.out.println("System: Story Queue is empty");
		}
		
		for(int key : DisplayTimeMap.keySet()){
			System.out.println("System: In time "+key
					+" Display "+DisplayTimeMap.get(key).eventName
					+" Happen in " + DisplayTimeMap.get(key).place);
			
			iconString = DisplayTimeMap.get(key).place;
			iconIndex = LookUp.PlaceNameMap.get(iconString);
			
			BackgroundImageLabel.setIcon(G_Material.resizeImage(G_Material.Place.materialImage.get(iconIndex), BackgroundImageLabel.getWidth(), BackgroundImageLabel.getHeight()));
			BackgroundPanel.repaint();
			for(int i = 0 ; i < DisplayTimeMap.get(key).dialogueQueue.size(); i++){
				System.out.println("--Sub: Dialogue " + DisplayTimeMap.get(key).dialogueQueue.get(i).dialogueIndex
						+ " Character: "+LookUp.CharaMap.get(DisplayTimeMap.get(key).dialogueQueue.get(i).charaIndex).name
						+ " Content: "+DisplayTimeMap.get(key).dialogueQueue.get(i).content
				);
				
				String charaName;
				int charaID;
				CustomCharacter tempChara;
				for(int j = 0; j < GlobalV.NumberFeatures; j++){
					charaName = LookUp.CharaMap.get(DisplayTimeMap.get(key).dialogueQueue.get(i).charaIndex).name;
					charaID = LookUp.CharaNameMap.get(charaName);
					tempChara = LookUp.CharaMap.get(charaID);
					
					if(LookUp.MaterialTypeIndex.get(tempChara.type) == 0){
						if(tempChara.imageIndex.get(j)<0){
							CharacterBodyParts[i].setIcon(null);
						}
						else{
							CharacterBodyParts[j].setIcon(G_Chara.Man.bodyImage.get(j).materialQueue.get(tempChara.imageIndex.get(j)));
							
						}
						//System.out.println(tempChara.imageIndex.get(j));

					}
					else if(LookUp.MaterialTypeIndex.get(tempChara.type) == 1){
						if(tempChara.imageIndex.get(j)<0){
							CharacterBodyParts[i].setIcon(null);
						}
						else{
							CharacterBodyParts[j].setIcon(G_Chara.Woman.bodyImage.get(j).materialQueue.get(tempChara.imageIndex.get(j)));
							
						}
					}
					else if(LookUp.MaterialTypeIndex.get(tempChara.type) == 2){
						if(tempChara.imageIndex.get(j)<0){
							CharacterBodyParts[i].setIcon(null);
						}
						else{
							CharacterBodyParts[j].setIcon(G_Chara.Narrator.bodyImage.get(j).materialQueue.get(tempChara.imageIndex.get(j)));
							
						}
					}					
				}
				CharacterPanel.repaint();
				
				CharacterNameLabelText.setText(LookUp.CharaMap.get(DisplayTimeMap.get(key).dialogueQueue.get(i).charaIndex).name);
				CharacterNamePanel.repaint();
				DialogueLabelText.setText(DisplayTimeMap.get(key).dialogueQueue.get(i).content);
				DialoguePanel.repaint();
				
			}
		} 
	}
	public static void displayEventInQueueWithTimer(int eventCount, int dialogueCount){
		int iconIndex;
		String iconString;
		
		int i = dialogueCount;
		int k = eventCount;
		
		if(DisplayTimeMap.size() == 0){
			System.out.println("System: Story Queue is empty");
		}
		
		//int k =GlobalV.DisplayEventCount;
		if(k <DisplayQueue.size()){
		//for(int k = 0; k <DisplayQueue.size(); k++ ){
			System.out.println("System: In time "+LookUp.EventPositionMap.get(GlobalV.CurrentEdittingPage).get(DisplayQueue.get(k).eventName)
					+" Display "+DisplayQueue.get(k).eventName
					+" Happen in " + DisplayQueue.get(k).place);	
			iconString = DisplayQueue.get(k).place;
			iconIndex = LookUp.PlaceNameMap.get(iconString);
			
			//for(int i = 0; i <DisplayQueue.get(k).dialogueQueue.size(); i++){
			//int i = GlobalV.DisplayDialogueCount;
			
			if(i <DisplayQueue.get(k).dialogueQueue.size()){
				System.out.println("--Sub: Dialogue " + DisplayQueue.get(k).dialogueQueue.get(i).dialogueIndex
						+ " Character: "+LookUp.CharaMap.get(DisplayQueue.get(k).dialogueQueue.get(i).charaIndex).name
						+ " Content: "+DisplayQueue.get(k).dialogueQueue.get(i).content
				);	
				
				String charaName;
				int charaID;
				CustomCharacter tempChara;
				//print character parts
				for(int j = 0; j < GlobalV.NumberFeatures; j++){
					charaName = LookUp.CharaMap.get(DisplayQueue.get(k).dialogueQueue.get(i).charaIndex).name;
					charaID = LookUp.CharaNameMap.get(charaName);
					tempChara = LookUp.CharaMap.get(charaID);
					
					if(LookUp.MaterialTypeIndex.get(tempChara.type) == 0){
						if(tempChara.imageIndex.get(j)<0){
							CharacterBodyParts[j].setIcon(null);
						}
						else{
							CharacterBodyParts[j].setIcon(G_Chara.Man.bodyImage.get(j).materialQueue.get(tempChara.imageIndex.get(j)));
							
						}
						//System.out.println(tempChara.imageIndex.get(j));

					}
					else if(LookUp.MaterialTypeIndex.get(tempChara.type) == 1){
						if(tempChara.imageIndex.get(j)<0){
							CharacterBodyParts[j].setIcon(null);
						}
						else{
							CharacterBodyParts[j].setIcon(G_Chara.Woman.bodyImage.get(j).materialQueue.get(tempChara.imageIndex.get(j)));
							
						}
					}
					else if(LookUp.MaterialTypeIndex.get(tempChara.type) == 2){
						if(tempChara.imageIndex.get(j)<0){
							CharacterBodyParts[j].setIcon(null);
						}
						else{
							CharacterBodyParts[j].setIcon(G_Chara.Narrator.bodyImage.get(j).materialQueue.get(tempChara.imageIndex.get(j)));
							
						}
					}					
				}
				CharacterPanel.repaint();
			}// if end
			
			BackgroundImageLabel.setIcon(G_Material.resizeImage(G_Material.Place.materialImage.get(iconIndex), BackgroundImageLabel.getWidth(), BackgroundImageLabel.getHeight()));
			BackgroundPanel.repaint();

			
			CharacterNameLabelText.setText(LookUp.CharaMap.get(DisplayQueue.get(k).dialogueQueue.get(i).charaIndex).name);
			CharacterNamePanel.repaint();
			DialogueLabelText.setText(DisplayQueue.get(k).dialogueQueue.get(i).content);
			DialoguePanel.repaint();	
			
			BasicFrame.repaint();
		}
			

		
	}
	public static void displayChoiceInQueueWithButton(int eventCount, int dialogueCount){
		int iconIndex;
		String iconString;
		
		int i = dialogueCount;
		int k = eventCount;
		
		if(DisplayTimeMap.size() == 0){
			System.out.println("System: Story Queue is empty");
		}
		
		//int k =GlobalV.DisplayEventCount;
		if(k <DisplayQueue.size()){
		//for(int k = 0; k <DisplayQueue.size(); k++ ){
/*
			System.out.println("System: In time "+LookUp.EventPositionMap.get(DisplayQueue.get(k).eventName)
					+" Display "+DisplayQueue.get(k).eventName
					+" Happen in " + DisplayQueue.get(k).place);	
*/
			iconString = DisplayQueue.get(k).place;
			iconIndex = LookUp.PlaceNameMap.get(iconString);
			
			//for(int i = 0; i <DisplayQueue.get(k).dialogueQueue.size(); i++){
			//int i = GlobalV.DisplayDialogueCount;
			if(i <DisplayQueue.get(k).dialogueQueue.size()){
/*
				System.out.println("--Sub: Dialogue " + DisplayQueue.get(k).dialogueQueue.get(i).dialogueIndex
						+ " Character: "+LookUp.CharaMap.get(DisplayQueue.get(k).dialogueQueue.get(i).charaIndex).name
						+ " Content: "+DisplayQueue.get(k).dialogueQueue.get(i).content
				);	
*/				
				String charaName;
				int charaID;
				CustomCharacter tempChara;
				//print character parts
				for(int j = 0; j < GlobalV.NumberFeatures; j++){
					charaName = LookUp.CharaMap.get(DisplayQueue.get(k).dialogueQueue.get(i).charaIndex).name;
					charaID = LookUp.CharaNameMap.get(charaName);
					tempChara = LookUp.CharaMap.get(charaID);
					
					if(LookUp.MaterialTypeIndex.get(tempChara.type) == 0){
						if(tempChara.imageIndex.get(j)<0){
							CharacterBodyParts[j].setIcon(null);
						}
						else{
							CharacterBodyParts[j].setIcon(G_Chara.Man.bodyImage.get(j).materialQueue.get(tempChara.imageIndex.get(j)));
							
						}
						//System.out.println(tempChara.imageIndex.get(j));

					}
					else if(LookUp.MaterialTypeIndex.get(tempChara.type) == 1){
						if(tempChara.imageIndex.get(j)<0){
							CharacterBodyParts[j].setIcon(null);
						}
						else{
							CharacterBodyParts[j].setIcon(G_Chara.Woman.bodyImage.get(j).materialQueue.get(tempChara.imageIndex.get(j)));
							
						}
					}
					else if(LookUp.MaterialTypeIndex.get(tempChara.type) == 2){
						if(tempChara.imageIndex.get(j)<0){
							CharacterBodyParts[j].setIcon(null);
						}
						else{
							CharacterBodyParts[j].setIcon(G_Chara.Narrator.bodyImage.get(j).materialQueue.get(tempChara.imageIndex.get(j)));
							
						}
					}					
				}
				CharacterPanel.repaint();
			}// if end
						
			
			BackgroundImageLabel.setIcon(G_Material.resizeImage(G_Material.Place.materialImage.get(iconIndex), BackgroundImageLabel.getWidth(), BackgroundImageLabel.getHeight()));
			BackgroundPanel.repaint();

			
			//CharacterNameLabelText.setText(LookUp.CharaMap.get(DisplayQueue.get(k).dialogueQueue.get(i).charaIndex).name);
			CharacterNamePanel.repaint();
			//DialogueLabelText.setText(DisplayQueue.get(k).dialogueQueue.get(i).content);
			DialoguePanel.repaint();
			
			ChoicePanel.map.clear();
			ChoicePanel.removeAll();

			for(int iter = 0; iter < DisplayQueue.get(k).choiceQueue.size();iter++){
				if(iter == 0){
					ChoiceButton0.setText(DisplayQueue.get(k).choiceQueue.get(0).content);
					ChoicePanel.addToMap(ChoiceButton0.getDepth(), ChoiceButton0);
				}
				else if(iter ==1){
					ChoiceButton1.setText(DisplayQueue.get(k).choiceQueue.get(1).content);
					ChoicePanel.addToMap(ChoiceButton1.getDepth(), ChoiceButton1);				
				}
				else if(iter ==2){
					ChoiceButton2.setText(DisplayQueue.get(k).choiceQueue.get(2).content);
					ChoicePanel.addToMap(ChoiceButton2.getDepth(), ChoiceButton2);		
				}
			}
			
			ChoicePanel.addThings();
			DialoguePanel.removeAll();
			DialoguePanel.map.remove(DialogueProgress.getDepth());
			DialoguePanel.addThings();
			DialogueLabelText.setText("");
			DialoguePanel.repaint();
			BasicFrame.removeAll();
			//BasicFrame.map.remove(DialoguePanel.getDepth());
			BasicFrame.addToMap(ChoicePanel.getDepth(), ChoicePanel);
			BasicFrame.addThings();
			BasicFrame.repaint();
		}
			

		
	}
	
	public static void displayEventInQueueWithButton(int eventCount, int dialogueCount){
		int iconIndex;
		String iconString;
		
		int i = dialogueCount;
		int k = eventCount;
		
		if(DisplayTimeMap.size() == 0){
			System.out.println("System: Story Queue is empty");
		}
		
		//int k =GlobalV.DisplayEventCount;
		if(k <DisplayQueue.size()){
		//for(int k = 0; k <DisplayQueue.size(); k++ ){
/*
			System.out.println("System: In time "+LookUp.EventPositionMap.get(DisplayQueue.get(k).eventName)
					+" Display "+DisplayQueue.get(k).eventName
					+" Happen in " + DisplayQueue.get(k).place);	
*/
			iconString = DisplayQueue.get(k).place;
			iconIndex = LookUp.PlaceNameMap.get(iconString);
			
			//for(int i = 0; i <DisplayQueue.get(k).dialogueQueue.size(); i++){
			//int i = GlobalV.DisplayDialogueCount;
			
			if(i <DisplayQueue.get(k).dialogueQueue.size()){
/*
				System.out.println("--Sub: Dialogue " + DisplayQueue.get(k).dialogueQueue.get(i).dialogueIndex
						+ " Character: "+LookUp.CharaMap.get(DisplayQueue.get(k).dialogueQueue.get(i).charaIndex).name
						+ " Content: "+DisplayQueue.get(k).dialogueQueue.get(i).content
				);	
*/				
				String charaName;
				int charaID;
				CustomCharacter tempChara;
				//print character parts
				for(int j = 0; j < GlobalV.NumberFeatures; j++){
					charaName = LookUp.CharaMap.get(DisplayQueue.get(k).dialogueQueue.get(i).charaIndex).name;
					charaID = LookUp.CharaNameMap.get(charaName);
					tempChara = LookUp.CharaMap.get(charaID);
					
					if(LookUp.MaterialTypeIndex.get(tempChara.type) == 0){
						if(tempChara.imageIndex.get(j)<0){
							CharacterBodyParts[j].setIcon(null);
						}
						else{
							CharacterBodyParts[j].setIcon(G_Chara.Man.bodyImage.get(j).materialQueue.get(tempChara.imageIndex.get(j)));
							
						}
						//System.out.println(tempChara.imageIndex.get(j));

					}
					else if(LookUp.MaterialTypeIndex.get(tempChara.type) == 1){
						if(tempChara.imageIndex.get(j)<0){
							CharacterBodyParts[j].setIcon(null);
						}
						else{
							CharacterBodyParts[j].setIcon(G_Chara.Woman.bodyImage.get(j).materialQueue.get(tempChara.imageIndex.get(j)));
							
						}
					}
					else if(LookUp.MaterialTypeIndex.get(tempChara.type) == 2){
						if(tempChara.imageIndex.get(j)<0){
							CharacterBodyParts[j].setIcon(null);
						}
						else{
							CharacterBodyParts[j].setIcon(G_Chara.Narrator.bodyImage.get(j).materialQueue.get(tempChara.imageIndex.get(j)));
							
						}
					}					
				}
				CharacterPanel.repaint();
			}// if end
			
			BackgroundImageLabel.setIcon(G_Material.resizeImage(G_Material.Place.materialImage.get(iconIndex), BackgroundImageLabel.getWidth(), BackgroundImageLabel.getHeight()));
			BackgroundPanel.repaint();

			
			CharacterNameLabelText.setText(LookUp.CharaMap.get(DisplayQueue.get(k).dialogueQueue.get(i).charaIndex).name);
			CharacterNamePanel.repaint();
			DialogueLabelText.setText(DisplayQueue.get(k).dialogueQueue.get(i).content);
			DialoguePanel.repaint();	
			
			BasicFrame.repaint();
		}
			

		
	}
	public static void clearDisplay(){
		// parameter for display
		GlobalV.DisplayEventCount = 0;
		GlobalV.DisplayDialogueCount = 0;
		
		GlobalV.DisplayEventNumber = 0;
		GlobalV.DisplayDialogueNumber = 0;
		GlobalV.isEditting = false;
	}

}
