/*
 * This class is vector x, y
 */

package BasicStructures;

public class Vector2 {
	public float x;
	public float y;

	//initialize values
	public Vector2(float X, float Y){
		setVector2(X, Y);
	}
	//Update values
	public void setVector2(float X, float Y){
		setX(X);
		setY(Y);
	}
	public void setVector2(Vector2 input){
		setX(input.getX());
		setY(input.getY());
	}
	
	//set X
	public void setX(float X){
		this.x = X;
	}
	//set Y
	public void setY(float Y){
		this.y = Y;
	}
	
	//get X
	public float getX(){
		return x;
	}
	//get Y
	public float getY(){
		return y;
	}
}
