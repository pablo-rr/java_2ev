package texteditor;

import java.awt.Event;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;

public class TextEditor extends Frame{
    MenuBar menuBar;
    Menu menuDocument;
    FileDialog saveFile, openFile;
    TextArea editor;
    
    public static void main(String[] args){
        TextEditor app = new TextEditor();
    }

    public void setup(){
        setupFrame();
        setupApp();
        setupMenu();
    }
        
    public void setupFrame(){
        this.setResizable(false);
    }
    
    public void setupApp(){
        saveFile = new FileDialog(this, "Save file", FileDialog.SAVE);
        openFile = new FileDialog(this, "Save file", FileDialog.LOAD);
        editor = new TextArea(30, 80);
        this.add("Center", editor);
    }
    
    public void setupMenu(){
        menuBar = new MenuBar();
        menuDocument = new Menu("Document");
        
        menuDocument.add(new MenuItem("New"));
        menuDocument.add(new MenuItem("Save"));
        menuDocument.addSeparator();
        menuDocument.add(new MenuItem("Open.."));
        menuDocument.addSeparator();
        menuDocument.add(new MenuItem("Exit"));
        
        menuBar.add(menuDocument);
        this.setMenuBar(menuBar);
    }
    
    public TextEditor(){
        super("Textedit");
        setup();
        pack();
        resize(editor.getMinimumSize());
        show();
    }
    
    public boolean handleEvent(Event e){
        if(e.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        }else if(e.target instanceof MenuItem){
            if(e.arg.equals("New")){
                editor.setText(" ");
                return true; 
            }else if(e.arg.equals("Save")){
                saveFile.show();
                return true;
            }else if(e.arg.equals("Open")){
                
                return true;
            }else if(e.arg.equals("Exit")){
                System.exit(0);
                return true;
            }
        }
        return false;
    }
}
