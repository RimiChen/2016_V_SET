/*
 *This class is for RGB color
 */
package BasicStructures;

public class ColorVectorRGB {
	public float r;
	public float g;
	public float b;

	//initialize values
	public ColorVectorRGB(float R, float G, float B){
		setColorVector(R, G, B);
	}
	//Update values
	public void setColorVector(float R, float G, float B){
		setR(R);
		setG(G);
		setB(B);
	}
	
	//set R
	public void setR(float R){
		this.r = R;
	}
	//set G
	public void setG(float G){
		this.g = G;
	}	
	//set B
	public void setB(float B){
		this.b = B;
	}
	
	// get R
	public float getR(){
		return r;
	}
	//get G
	public float getG(){
		return g;
	}
	//get B
	public float getB(){
		return b;
	}
	
}
