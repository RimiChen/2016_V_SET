package Choices;

import Variables.GlobalV;

public class StoryVariables {
	public int index;
	public String varName;
	private int currentValue;
	
	public StoryVariables(int index, String varName){
		this.index = index;
		this.varName = varName;
		currentValue = 0;
	}
	public int getCurrentValue(){
		return currentValue;
	}
	public void setCurrentValue(int newValue){
		currentValue = newValue;
	}
	public void makeChange(String operator, String value){
		int target = Integer.parseInt(value);
		if(operator.equals("+")){
			currentValue = currentValue + target;
		}
		else if(operator.equals("-")){
			if(currentValue > target){
				currentValue = currentValue - target;
			}
		}
	}
	public boolean checkMatch(String operator, String value){
		boolean result = false;
		int target = Integer.parseInt(value);
		if(operator.equals("=")||operator.equals("==")){
			if(currentValue == target){
				result = true;
			}
		}
		else if(operator.equals(">")){
			if(currentValue > target){
				result = true;
			}
			
		}
		else if(operator.equals("<")){
			if(currentValue < target){
				result = true;
			}
			
		}
		else if(operator.equals(">=")){
			if(currentValue >= target){
				result = true;
			}
			
		}
		else if(operator.equals("<=")){
			if(currentValue <= target){
				result = true;
			}
			
		}
		return result;
	}
	
}
