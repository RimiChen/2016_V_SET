package ImageMaterial;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import ImageMaterial.PathNameNumber;

public class G_Material {
	public List<PathNameNumber> imageSet;

	public PlaceGroup placePicPath;
	public static ImageQueue Place;
	
	public DialogueGroup dialoguePicPath;
	public static ImageQueue Dialogue;
	
	public NameCardGroup nameCardPicPath;
	public static ImageQueue NameCard;
	
	
	public G_Material(){
		
		imageSet = new ArrayList<PathNameNumber>();
		
		placePicPath = new PlaceGroup();
		imageSet = placePicPath.getImagePathList();
		Place = new ImageQueue(imageSet, "jpg");

		dialoguePicPath = new DialogueGroup();
		imageSet = dialoguePicPath.getImagePathList();
		Dialogue = new ImageQueue(imageSet, "png");
		
		nameCardPicPath = new NameCardGroup();
		imageSet = nameCardPicPath.getImagePathList();
		NameCard = new ImageQueue(imageSet, "png");

	}
	public static ImageIcon resizeImage(ImageIcon img, int width, int height){
    	ImageIcon resultImage;
		resultImage = img;
    	Image tempImg = img.getImage();
    	tempImg = tempImg.getScaledInstance(width, height, Image.SCALE_DEFAULT);
    	resultImage = new ImageIcon(tempImg);		
    	
    	return resultImage;
	}
}
