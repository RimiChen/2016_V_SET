package ImageMaterial;

import java.util.ArrayList;
import java.util.List;

import CharaMake.ImageGroup;
import ImageMaterial.PathNameNumber;

public class PlaceGroup implements ImageGroup{

	@Override
	public List<PathNameNumber> getImagePathList() {
		// TODO Auto-generated method stub
		PathNameNumber temp;
		
		List<PathNameNumber> tempList;
		tempList = new ArrayList<PathNameNumber>();
		//0
		//public BodyPartQueue BackHairDeco;
		temp = new PathNameNumber(".\\PlaceMaterials\\", "Forest", 1);
		tempList.add(temp);
		//1 Street
		temp = new PathNameNumber(".\\PlaceMaterials\\", "Street", 1);
		tempList.add(temp);

		//1 Street
		temp = new PathNameNumber(".\\PlaceMaterials\\", "Room", 1);
		tempList.add(temp);
		
		//1 Street
		temp = new PathNameNumber(".\\PlaceMaterials\\", "Farm", 1);
		tempList.add(temp);		
		
		temp = new PathNameNumber(".\\PlaceMaterials\\", "Village", 1);
		tempList.add(temp);		
		
		return tempList;
	}

}
