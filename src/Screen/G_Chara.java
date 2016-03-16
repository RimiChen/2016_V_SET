package Screen;

import java.awt.Color;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JLabel;

import Variables.GlobalV;

public class G_Chara {
	//public static CharacterButton
	public static GroupFrame charaButtonPanel;
	public static Map<String, CharacterButton> CharacterButtonMap;
	public static GroupFrame charaEdittingPanel;

	public static GroupFrame charaFeaturePanel;
	public static GroupFrame charaNamePanel;
	public static GroupFrame decisionPanel;
	public static GroupFrame charaPanel;
	
	
	
	public G_Chara(){
		CharacterButtonMap = new TreeMap<String, CharacterButton>();
		initialCharacterButtonPanel(0);
		initialCharacterEdittingPanel(0);
		
		initialCharaFeaturePanel(0);
		initialCharaNamePanel(1);
		initialDecisionPanel(2);
		initialCharaPanel(3);
		
		
		
		charaEdittingPanel.addToMap(charaFeaturePanel.getDepth(), charaFeaturePanel);
		charaEdittingPanel.addToMap(charaNamePanel.getDepth(), charaNamePanel);
		charaEdittingPanel.addToMap(decisionPanel.getDepth(), decisionPanel);
		charaEdittingPanel.addToMap(charaPanel.getDepth(), charaPanel);
		charaEdittingPanel.addThings();
		
		

	
	}
	public void initialCharacterButtonPanel(int depth){
		charaButtonPanel = new GroupFrame(
				0,
				G_Components.menuList.getHeight()* GlobalV.UsablePropotion/100 *(GlobalV.CharaPropotion-1)/GlobalV.CharaPropotion,
				G_Components.currentContent.getWidth(),
				G_Components.menuList.getHeight() * GlobalV.UsablePropotion/100 /GlobalV.CharaPropotion,
				depth
		);
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
		charaFeaturePanel.setBackground(new Color(255, 0, 0));
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
		charaNamePanel.setBackground(new Color(255, 0, 0));
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
		decisionPanel.setBackground(new Color(255,0 ,0 ));
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

	
}
