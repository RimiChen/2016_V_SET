package ImageMaterial;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ImageMaterial.PathNameNumber;
import javax.swing.*;

public class ImageQueue {
	public Map<Integer, ImageIcon> materialImage;
	public ImageQueue(List<PathNameNumber> ImageSet, String fileFormat){
		
		String tempPath;
		ImageIcon tempImage;

		materialImage = new TreeMap<Integer, ImageIcon>();
		
		for(int i = 0; i < ImageSet.size(); i++){
			tempPath = ImageSet.get(i).Path + ImageSet.get(i).Name+"."+fileFormat;
			//System.out.println(tempPath);
			tempImage = new ImageIcon(tempPath);
			materialImage.put(i, tempImage);
		}
		
	}
}
