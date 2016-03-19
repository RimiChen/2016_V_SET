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
import Events.G_Event;
import Events.StoryEvent;
import Events.SubLabel;
import ImageMaterial.G_Material;
import MainScreen.G_Components;
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

	
	public G_Display(){
		DisplayQueue = new ArrayList<StoryEvent>();
		DisplayTimeMap = new TreeMap<Integer, StoryEvent>();
		StoryFrame = new JFrame();
		StoryFrame.setTitle("Story Display");
		StoryFrame.setSize(GlobalV.WindowWidth, GlobalV.WindowHeight);
		StoryFrame.setLocation(300, 300);
		StoryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		StoryFrame.setLayout(null);

		
		// depth is smaller, is more front
		
		BasicFrame = new GroupFrame(0, 0, StoryFrame.getWidth(), StoryFrame.getHeight(), 0);
		//BasicFrame .setBackground(new Color(255, 255, 255));

		
		
		
		//Character name
		CharacterNamePanel = new GroupFrame(50, StoryFrame.getHeight()-250, 150, 50, 0);
		CharacterNamePanel.setBackground(new Color(255, 255, 255));

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
		
		DialogueLabelImage = new SubLabel(0, 0, DialoguePanel.getWidth(), DialoguePanel.getHeight(), 1, "", new Color(0, 0, 0), false);
		DialogueLabelImage.setIcon(G_Material.resizeImage(G_Material.Dialogue.materialImage.get(0), DialogueLabelImage.getWidth(), DialogueLabelImage.getHeight()));

		DialogueLabelText = new SubLabel(0, 0, DialoguePanel.getWidth(), DialoguePanel.getHeight(), 0,"Test Content", new Color(0, 0, 0), false);
		DialogueLabelText.setFont(new Font("Arial", Font.BOLD, 20));
		DialogueLabelText.setForeground(new Color(141, 54, 0));
		
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
		BackgroundPanel.setBackground(new Color(255, 255, 0));
		BackgroundImageLabel = new SubLabel(0, 0, BackgroundPanel.getWidth(), BackgroundPanel.getHeight(), 0, "", new Color(0, 0, 0), false) ;

		BackgroundPanel.addToMap(BackgroundImageLabel.getDepth(), BackgroundImageLabel);
		BackgroundPanel.addThings();
		
		BasicFrame.addToMap(BackgroundPanel.getDepth(), BackgroundPanel);

		BasicFrame.addThings();
		StoryFrame.add(BasicFrame);
		
	}
	public static void compileStory(){

		GlobalV.isEditting = true;
		StoryFrame.setVisible(true);

		loadStoryInQueue();
		displayEventInQueue();
		
		GlobalV.isEditting = false;
	}
	public static void loadStoryInQueue(){
		// In first version start from page 1
		String currentEventName; 
		int currentEventIndex;
		StoryEvent tempEvent;
		for(int key : LookUp.EventTimeMap.keySet())
		{
			currentEventName = LookUp.EventTimeMap.get(key);
			currentEventIndex = LookUp.EventNameMap.get(currentEventName);
			tempEvent = LookUp.EventMap.get(currentEventIndex);
			DisplayQueue.add(tempEvent);
			DisplayTimeMap.put(key, tempEvent);
		}		
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
				String charaType;
				
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
				}
				CharacterPanel.repaint();
				
				CharacterNameLabelText.setText(LookUp.CharaMap.get(DisplayTimeMap.get(key).dialogueQueue.get(i).charaIndex).name);
				CharacterNamePanel.repaint();
				DialogueLabelText.setText(DisplayTimeMap.get(key).dialogueQueue.get(i).content);
				DialoguePanel.repaint();
				
			}
		} 
	}
	public static void displayEventInQueueWithTimer(){
	}
	public static void displayEventInQueueWithButton(){
	}

}
