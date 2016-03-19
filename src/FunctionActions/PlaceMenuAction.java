package FunctionActions;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.event.ListSelectionEvent;

import Events.G_Event;
import Events.GivenMenu;
import Events.StoryEvent;
import ImageMaterial.G_Material;
import Variables.GlobalV;
import Variables.LookUp;

public class PlaceMenuAction extends GivanMenuAction{
	StoryEvent nowEvent;
	public PlaceMenuAction(GivenMenu targetList) {
		super(targetList);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
        
		nowEvent = LookUp.EventMap.get(LookUp.EventNameMap.get(GlobalV.CurrentEditingEvent));
		if(arg0.getValueIsAdjusting()){  
    		//System.out.println("New From list "+targetList.getSelectedValue());
        	
           	String placeName = (String) targetList.getSelectedValue();
           	G_Event.setPlacePreview(placeName);
           	GlobalV.CurrentChosenPlace = placeName;
           	nowEvent.tempPlace = placeName;
           	
        }  		
	}	

}
