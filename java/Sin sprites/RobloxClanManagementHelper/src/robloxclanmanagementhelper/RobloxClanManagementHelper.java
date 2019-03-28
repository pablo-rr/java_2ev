package robloxclanmanagementhelper;

import java.awt.Event;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.util.ArrayList;
import robloxclanmanagementhelper.buttons.AddMemberButton;

public class RobloxClanManagementHelper extends Frame{
    FileDialog openFile;
    FileDialog saveFile;
    
    MenuBar menuBar;
    Menu menuFile;
    
    GridLayout appLayout;
    GridLayout membersLayout;
    
    Panel panelApp;
    Panel panelEditMember;
    Panel panelGroup;
    Panel panelMembersContainer;
    Panel panelMemberElements;
    ArrayList<Panel> panelMember;
    
    ArrayList<Member> memberList;
    
    public static void main(String[] args) {
        RobloxClanManagementHelper app = new RobloxClanManagementHelper();
    }
    
    public RobloxClanManagementHelper(){
        super("Roblox Clan Management Helper");
        setup();
        this.pack();
        this.setSize(400, 550);
        this.setVisible(true);
    }
    
    public void setup(){
        setupFrame();
        setupPanels();
        setupMenu();
    }
    
    public void setupFrame(){
        this.setResizable(false);
        this.setLocation(800, 400);
    }
    
    public void setupPanels(){
        setupEditMemberPanel();
        setupAppPanel();
    }
    
    public void setupAppPanel(){
        appLayout = new GridLayout(2, 1);
        membersLayout = new GridLayout(10, 1);
        
        panelApp = new Panel();
        panelApp.setLayout(appLayout);
        
        panelMembersContainer = new Panel();
        panelMembersContainer.setLayout(membersLayout);
        panelMember = new ArrayList<>();
        
        panelMemberElements = new Panel();
        String memberElements[] = {"Name", "Rank", "Active", "Score", "Warns"};
        panelMembersContainer.add(panelMemberElements);
        for(int i = 0; i < memberElements.length; i++){
            panelMemberElements.add(new Label(memberElements[i]));
        }
        
        memberList = new ArrayList<>();
        
        panelGroup = new Panel();
        panelGroup.add(new Label("Unnamed group"));
        panelGroup.add(new AddMemberButton(panelMember, panelMembersContainer, this, panelApp, panelEditMember));

        panelApp.add("North", panelGroup);
        panelApp.add("North", panelMembersContainer);
        this.add(panelApp);
    }
    
    public void setupEditMemberPanel(){
        panelEditMember = new Panel();
        panelEditMember.add(new Label("HIHIHI"));
        panelEditMember.setVisible(false);
        this.add(panelEditMember);
    }
    
    public void setupMenu(){
        menuBar = new MenuBar();
        menuFile = new Menu("File");
        
        menuFile.add(new MenuItem("New"));
        menuFile.add(new MenuItem("Save"));
        menuFile.addSeparator();
        menuFile.add(new MenuItem("Open.."));
        menuFile.addSeparator();
        menuFile.add(new MenuItem("Exit"));
        
        menuBar.add(menuFile);
        
        this.setMenuBar(menuBar);
    }
    
    public void addNewMember(){
        
        
        this.setVisible(true);
    }
    
    public boolean handleEvent(Event e){
        if(e.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        }else if(e.target instanceof MenuItem){
            if(e.arg.equals("Exit")){
                System.exit(0);
                return true;
            }
        }
        return false;
    }
    
}
