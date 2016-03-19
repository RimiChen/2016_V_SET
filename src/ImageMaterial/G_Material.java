package ImageMaterial;

import java.util.ArrayList;
import java.util.List;

import ImageMaterial.PathNameNumber;

public class G_Material {
	public PlaceGroup placePicPath;
	public static ImageQueue Place;
	public List<PathNameNumber> imageSet;
	
	public G_Material(){
		
		imageSet = new ArrayList<PathNameNumber>();
		
		placePicPath = new PlaceGroup();
		imageSet = placePicPath.getImagePathList();
		Place = new ImageQueue(imageSet);
	}
}
