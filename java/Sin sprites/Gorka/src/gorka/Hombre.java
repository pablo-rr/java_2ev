package gorka;

import java.util.ArrayList;
import java.util.List;

public class Hombre implements Periodista, Estudiante{

    @Override
    public List creatNoticias() {
        List<String> noticias = new ArrayList<>();
        noticias.add("El madrid apesta");
        noticias.add("Java mola mucho");
        return noticias;
    }

    @Override
    public void estudiar(Libro libro) {
        libro.leerPagina(1);
        libro.leerPagina(2);
        libro.leerPagina(3);
        libro.leerPagina(4);
        libro.leerPagina(5);
        libro.leerPagina(6);
        libro.leerPagina(7);
        libro.leerPagina(8);
    }
    
}
