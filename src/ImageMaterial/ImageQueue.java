package ImageMaterial;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import CharaMake.BodyPartQueue;
import CharaMake.PathNameNumber;
import Variables.GlobalV;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageQueue {
	public Map<Integer, ImageIcon> materialImage;
	public ImageQueue(List<PathNameNumber> ImageSet){
		
		String tempPath;
		BufferedImage tempPic;
		ImageIcon tempImage;

		materialImage = new TreeMap<Integer, ImageIcon>();
		
		for(int i = 0; i < ImageSet.size(); i++){
			tempPath = ImageSet.get(i).Path + ImageSet.get(i).Name+".jpg";
			//System.out.println(tempPath);
			tempImage = new ImageIcon(tempPath);
			materialImage.put(i, tempImage);
		}
		
	}
}
