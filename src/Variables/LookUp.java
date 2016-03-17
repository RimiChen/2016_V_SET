package Variables;

import java.util.Map;
import java.util.TreeMap;

import CharaMake.CustomCharacter;
import Events.StoryEvent;

public class LookUp {
	public static Map<Integer, String> FeatureName;
	public static Map<String, Integer> FeatureIndex;
	
	public static Map<Integer, String> MaterialTypeName;
	public static Map<String, Integer> MaterialTypeIndex;
	
	public static Map<Integer, CustomCharacter> CharaMap;
	public static Map<String, Integer> CharaNameMap;
	
	public static Map<Integer, StoryEvent> EventMap;
	public static Map<String, Integer> EventNameMap;

	
	public LookUp(){
		FeatureName = new TreeMap<Integer, String>();
		FeatureIndex = new TreeMap<String, Integer>();
		addFeatureInfo();
		
		MaterialTypeName = new TreeMap<Integer, String>();
		MaterialTypeIndex = new TreeMap<String, Integer>();
		addMaterialInfo();
		
		CharaMap = new TreeMap<Integer, CustomCharacter>();	
		CharaNameMap = new TreeMap<String, Integer>();
		
		
	}
	public void addFeatureInfo(){
		FeatureName.put(0, "BackHairDeco");
		FeatureName.put(1, "BackHair");
		FeatureName.put(2, "MidHairDeco");
		FeatureName.put(3, "BackHeadDeco");
		FeatureName.put(4, "FaceBody");
		FeatureName.put(5, "Eye");
		FeatureName.put(6, "Eyebow");
		FeatureName.put(7, "Mouth");
		FeatureName.put(8, "FaceDeco");
		FeatureName.put(9, "Shoes");
		FeatureName.put(10, "Pants");
		FeatureName.put(11, "Cloth");
		FeatureName.put(12, "FrontHair");
		
		FeatureIndex.put("BackHairDeco", 0);
		FeatureIndex.put("BackHair", 1);
		FeatureIndex.put("MidHairDeco", 2);
		FeatureIndex.put("BackHeadDeco", 3);
		FeatureIndex.put("FaceBody", 4);
		FeatureIndex.put("Eye", 5);
		FeatureIndex.put("Eyebow", 6);
		FeatureIndex.put("Mouth", 7);
		FeatureIndex.put("FaceDeco", 8);
		FeatureIndex.put("Shoes", 9);
		FeatureIndex.put("Pants", 10);
		FeatureIndex.put("Cloth", 11);
		FeatureIndex.put("FrontHair", 12);
	}	
	public void addMaterialInfo(){
		MaterialTypeName.put(0, "Man");
		MaterialTypeName.put(1, "Woman");
		
		MaterialTypeIndex.put("Man", 0);
		MaterialTypeIndex.put("Woman", 1);
	}
}
