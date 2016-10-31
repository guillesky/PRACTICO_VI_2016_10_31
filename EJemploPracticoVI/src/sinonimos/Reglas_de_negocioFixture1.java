package sinonimos;

public class Reglas_de_negocioFixture1 {
    
    Reglas_de_negocio rg = new Reglas_de_negocio();
   
    public Reglas_de_negocioFixture1() {
    }

    public void setUp() 
    {
        rg.getDiccionario().getListaSinonimos().add(new Sinonimo("Casa","vivienda"));
        rg.getDiccionario().getListaSinonimos().add(new Sinonimo("Casa","hogar"));
        rg.getDiccionario().getListaSinonimos().add(new Sinonimo("perro","can"));
        rg.getDiccionario().getListaSinonimos().add(new Sinonimo("calle","rua"));
    }

    public void tearDown() 
    {
        rg.getDiccionario().getListaSinonimos().clear();
    }
}
