package restaurante;

import java.awt.Choice;
import java.awt.Event;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.util.ArrayList;

public class Restaurante extends Frame{
    int resX, resY;
    ArrayList<String> userCommand;
    String[] foodChoices;
    List foodList;
    TextArea commandShownInScreen;
    String command;
    String commandIntroText;
    
    // menus
    MenuBar menuBar;
    
    // menuCommand (mC_[...])
    Menu menuCommand;
    MenuItem mC_newCommand;
    MenuItem mC_exit;
    
    
    
    public static void main(String[] args) {
        Restaurante app = new Restaurante();
    }

    public Restaurante(){
        super("FoodCommander");
        setup();
        pack();
        resize(resX, resY);
        show();
    }
    
    public void setup(){
        setupFrame();
        setupApp();
        setupLayout();
        setupMenu();
    }
    
    public void setupApp(){
        commandIntroText = "Comanda: ";
        userCommand = new ArrayList<>();
        foodChoices = new String[] {"Ternera", "Pollo", "Cerdo", "Costilla", "Lentejas", "Espinacas", "Patatas brabas", "Jamon"};
        foodList = new List();
        foodList.setMultipleMode(true);
        commandShownInScreen = new TextArea(2, 20);
        command = new String();
        for(int i = 0; i < foodChoices.length; i++){
            foodList.addItem(foodChoices[i]);
        }
        commandShownInScreen.setText(commandIntroText);
    }
    
    public void setupLayout(){
        this.add("North", new Label("Elige tu comanda"));
        this.add("East", foodList);
        this.add("South", commandShownInScreen);
    }
    
    public void setupFrame(){
        resX = resY = 300;
        this.setResizable(false);
        this.setLocation(800, 400);
    }
    
    public void setupMenu(){
        menuBar = new MenuBar();
        menuCommand = new Menu("FoodCommander");
        mC_newCommand = new MenuItem("Nueva comanda");
        mC_exit = new MenuItem("Salir");
        
        // menuCommand (mC_[...])
        menuCommand.add(mC_newCommand);
        menuCommand.addSeparator();
        menuCommand.add(mC_exit);
        
        menuBar.add(menuCommand);
        
        this.setMenuBar(menuBar);
    }
    
    public void addFood(){
        String[] selectedFood = foodList.getSelectedItems();
        command = commandIntroText;
        for(int i = 0; i < selectedFood.length; i++){
            command += selectedFood[i] + ", ";
        }
        commandShownInScreen.setText(command);
    }
    
    public void removeFood(){
        int[] selectedFood = foodList.getSelectedIndexes();
        command = commandIntroText;
        for(int i = 0; i < selectedFood.length; i++){
            command += foodList.getSelectedItems()[i] + ", ";
        }
        commandShownInScreen.setText(command);
    }
    
    public void reset(){
        //setupApp();
        //commandShownInScreen.setText(commandIntroText);
        for(int i = 0; i < foodChoices.length; i++){
            foodList.deselect(i);
        }
        commandShownInScreen.setText(commandIntroText);
    }
    
    public boolean handleEvent(Event e){
        if(e.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
            
        }else if (e.id == Event.LIST_SELECT){
            addFood();
            return true;
            
        }else if (e.id == Event.LIST_DESELECT){
            removeFood();
            return true;
            
        }else if (e.target instanceof MenuItem){
            if(e.arg == "Salir"){
                System.exit(0);
                return true;
            }else if(e.arg == "Nueva comanda"){
                reset();
                return true;
            }
        }
        return false;
    }
    
}
