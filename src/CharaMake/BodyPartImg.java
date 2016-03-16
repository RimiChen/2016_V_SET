package CharaMake;

public interface BodyPartImg {
	
	//return depth of the part
	public int getDepth();
	public void setDepth();
	
	//is visible
	public void setVisible();
	public void setInvisible();
	
	//get image path
	public String getImgPath();
	public void setImgPath(String ImgPath);
	
	//index
	public int getImgIndex();
	public void setImgIndex();
}
