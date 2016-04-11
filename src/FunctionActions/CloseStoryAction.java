package FunctionActions;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Display.G_Display;

public class CloseStoryAction extends WindowAdapter{
    @Override
    public void windowClosing(WindowEvent e)
    {
        System.out.println("Closed");
        G_Display.clearDisplay();
        e.getWindow().dispose();
    }
}
