package gorka;

public class BlocNotas implements Libro{
    Hoja hoja;
    
    @Override
    public void leerPagina(int pagina){
        abrirTapas();
        abrirAnilla();
        sacarHoja();
        leer(hoja);
    }

    private void abrirTapas() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void abrirAnilla() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void sacarHoja() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
