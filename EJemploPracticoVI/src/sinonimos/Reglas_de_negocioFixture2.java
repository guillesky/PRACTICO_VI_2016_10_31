package sinonimos;


public class Reglas_de_negocioFixture2 {
    
    Reglas_de_negocio rg = new Reglas_de_negocio();
    
    public Reglas_de_negocioFixture2() {
    }

    public void setUp() {
        rg.getDiccionario().getListaSinonimos().clear();
    }

    public void tearDown() {
        rg.getDiccionario().getListaSinonimos().clear();
    }
}
