package robloxclanmanagementhelper.buttons;

import java.awt.Button;
import java.awt.Event;
import java.awt.Panel;
import robloxclanmanagementhelper.RobloxClanManagementHelper;

public class EditMemberButton extends Button{
    Panel panelApp;
    Panel panelEdit;
    RobloxClanManagementHelper app;
    
    public EditMemberButton(Panel pA, Panel pE, RobloxClanManagementHelper a){
        super("Edit member");
        panelApp = pA;
        panelEdit = pE;
        app = a;
    }
    
    public boolean action(Event e, Object o){
        panelApp.setVisible(false);
        panelEdit.setVisible(true);
        System.out.print("PO");
        app.setVisible(true);
        return true;
    }
    
}
