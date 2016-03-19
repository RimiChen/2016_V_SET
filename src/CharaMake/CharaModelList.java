package CharaMake;

import java.util.ArrayList;
import java.util.List;

import ImageMaterial.PathNameNumber;
import Variables.GlobalV;

public class CharaModelList {
	//0
	//public BodyPartQueue BackHairDeco;
	//1
	//public BodyPartQueue BackHair;
	//2
	//public BodyPartQueue MidHairDeco;
	//3
	//public BodyPartQueue MidHeadDeco;
	//4
	//public BodyPartQueue FaceBody;
	//5
	//public BodyPartQueue Eye;
	//6
	//public BodyPartQueue Eyebow;
	//7
	//public BodyPartQueue Mouth;
	//8
	//public BodyPartQueue FaceDeco;
	//9
	//public BodyPartQueue Shoes;
	//10
	//public BodyPartQueue Pants;
	//11
	//public BodyPartQueue Cloth;
	//12
	//public BodyPartQueue FrontHair;
	
	public List<BodyPartQueue> bodyImage;
	public List<Integer> initCharaImageSet;
	
	
	public CharaModelList(List<PathNameNumber> ImageSet){
		bodyImage = new ArrayList<BodyPartQueue>();
		initCharaImageSet = new ArrayList<Integer>();
		
		BodyPartQueue tempQueue;
		
		for(int i = 0; i < GlobalV.NumberFeatures; i++){
			tempQueue = new BodyPartQueue(ImageSet.get(i).Path, ImageSet.get(i).Name, ImageSet.get(i).Number);
			bodyImage.add(tempQueue);
			initCharaImageSet.add(tempQueue.currentImage);
		}
	}
}
