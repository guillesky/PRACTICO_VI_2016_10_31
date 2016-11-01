package sinonimos;

import java.io.File;


public class Reglas_de_negocioFixture2 {
    
    Reglas_de_negocio rg;
    
    public Reglas_de_negocioFixture2() {
        File archivo = new File("sinonimos.xml");
        if (archivo.exists())archivo.delete(); 
        rg = new Reglas_de_negocio();
    }

    public void setUp() {
        rg.getDiccionario().getListaSinonimos().clear();
    }

    public void tearDown() {
        rg.getDiccionario().getListaSinonimos().clear();
    }
}
