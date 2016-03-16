/*
 * This class is vector x, y, z
 */
package BasicStructures;

public class Vector3 {

	public float x;
	public float y;
	public float z;

	//initialize values
	public Vector3(float X, float Y, float Z){
		setVector3(X, Y, Z);
	}
	//Update values
	public void setVector3(float X, float Y, float Z){
		setX(X);
		setY(Y);
		setZ(Z);
	}
	
	//set X
	public void setX(float X){
		this.x = X;
	}
	//set Y
	public void setY(float Y){
		this.y = Y;
	}	
	//set Z
	public void setZ(float Z){
		this.z = Z;
	}	

	
	// get X
	public float getX(){
		return x;
	}
	//get Y
	public float getY(){
		return y;
	}
	//get Z
	public float getZ(){
		return z;
	}

}
