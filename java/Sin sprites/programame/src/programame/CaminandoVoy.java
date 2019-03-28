package programame;

import java.util.ArrayList;
import java.util.Scanner;

public class CaminandoVoy {
    static Scanner scanner;
    static int maximaAlturaPosible;
    static int numeroPicos;
    static ArrayList<String> listaAlturas;
    static int parte;
    static int maximaAlturaRegistrada;
    
    static String datosJuntosString;
    static String[] datosSeparadosString;
    static ArrayList<Integer> datosNumericos;
    
    public static void main(String[] args){
        maximaAlturaRegistrada = 0;
        scanner = new Scanner(System.in);
        parte = 0;
        recogerDatos(2);
        procesarDatosNumericos();
        comprobarAlturas();
    }
    
    public static void comprobarAlturas(){
        if(maximaAlturaRegistrada  >= maximaAlturaPosible){
            System.out.println("NO APTO");
            
        }else{
            System.out.println("APTO");
        }
    }
    
    public static void procesarDatosNumericos(){
        int loopVar = 0;
        while(datosNumericos.get(loopVar) < datosNumericos.get(loopVar+1)){
            maximaAlturaRegistrada += Math.abs((datosNumericos.get(loopVar+1) - datosNumericos.get(loopVar)));
            loopVar++;
            if(loopVar == datosNumericos.size()-1){
                break;
            }
        }
    }
    
    public static void cambiarA_datosNumericos(String[] dS, ArrayList<Integer> dN){
        for(int j = 0; j < dS.length; j++){
            int parseDato = Integer.parseInt(dS[j]);
            dN.add(parseDato);
        }
    }
    
    public static boolean comprobarValidez(int modo){
        if(parte % 2 == 0){
            if(maximaAlturaPosible > 1000000 || maximaAlturaPosible < 0){
                return false;
            }
        }else{
            for(int i = 0; i < datosNumericos.size(); i++){
                if(datosNumericos.get(i) > 1000000 || datosNumericos.get(i) < 0){
                    return false;
                }
            }
        }
        return true;
    }
    
    private static void recogerDatos(int maxDatos){
        listaAlturas = new ArrayList<>();
        for(int i = 0; i < maxDatos; i++){
            cargarDatos();
            if(parte % 2 == 0){
                cambiarA_datosNumericos(datosSeparadosString, datosNumericos);
                maximaAlturaPosible = datosNumericos.get(0);
                numeroPicos = datosNumericos.get(1);
                if(!comprobarValidez(parte)){
                    System.out.println("Datos invalidos, vuelva a introducirlos");
                    datosJuntosString = scanner.nextLine();
                    i = 0;
                    //cargarDatos();
                    parte--;
                }
            }else{
                cambiarA_datosNumericos(datosSeparadosString, datosNumericos);
                if(!comprobarValidez(parte)){
                    System.out.println("Datos invalidos, vuelva a introducirlos");
                    datosJuntosString = scanner.nextLine();
                    i = 0;
                    //cargarDatos();
                    parte--;
                }
            }
            parte++;
        }
    }

    private static void cargarDatos() {
        datosJuntosString = scanner.nextLine();
        datosSeparadosString = datosJuntosString.split(" ");
        datosNumericos = new ArrayList<>();
    }
    
}