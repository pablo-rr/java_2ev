package robloxclanmanagementhelper.buttons;

import java.awt.Button;
import java.awt.Event;
import java.awt.Panel;

public class EditGroupButton extends Button{
    Panel app;
    Panel edit;
    
    public EditGroupButton(Panel pA, Panel pEG){
        super("Edit group");
        app = pA;
        edit = pEG;
    }
    
    public boolean action(Event e, Object o){
        app.setVisible(false);
        edit.setVisible(true);
        
        return true;
    }
    
}
