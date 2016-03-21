/*
 * This part handles the character buttons and character editing screen
 */
package CharacterScreen;

import java.awt.Color;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JLabel;

import CharaMake.BodyPartQueue;
import CharaMake.CharaModel;
import CharaMake.CharaModelList;
import CharaMake.CustomCharacter;
import CharaMake.ManGroup;
import ImageMaterial.PathNameNumber;
import CharaMake.WomanGroup;
import MainScreen.CharacterButton;
import MainScreen.G_Components;
import MainScreen.GroupFrame;
import Variables.GlobalV;
import Variables.LookUp;

public class G_Chara {
	//public static CharacterButton
	public static GroupFrame charaButtonPanel;
	public static Map<String, CharacterButton> CharacterButtonMap;
	public static GroupFrame charaEdittingPanel;

	public static GroupFrame charaFeaturePanel;
	public static GroupFrame charaNamePanel;
	public static GroupFrame decisionPanel;
	public static GroupFrame charaPanel;
	public static GroupFrame typePanel;
	
	
	//the panels for character setting

	public ManGroup manPicPath;
	public static CharaModelList Man;
	public WomanGroup womanPicPath;
	public static CharaModelList Woman;

	public List<PathNameNumber> imageSet;

	/*
	 * Buttons in Character editting panel
	 */
	
	//chara Feature
	public static ImageDownButton[] nextImage;
	public static ImageUpButton[] lastImage;
	public static BodyNameLabel[] bodyName;
	public static GroupFrame bodyNextPanel;
	public static GroupFrame bodyLastPanel;
	public static GroupFrame bodyLabelPanel;
	
	
	//Chara Name
	public static CharaName nameField;

	//Chara Decision
	public static CharaYesButton saveEdit;
	public static CharaNoButton cancelEdit;
	
	//CharaPanel
	public static CharaPartPanel[] Chara;
	
	//Type panel
	public static TypeButton ManType;
	public static TypeButton WomanType;
	
	public G_Chara(){
		CharacterButtonMap = new TreeMap<String, CharacterButton>();
		initialCharacterButtonPanel(0);
		initialCharacterEdittingPanel(0);
		
		initialCharaFeaturePanel(0);
		initialCharaNamePanel(1);
		initialDecisionPanel(2);
		initialCharaPanel(3);
		initialTypePanel(4);
		
		
		
		charaEdittingPanel.addToMap(charaFeaturePanel.getDepth(), charaFeaturePanel);
		charaEdittingPanel.addToMap(charaNamePanel.getDepth(), charaNamePanel);
		charaEdittingPanel.addToMap(decisionPanel.getDepth(), decisionPanel);
		charaEdittingPanel.addToMap(charaPanel.getDepth(), charaPanel);
		charaEdittingPanel.addToMap(typePanel.getDepth(), typePanel);
		charaEdittingPanel.addThings();

		
		//initialize image material
		manPicPath = new ManGroup();
		imageSet = manPicPath.getImagePathList();
		Man = new CharaModelList(imageSet);

		womanPicPath = new WomanGroup();
		imageSet = womanPicPath.getImagePathList();
		Woman = new CharaModelList(imageSet);	
		
		
		// feature panel
		bodyLastPanel = new GroupFrame(0, 0, charaFeaturePanel.getWidth()/4, charaFeaturePanel.getHeight(), 0);
		bodyLabelPanel = new GroupFrame(charaFeaturePanel.getWidth()*1 /4, 0, charaFeaturePanel.getWidth()*2/4, charaFeaturePanel.getHeight(), 1);
		bodyNextPanel = new GroupFrame(charaFeaturePanel.getWidth()*3 /4, 0, charaFeaturePanel.getWidth()/4, charaFeaturePanel.getHeight(), 2);
		charaFeaturePanel.addToMap(bodyLastPanel.getDepth(), bodyLastPanel);
		charaFeaturePanel.addToMap(bodyLabelPanel.getDepth(), bodyLabelPanel);
		charaFeaturePanel.addToMap(bodyNextPanel.getDepth(), bodyNextPanel);
		charaFeaturePanel.addThings();

		nextImage = new ImageDownButton[GlobalV.NumberFeatures];
		lastImage = new ImageUpButton[GlobalV.NumberFeatures];
		bodyName = new BodyNameLabel[GlobalV.NumberFeatures];
		for(int i = 0; i< GlobalV.NumberFeatures; i++){
			lastImage[i] = new ImageUpButton(
					0,
					i * bodyLastPanel.getHeight()/GlobalV.NumberFeatures,
					bodyLastPanel.getWidth(),
					bodyLastPanel.getHeight()/GlobalV.NumberFeatures,
					i,
					LookUp.FeatureName.get(i)
			);
			bodyLastPanel.addToMap(lastImage[i].getDepth(), lastImage[i]);
			bodyName[i] = new BodyNameLabel(
					0,
					i * bodyLabelPanel.getHeight()/GlobalV.NumberFeatures,
					bodyLabelPanel.getWidth(),
					bodyLabelPanel.getHeight()/GlobalV.NumberFeatures,
					i,
					LookUp.FeatureName.get(i)
			);
			bodyLabelPanel.addToMap(bodyName[i].getDepth(), bodyName[i]);
			nextImage[i] = new ImageDownButton(
					0,
					i * bodyNextPanel.getHeight()/GlobalV.NumberFeatures,
					bodyNextPanel.getWidth(),
					bodyNextPanel.getHeight()/GlobalV.NumberFeatures,
					i,
					LookUp.FeatureName.get(i)
			);			
			bodyNextPanel.addToMap(nextImage[i].getDepth(), nextImage[i]);
			
			bodyLastPanel.addThings();
			bodyLabelPanel.addThings();
			bodyNextPanel.addThings();
			//nextImage[i] = new ImageDownButton()
			
		}
		
		//Type panel
		//typePanel = new  GroupFrame(0, charaFeaturePanel.getY()+charaFeaturePanel.getHeight()+5, 200, 30, )
		ManType = new TypeButton(0, 0, typePanel.getWidth()/2, typePanel.getHeight(),0 );
		ManType.setText("Man");
		WomanType = new TypeButton(ManType.getWidth(), 0, typePanel.getWidth()/2, typePanel.getHeight(),1 );
		WomanType.setText("Woman");
		typePanel.addToMap(ManType.getDepth(), ManType);
		typePanel.addToMap(WomanType.getDepth(), WomanType);
		typePanel.addThings();
		
		//decision
		saveEdit = new CharaYesButton( 0, 0, 100, decisionPanel.getHeight(), 0);
		saveEdit.setText("Save Edit");
		cancelEdit = new CharaNoButton( 100, 0, 100, decisionPanel.getHeight(), 1);
		cancelEdit.setText("Cancel Edit");
		
		decisionPanel.addToMap(saveEdit.getDepth(), saveEdit);
		decisionPanel.addToMap(cancelEdit.getDepth(), cancelEdit);
		decisionPanel.addThings();

		//name 
		nameField = new CharaName(0, 0, charaNamePanel.getWidth(), charaNamePanel.getHeight(), 0);

		charaNamePanel.addToMap(nameField.getDepth(), nameField);
		charaNamePanel.addThings();
		
		
		
		Chara = new CharaPartPanel[GlobalV.NumberFeatures];
		for(int i = 0; i <GlobalV.NumberFeatures; i++){
			Chara[i] = new 	CharaPartPanel(Man.bodyImage.get(i).getCurrentImage(), 0, 0, charaPanel.getWidth(), charaPanel.getHeight(), (-1)*i);		
			//charaPanel.addToMap(Chara[i].getDepth(), Chara[i]);
		}
		
/*		
		//initilize chara feature labels
		charaPanel.addThings(); 
*/	
	}
	public void initialCharacterButtonPanel(int depth){
		charaButtonPanel = new GroupFrame(
				0,
				0,
				G_Components.currentContent.getWidth(),
				G_Components.menuList.getHeight() * GlobalV.UsablePropotion/100 /GlobalV.CharaPropotion,
				depth
		);

/*
		charaButtonPanel = new GroupFrame(
				0,
				G_Components.menuList.getHeight()* GlobalV.UsablePropotion/100 *(GlobalV.CharaPropotion-1)/GlobalV.CharaPropotion,
				G_Components.currentContent.getWidth(),
				G_Components.menuList.getHeight() * GlobalV.UsablePropotion/100 /GlobalV.CharaPropotion,
				depth
		);
*/		
		charaButtonPanel.setBackground(new Color(255, 255, 255));
		charaButtonPanel.setLayout(null);
		charaButtonPanel.setVisible(true);			
	}
	public void initialCharacterEdittingPanel(int depth){
		charaEdittingPanel = new GroupFrame(
				0,
				0,
				G_Components.currentContent.getWidth(),
				G_Components.currentContent.getHeight(),
				depth
		);
		//charaEdittingPanel.setBackground(new Color(0, 255, 255));
		charaEdittingPanel.setLayout(null);
		charaEdittingPanel.setVisible(true);			
	}
	public void initialCharaFeaturePanel(int depth){
		charaFeaturePanel = new GroupFrame(
				0,
				0,
				charaEdittingPanel.getWidth()/ 4,
				charaEdittingPanel.getHeight()/2,
				depth
		);
		//charaFeaturePanel.setBackground(new Color(255, 0, 0));
		charaFeaturePanel.setLayout(null);
		charaFeaturePanel.setVisible(true);		
	}
	public void initialCharaNamePanel(int depth){
		charaNamePanel = new GroupFrame(
				0 ,
				G_Components.currentContent.getHeight()-150,
				100,
				40,
				depth
		);
		//charaNamePanel.setBackground(new Color(255, 0, 0));
		charaNamePanel.setLayout(null);
		charaNamePanel.setVisible(true);		
	}
	public void initialDecisionPanel(int depth){
		decisionPanel = new GroupFrame(
				0,
				G_Components.currentContent.getHeight()-100,
				200,
				40,
				depth
		);
		//decisionPanel.setBackground(new Color(255,0 ,0 ));
		decisionPanel.setLayout(null);
		decisionPanel.setVisible(true);		
	}
	public void initialCharaPanel(int depth){
		charaPanel = new GroupFrame(
				300,
				5,
				200,
				550,
				depth
		);
		charaPanel.setBackground(new Color(255,0 ,0 ));
		charaPanel.setLayout(null);
		charaPanel.setVisible(true);		
	}
	public void initialTypePanel(int depth){
		typePanel = new GroupFrame(
				0,
				charaFeaturePanel.getY()+charaFeaturePanel.getHeight()+5,
				200,
				30,
				depth
		);
		typePanel.setOpaque(true);
		typePanel.setBackground(new Color(255, 0, 0));
		typePanel.setVisible(true);	
		
	}
	public static void updateCharaPanel(CustomCharacter chara){
		
		charaPanel.removeAll();
		//charaPanel.map.clear();
		if(LookUp.MaterialTypeIndex.get(chara.type) == 0){
			//Man
			for(int i = 0; i < GlobalV.NumberFeatures; i++){
				//System.out.println(chara.imageIndex.size());
				//System.out.print("*  " +chara.imageIndex.get(i));
				if(chara.imageIndex.get(i)< 0){
					Chara[i] = new 	CharaPartPanel(null, 0, 0, charaPanel.getWidth(), charaPanel.getHeight(), (-1)*i);		
				}
				else{
					Chara[i] = new 	CharaPartPanel(Man.bodyImage.get(i).materialQueue.get(chara.imageIndex.get(i)), 0, 0, charaPanel.getWidth(), charaPanel.getHeight(), (-1)*i);		
				}
				charaPanel.addToMap(Chara[i].getDepth(), Chara[i]);
			}
			//charaPanel.addThings();
			//System.out.println("");
		}
		else if(LookUp.MaterialTypeIndex.get(chara.type) == 1){
			//Woman
			for(int i = 0; i < GlobalV.NumberFeatures; i++){
				//System.out.print("*  " +chara.imageIndex.get(i));
				if(chara.imageIndex.get(i)< 0){
					Chara[i] = new 	CharaPartPanel(null, 0, 0, charaPanel.getWidth(), charaPanel.getHeight(), (-1)*i);		
				}
				else{
					Chara[i] = new 	CharaPartPanel(Woman.bodyImage.get(i).materialQueue.get(chara.imageIndex.get(i)), 0, 0, charaPanel.getWidth(), charaPanel.getHeight(), (-1)*i);		
				}
				charaPanel.addToMap(Chara[i].getDepth(), Chara[i]);
			}
			//charaPanel.addThings();
			//System.out.println("");
		}
		charaPanel.addThings();
		charaPanel.repaint();
		
	}
	public static CustomCharacter getNextPic(int index, CustomCharacter chara){
		if(LookUp.MaterialTypeIndex.get(chara.type) == 0){
			//Man
			if(chara.imageIndex.get(index)>=0){
				chara.imageIndex.set(index, (chara.imageIndex.get(index)+1)% Man.bodyImage.get(index).materialQueue.size());
			}
			else{
				//empty queue
				//System.out.println(index);
			}
		}
		else if(LookUp.MaterialTypeIndex.get(chara.type) == 1){
			//Woman
			if(chara.imageIndex.get(index)>=0 ){
				chara.imageIndex.set(index, (chara.imageIndex.get(index)+1)% Woman.bodyImage.get(index).materialQueue.size());
			}
			else{
				//empty queue
			}
		}		
		return chara;
	}
	public static CustomCharacter getLastPic(int index, CustomCharacter chara){
		if(LookUp.MaterialTypeIndex.get(chara.type) == 0){
			//Man
			if(chara.imageIndex.get(index)>=0){
				chara.imageIndex.set(index, (chara.imageIndex.get(index)+Man.bodyImage.get(index).materialQueue.size()-1)% Man.bodyImage.get(index).materialQueue.size());
			}
			else{
				//empty queue
			}
		}
		else if(LookUp.MaterialTypeIndex.get(chara.type) == 1){
			//Woman
			if(chara.imageIndex.get(index)>=0){
				chara.imageIndex.set(index, (chara.imageIndex.get(index)+Woman.bodyImage.get(index).materialQueue.size()-1)% Woman.bodyImage.get(index).materialQueue.size());
			}
			else{
				//empty queue
			}
		}		
		return chara;
	}	

}
