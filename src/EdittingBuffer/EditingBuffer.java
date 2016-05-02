package EdittingBuffer;

import java.util.ArrayList;
import java.util.List;

import Choices.StoryChoice;
import Conditions.StoryCondition;
import Events.StoryDialogue;

public class EditingBuffer {
	public static List<StoryDialogue> BufferedDialogue;
	public static List<StoryCondition> BufferedCondition;
	public static List<StoryChoice> BufferedChoice;
	
	public EditingBuffer(){
		BufferedDialogue = new ArrayList<StoryDialogue>();
		BufferedCondition = new ArrayList<StoryCondition>();
		BufferedChoice = new ArrayList<StoryChoice>();		
	}
}
