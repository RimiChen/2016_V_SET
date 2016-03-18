package ImageMaterial;

import java.util.ArrayList;
import java.util.List;

import CharaMake.ImageGroup;
import CharaMake.PathNameNumber;

public class PlaceGroup implements ImageGroup{

	@Override
	public List<PathNameNumber> getImagePathList() {
		// TODO Auto-generated method stub
		PathNameNumber temp;
		
		List<PathNameNumber> tempList;
		tempList = new ArrayList<PathNameNumber>();
		//0
		//public BodyPartQueue BackHairDeco;
		//temp = new PathNameNumber(".\\CharaMaterials\\Man\\", "BackHairDeco", 0);
		//tempList.add(temp);

		return tempList;
	}

}
