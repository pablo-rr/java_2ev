package robloxclanmanagementhelper.buttons;

import java.awt.Button;
import java.awt.Event;
import java.awt.Label;
import java.awt.Panel;
import java.util.ArrayList;
import robloxclanmanagementhelper.RobloxClanManagementHelper;

public class AddMemberButton extends Button{
    ArrayList<Panel> panelMember;
    Panel panelMembersContainer;
    RobloxClanManagementHelper app;
    Panel panelEditMember;
    Panel panelApp;
    
    public AddMemberButton(ArrayList<Panel> pM, Panel pMC, RobloxClanManagementHelper a, Panel pA, Panel pEM){
        super("Add member");
        panelMember = pM;
        panelMembersContainer = pMC;
        app = a;
        panelEditMember = pEM;
        panelApp = pA;
    }
    
    public boolean action(Event e, Object o){
        panelMember.add(new Panel());
        int lastAdd = panelMember.size()-1;
        
        for(int i = 0; i < 5; i++){
            panelMember.get(lastAdd).add(new Label("[...]"));
        }
        
        panelMember.get(lastAdd).add(new EditMemberButton(panelApp, panelEditMember, app));
        
        for(int i = 0; i <= lastAdd; i++){
            panelMembersContainer.add(panelMember.get(lastAdd));
        }
        
        app.setVisible(true);
        return true;
    }
    
}
