package FunctionActions;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Events.G_Event;
import MainScreen.G_Components;
import Variables.GlobalV;
import Variables.LookUp;

public class MovePanelMouseAction extends MouseAdapter{
	int currentX;
	int currentY;
	int diffX;
	int diffY;
	boolean isTarget = false;
	
	@Override
    public void mouseClicked(MouseEvent e) {
	}

    @Override
    public void mousePressed(MouseEvent e) {
       	//System.out.println("Mouse pressed " + e.getPoint() +e.getPoint().x +", " +e.getPoint().y);
       	
        //G_Event.region.updateStartPos(e.getPoint().x, e.getPoint().y);
      	currentX = e.getPoint().x;
      	currentY = e.getPoint().y;
    	if(isTarget == false){
    		GlobalV.CurrentEditingEvent =  returnEventIndex(currentX, currentY);
    		//System.out.println("empty");
    	}
 
    	if(GlobalV.CurrentEditingEvent == ""){
    		// drag something
        	//System.out.println("empty");    	
    	}
    	else{
    		// click on empty space
    		diffX = currentX - G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).EventLabelMap.get(GlobalV.CurrentEditingEvent).getX();
    		diffY = currentY - G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).EventLabelMap.get(GlobalV.CurrentEditingEvent).getY();
        	//System.out.println((e.getPoint().x-diffX) +", " +(e.getPoint().y-diffY));    		
    	}

    }

    @Override
    public void mouseReleased(MouseEvent e) {
       	//System.out.println("Mouse release " + e.getPoint());
       	//G_Event.DragPanel.map.clear();
      	//G_Event.DragPanel.addToMap(G_Event.region.getDepth(), G_Event.region);
      	
    	//Create a new event
      	//G_Event.createNewEvent(G_Event.region.getX(), G_Event.region.getY(), G_Event.region.getWidth(), G_Event.region.getHeight());
      	
    	if(isTarget == true){
	    	GlobalV.isEditting = false;
	    	isTarget = false;
	    	
	    	int newY =e.getPoint().y-diffY;
	    	
	    	int oldPosition;
	    	
	    	
	    	oldPosition = LookUp.EventPositionMap.get(GlobalV.CurrentEdittingPage).get(GlobalV.CurrentEditingEvent);
	    	LookUp.EventPositionMap.get(GlobalV.CurrentEdittingPage).remove(GlobalV.CurrentEditingEvent);
			LookUp.EventPositionMap.get(GlobalV.CurrentEdittingPage).put(GlobalV.CurrentEditingEvent, newY);
	    	
			LookUp.EventTimeMap.get(GlobalV.CurrentEdittingPage).remove(oldPosition);
			LookUp.EventTimeMap.get(GlobalV.CurrentEdittingPage).put(newY, GlobalV.CurrentEditingEvent);
			
	    	
	    	G_Event.paintEventButton();
	

	      	
	      	
	      	G_Event.MovePanel.removeAll();
	      	G_Event.MovePanel.addThings();
	      	G_Event.MovePanel.repaint();
	      	G_Event.StorylinePanel.removeAll();
	      	G_Event.StorylinePanel.map.remove(G_Event.MovePanel.getDepth());
	      	//C_Event.StorylinePanel.
	      	G_Event.StorylinePanel.addThings();
	      	G_Event.StorylinePanel.repaint();
    	}	

      	
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    	//System.out.println("Mouse drag " + e.getPoint());
      	//G_Event.region.updateSize(e.getPoint().x -G_Event.region.getX() , e.getPoint().y-G_Event.region.getY());
    	if(GlobalV.CurrentEditingEvent == ""){
    		// drag something
    	
    	}
    	else{
    		// click on empty space
        	//System.out.println((e.getPoint().x-diffX) +", " +(e.getPoint().y-diffY));
    		G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).EventLabelMap.get(GlobalV.CurrentEditingEvent).setLocation(e.getPoint().x-diffX, e.getPoint().y-diffY);
    		G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).EventButtonMap.get(GlobalV.CurrentEditingEvent).setLocation(e.getPoint().x-diffX, e.getPoint().y-diffY);
    		
    		
    		G_Event.paintEventLabel();
    		
			G_Event.StorylinePanel.addToMap(G_Event.MovePanel.getDepth(), G_Event.MovePanel);
			G_Event.StorylinePanel.removeAll();
			G_Event.StorylinePanel.addThings();
			G_Event.StorylinePanel.repaint();
			G_Components.mainScreen.repaint();   		
    	}
    }
    
    public String returnEventIndex(int x, int y){
    	String result = "";
    	for(String key: G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).EventLabelMap.keySet()){
    		if(x >= G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).EventLabelMap.get(key).getX() 
    		   && 
    		   x <= G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).EventLabelMap.get(key).getX()+ G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).EventLabelMap.get(key).getWidth()
    		){
    			
    			if(y >= G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).EventLabelMap.get(key).getY() 
    		   		   && 
    		   		   y <= G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).EventLabelMap.get(key).getY()+ G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).EventLabelMap.get(key).getHeight()
    		    ){
    				
    				
    				result = G_Event.EventPageMap.get(GlobalV.CurrentEdittingPage).EventLabelMap.get(key).getText();
    				System.out.println("System: "+ "Now moving event " +result);
    				isTarget = true;
    				
    				return result;
    			}
    			
    			
    		}
    	}
    	return result;
    }
}
