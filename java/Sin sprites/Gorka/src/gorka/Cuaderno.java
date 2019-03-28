/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gorka;

/**
 *
 * @author 1h
 */
public class Cuaderno implements Libro{
    Hoja hoja;
    
    @Override
    public void leerPagina(int pagina) {
        abrirTapas();
        leer(hoja);
    }

    private void abrirTapas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
