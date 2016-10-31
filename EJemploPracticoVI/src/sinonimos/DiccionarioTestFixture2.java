package sinonimos;

public class DiccionarioTestFixture2 {
    Diccionario dicctest=new Diccionario();
    
    public DiccionarioTestFixture2() {
    }

    public void setUp() {
        dicctest.getListaSinonimos().clear();
    }

    public void tearDown() {
        dicctest.getListaSinonimos().clear();
    }
}
