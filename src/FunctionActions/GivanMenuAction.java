package FunctionActions;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Events.GivenMenu;

public class GivanMenuAction implements ListSelectionListener {

	public GivenMenu targetList;
	//public Given()
	public GivanMenuAction(GivenMenu targetList){
		this.targetList = targetList;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
        if(arg0.getValueIsAdjusting()){  
    		System.out.println("From list "+targetList.getSelectedValue());
        	
    		//int index = list.getSelectedIndex();  
            //System.out.println(index);  
            //String selectedItem = list.getSelectedValue().toString();  
              
        }  		
	}
}