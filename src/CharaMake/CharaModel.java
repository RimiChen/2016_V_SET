package CharaMake;

import java.util.List;

public class CharaModel {
	//0
	public BodyPartQueue BackHairDeco;
	//1
	public BodyPartQueue BackHair;
	//2
	public BodyPartQueue MidHairDeco;
	//3
	public BodyPartQueue MidHeadDeco;
	//4
	public BodyPartQueue FaceBody;
	//5
	public BodyPartQueue Eye;
	//6
	public BodyPartQueue Eyebow;
	//7
	public BodyPartQueue Mouth;
	//8
	public BodyPartQueue FaceDeco;
	//9
	public BodyPartQueue Shoes;
	//10
	public BodyPartQueue Pants;
	//11
	public BodyPartQueue Cloth;
	//12
	public BodyPartQueue FrontHair;

	
	
	public CharaModel(List<PathNameNumber> ImageSet){
		BackHairDeco = new BodyPartQueue(ImageSet.get(0).Path, ImageSet.get(0).Name, ImageSet.get(0).Number);
		BackHair = new BodyPartQueue(ImageSet.get(1).Path, ImageSet.get(1).Name, ImageSet.get(1).Number);
		MidHairDeco = new BodyPartQueue(ImageSet.get(2).Path, ImageSet.get(2).Name, ImageSet.get(2).Number);
		MidHeadDeco = new BodyPartQueue(ImageSet.get(3).Path, ImageSet.get(3).Name, ImageSet.get(3).Number);
		FaceBody = new BodyPartQueue(ImageSet.get(4).Path, ImageSet.get(4).Name, ImageSet.get(4).Number);
		Eye= new BodyPartQueue(ImageSet.get(5).Path, ImageSet.get(5).Name, ImageSet.get(5).Number);
		Eyebow = new BodyPartQueue(ImageSet.get(6).Path, ImageSet.get(6).Name, ImageSet.get(6).Number);
		Mouth = new BodyPartQueue(ImageSet.get(7).Path, ImageSet.get(7).Name, ImageSet.get(7).Number);
		FaceDeco = new BodyPartQueue(ImageSet.get(8).Path, ImageSet.get(8).Name, ImageSet.get(8).Number);
		Shoes = new BodyPartQueue(ImageSet.get(9).Path, ImageSet.get(9).Name, ImageSet.get(9).Number);
		Pants = new BodyPartQueue(ImageSet.get(10).Path, ImageSet.get(10).Name, ImageSet.get(10).Number);
		Cloth = new BodyPartQueue(ImageSet.get(11).Path, ImageSet.get(11).Name, ImageSet.get(11).Number);
		FrontHair = new BodyPartQueue(ImageSet.get(12).Path, ImageSet.get(12).Name, ImageSet.get(12).Number);
	}
}
