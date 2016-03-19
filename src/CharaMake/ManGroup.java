package CharaMake;

import java.util.ArrayList;
import java.util.List;

import ImageMaterial.PathNameNumber;

public class ManGroup implements ImageGroup{

	@Override
	public List<PathNameNumber> getImagePathList() {
		// TODO Auto-generated method stub
		PathNameNumber temp;
		
		List<PathNameNumber> tempList;
		tempList = new ArrayList<PathNameNumber>();
		//0
		//public BodyPartQueue BackHairDeco;
		temp = new PathNameNumber(".\\CharaMaterials\\Man\\", "BackHairDeco", 0);
		tempList.add(temp);
		//1
		//public BodyPartQueue BackHair;
		temp = new PathNameNumber(".\\CharaMaterials\\Man\\", "BackHair", 3);
		tempList.add(temp);
		//2
		//public BodyPartQueue MidHairDeco;
		temp = new PathNameNumber(".\\CharaMaterials\\Man\\", "MidHairDeco", 0);
		tempList.add(temp);
		//3
		//public BodyPartQueue MidHeadDeco;
		temp = new PathNameNumber(".\\CharaMaterials\\Man\\", "MidHeadDeco", 0);
		tempList.add(temp);
		//4
		//public BodyPartQueue FaceBody;
		temp = new PathNameNumber(".\\CharaMaterials\\Man\\", "FaceBody", 1);
		tempList.add(temp);
		//5
		//public BodyPartQueue Eye;
		temp = new PathNameNumber(".\\CharaMaterials\\Man\\", "Eye", 4);
		tempList.add(temp);
		//6
		//public BodyPartQueue Eyebow;
		temp = new PathNameNumber(".\\CharaMaterials\\Man\\", "Eyebow", 4);
		tempList.add(temp);
		//7
		//public BodyPartQueue Mouth;
		temp = new PathNameNumber(".\\CharaMaterials\\Man\\", "Mouth", 9);
		tempList.add(temp);

		//8
		//public BodyPartQueue FaceDeco;
		temp = new PathNameNumber(".\\CharaMaterials\\Man\\", "FaceDeco", 0);
		tempList.add(temp);

		//9
		//public BodyPartQueue Shoes;
		temp = new PathNameNumber(".\\CharaMaterials\\Man\\", "Shoes", 1);
		tempList.add(temp);

		//10
		//public BodyPartQueue Pants;
		temp = new PathNameNumber(".\\CharaMaterials\\Man\\", "Pants", 2);
		tempList.add(temp);
		//11
		//public BodyPartQueue Cloth;
		temp = new PathNameNumber(".\\CharaMaterials\\Man\\", "Cloth", 3);
		tempList.add(temp);
		
		//12
		//public BodyPartQueue FrontHair;	
		temp = new PathNameNumber(".\\CharaMaterials\\Man\\", "FrontHair", 3);
		tempList.add(temp);
		
		return tempList;
	}

}
