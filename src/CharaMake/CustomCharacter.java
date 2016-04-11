package CharaMake;

import java.util.ArrayList;
import java.util.List;

import CharacterScreen.G_Chara;

public class CustomCharacter {
	public int index;
	public String name;
	public List<Integer> imageIndex;
	public List<Integer> recordedImage;
	public String type;
	
	public CustomCharacter(int Index, List<Integer> InitImagIndex){
		this.index = Index;
		this.name = "aa" + Index;
		imageIndex = new ArrayList<Integer>();
		recordedImage = new ArrayList<Integer>();
		this.imageIndex.addAll(InitImagIndex);
		this.recordedImage.addAll(InitImagIndex);
		this.type = "Man";
	}
	public void updateImageList(CharaModelList Target){
		for(int i = 0; i < imageIndex.size(); i++){
			if(imageIndex.get(i) >= Target.bodyImage.get(i).materialQueue.size()){
				//if new typr chara has less images
				imageIndex.set(i, Target.initCharaImageSet.get(i));
			}
		}
	}
	public void displayImage(CharaModelList Target){
		G_Chara.charaFeaturePanel.removeAll();
		for(int i = 0; i < G_Chara.Chara.length; i++){
			G_Chara.Chara[i].setIcon(Target.bodyImage.get(i).materialQueue.get(imageIndex.get(i)));
		}
		G_Chara.charaFeaturePanel.addThings();
		G_Chara.charaFeaturePanel.repaint();
	}
}
