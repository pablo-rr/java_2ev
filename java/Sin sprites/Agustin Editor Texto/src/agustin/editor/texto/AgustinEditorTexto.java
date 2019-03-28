/**
 * @(#)EditorApp.java
 *
 *
 * @author 
 * @version 1.00 2019/1/9
 */

import java.awt.*;
import java.io.*;

public class AgustinEditorTexto extends Frame{
	MenuBar menuBar;
	TextArea texto;
	FileDialog abrirFichero;
	FileDialog guardarFichero;
	
	public static void main(String arg[]){
		AgustinEditorTexto app = new AgustinEditorTexto();
	}

    public AgustinEditorTexto(){
    	super("Editor de texto");
    	
    	setup();
    	pack();
    	resize(texto.minimumSize());
    	show();
    }
    
    public void setup(){
    	setupMenu();
    	texto = new TextArea(25,80);
    	add("Center", texto);
    	abrirFichero = new FileDialog(this, "Abrir fichero", FileDialog.LOAD);
    	guardarFichero = new FileDialog(this, "Guardar fichero", FileDialog.SAVE);
    }
    
    public void setupMenu(){
    	menuBar = new MenuBar();
    	Menu archivoMenu = new Menu("Archivo");
    	archivoMenu.add(new MenuItem("Nuevo"));
    	archivoMenu.add(new MenuItem("Abrir"));
    	archivoMenu.addSeparator();
    	archivoMenu.add(new MenuItem("Guardar"));
    	archivoMenu.addSeparator();
    	archivoMenu.add(new MenuItem("Salir"));
    	menuBar.add(archivoMenu);
    	setMenuBar(menuBar);
    }
    
    public boolean handleEvent(Event ev){ // [!] No lo creamos nosotros, "handleEvent" ya existe pero lo sobreescribimos [!]
    	if(ev.id == Event.WINDOW_DESTROY){
    		System.exit(0);
    		return true;
    	}else if(ev.id == Event.ACTION_EVENT){
    		if(ev.target instanceof MenuItem){
    			if(ev.arg.equals("Salir")){
    				System.exit(0);
    				return true;
    			}else if(ev.arg.equals("Nuevo")){
    				texto.setText(" ");
    				return true;
    			}else if(ev.arg.equals("Abrir")){
    				abrirFichero.show();
    				String inputFile = abrirFichero.getFile();
    				leerFichero(inputFile);
    				return true;
    			}else if(ev.arg.equals("Guardar")){
    				guardarFichero.show();
    				String outputFile = guardarFichero.getFile();
    				guardarFichero(outputFile);
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    public void leerFichero(String nomFichero){
    	DataInputStream inputStream;
    	try{
    		inputStream = new DataInputStream(new FileInputStream(nomFichero));
    		String nuevoTexto = "";
    		String linea;
    		while((linea = inputStream.readLine()) != null){
    			nuevoTexto += linea + "\n";
    		}
    		texto.setText(nuevoTexto);
    	}catch(FileNotFoundException ex){
    		System.out.println("El archivo no existe");
    	}catch(IOException ex){
    		// N A D A
    	}
    }
    
    public void guardarFichero(String nomFichero){
    	DataOutputStream outputStream;
    	try{
    		outputStream = new DataOutputStream(new FileOutputStream(nomFichero));
    		outputStream.writeBytes(texto.getText());
    	}catch(FileNotFoundException ex){
    		System.out.println("El archivo no existe");
    	}catch(IOException ex){
    		// N A D A
    	}
    } 
}
