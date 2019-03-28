package programame;

public class Tu_amigable_vecino {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int posiciones[] = {100, 1000, 400}; // Primer int = Posicion de Peter. El resto de ints es la posicion del resto de bombas
        boolean valido = true;
        String razonInvalido = "";
        int distanciaTotal = 0;
        
        for(int i = 0; i < posiciones.length; i++){
            if(posiciones.length <= 3 || posiciones.length > 3){
                if(i == 0){
                    if(posiciones[0] <= 0){
                        valido = false;
                        razonInvalido = "La posicion de Peter no puede ser inferior a 0 metros";
                    }
                }else{
                    if(posiciones[i] >= 10000){
                        valido = false;
                        razonInvalido = "La posicion de las bombas no puede ser mayor de 10.000 metros";
                    }
                }
            }else{
                valido = false;
                razonInvalido = "El Duende verde ha puesto dos bombas";
            }
        }
        
        if(valido){
            for(int i = 1, j = 0; i < posiciones.length; i++, j++){
                if(posiciones[i] > posiciones[j]){
                    int guardado = posiciones[j];
                    posiciones[j] = posiciones[i];
                    posiciones[i] = guardado;
                }
            }

            for(int i = 1, j = 0; i < posiciones.length; i++, j++){
                int distanciaHastaLaSiguienteBomba = posiciones[i] - posiciones[j];
                if(distanciaHastaLaSiguienteBomba < 0){
                    distanciaHastaLaSiguienteBomba *= -1;
                }
                distanciaTotal += distanciaHastaLaSiguienteBomba;
            }
            System.out.println("Peter tiene que recorrer " + distanciaTotal + " metros");
        }else{
            System.out.println(razonInvalido);
        }
    }
    
}

/*
public void readTest{List<String> lineas}{

    for

String a = "gorka sanz";
a.split(" ")

String [] 
}

if(a < 10000 a>0){
    throw new RuntimeException();
}
*/