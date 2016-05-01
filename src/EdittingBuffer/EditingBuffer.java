package EdittingBuffer;

import java.util.ArrayList;
import java.util.List;

import Conditions.StoryCondition;
import Events.StoryDialogue;

public class EditingBuffer {
	public static List<StoryDialogue> BufferedDialogue;
	public static List<StoryCondition> BufferedCondition;
	
	public EditingBuffer(){
		BufferedDialogue = new ArrayList<StoryDialogue>();
		BufferedCondition = new ArrayList<StoryCondition>();
	}
}
