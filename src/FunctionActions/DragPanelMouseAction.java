package FunctionActions;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import Events.G_Event;

import Variables.GlobalV;

public class DragPanelMouseAction extends MouseAdapter{

	
	@Override
    public void mouseClicked(MouseEvent e) {
	}

    @Override
    public void mousePressed(MouseEvent e) {
       	//System.out.println("Mouse pressed " + e.getPoint() +e.getPoint().x +", " +e.getPoint().y);
       	
       	G_Event.region.updateStartPos(e.getPoint().x, e.getPoint().y);
      	G_Event.DragPanel.addToMap(G_Event.region.getDepth(), G_Event.region);
      	G_Event.DragPanel.removeAll();
      	G_Event.DragPanel.addThings();
      	G_Event.DragPanel.repaint();
      	G_Event.StorylinePanel.repaint();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
       	//System.out.println("Mouse release " + e.getPoint());
       	//G_Event.DragPanel.map.clear();
      	//G_Event.DragPanel.addToMap(G_Event.region.getDepth(), G_Event.region);
      	
    	//Create a new event
      	G_Event.createNewEvent(G_Event.region.getX(), G_Event.region.getY(), G_Event.region.getWidth(), G_Event.region.getHeight(), "", "");
      	
      	//update event transfer
      	
      	
    	GlobalV.isEditting = false;
    	G_Event.region.updateStartPos(0, 0);
      	G_Event.region.updateSize(0, 0);

      	G_Event.DragPanel.removeAll();
      	 
       	G_Event.DragPanel.map.remove(G_Event.region.getDepth());
      	G_Event.DragPanel.addThings();
      	G_Event.DragPanel.repaint();
      	G_Event.StorylinePanel.removeAll();
      	G_Event.StorylinePanel.map.remove(G_Event.DragPanel.getDepth());
      	//C_Event.StorylinePanel.
      	G_Event.StorylinePanel.addThings();
      	G_Event.StorylinePanel.repaint();
      	

      	
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    	//System.out.println("Mouse drag " + e.getPoint());
      	G_Event.region.updateSize(e.getPoint().x -G_Event.region.getX() , e.getPoint().y-G_Event.region.getY());
    	G_Event.DragPanel.removeAll();
      	G_Event.DragPanel.addToMap(G_Event.region.getDepth(), G_Event.region);
      	G_Event.DragPanel.addThings();
      	G_Event.DragPanel.repaint();
      	G_Event.StorylinePanel.repaint();
      	    	
    }
}
