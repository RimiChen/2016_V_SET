package EdittingBuffer;

import java.util.ArrayList;
import java.util.List;

import Events.StoryDialogue;

public class EditingBuffer {
	public static List<StoryDialogue> BufferedDialogue;
	
	public EditingBuffer(){
		BufferedDialogue = new ArrayList<StoryDialogue>();
	}
}
