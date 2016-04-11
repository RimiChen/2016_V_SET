package CharaMake;

import java.util.*;

import javax.swing.*;

public class BodyPartQueue {
	public String nameString;
	public int numberOfImages;
	public List<ImageIcon> materialQueue;
	public int currentImage;
	
	
	public BodyPartQueue(String FilePath, String NameString, int NumberOfImages){
		String tempPath;
		ImageIcon tempImage;
		currentImage = 0;
		materialQueue = new ArrayList<ImageIcon>();

		for(int i = 1; i<= NumberOfImages; i++){
			if(i<10){
				tempPath = FilePath + NameString + "0" + i + ".png";
			}
			else{
				tempPath = FilePath + NameString + i + ".png";
			}
			//System.out.println(tempPath);
			tempImage = new ImageIcon(tempPath);
			materialQueue.add(tempImage);
		}
		
		if(materialQueue.size()>0){
			currentImage = 0;
		}
		else{
			currentImage = -1;
		}
	}
	public ImageIcon getCurrentImage(){
		if(currentImage < 0){
			return null;
		}
		else{
			return materialQueue.get(currentImage);
		}
	}
	public ImageIcon getNextImage(){
		if(currentImage < 0){
			return null;
		}
		else{
			currentImage = (currentImage+1)% materialQueue.size();
			return materialQueue.get(currentImage);
		}
	}
	public ImageIcon getPreImage(){
		if(currentImage < 0){
			return null;
		}
		else{
			currentImage = (currentImage-1)% materialQueue.size();
			return materialQueue.get(currentImage);
		}
	}
	
}
