package Choices;

import java.util.Map;
import java.util.TreeMap;

import Variables.GlobalV;
import Variables.LookUp;

public class G_Variables {
	//handle condition variables
	public static Map<Integer, StoryVariables> variableMap;
	
	public G_Variables(){
		variableMap = new TreeMap<Integer, StoryVariables>();
	}
	public static boolean checkVariableExist(String target){
		boolean result = false;
		if(LookUp.VariableNameMap.size()<=0){
			//System.out.println("111111111111not exist");
			result = false;
		}
		else{
			if(LookUp.VariableNameMap.get(target) == null){
				result = false;
				//System.out.println("*************not exist");
			}
			else{
				//System.out.println("*************exist");
				result = true;
			}
		}
		return result;
	}
	public static void addNewVariable(String name){
		if(checkVariableExist(name)==false){
			StoryVariables tempVar;
			GlobalV.currentVariableNumber++;
		
			tempVar = new StoryVariables(GlobalV.currentVariableNumber, name);
			variableMap.put(tempVar.index, tempVar);
			LookUp.VariableMap.put(tempVar.index, tempVar.varName);
			LookUp.VariableNameMap.put(tempVar.varName, tempVar.index );
		}
		else{
			System.out.println("System: This variable "+ name+" is already exist");
		}
	}
}
