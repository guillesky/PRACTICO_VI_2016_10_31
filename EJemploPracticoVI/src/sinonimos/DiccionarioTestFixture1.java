package sinonimos;

public class DiccionarioTestFixture1
{
    Diccionario dicctest = new Diccionario();

    public DiccionarioTestFixture1()
    {
    }

    public void setUp()
    {
        dicctest.getListaSinonimos().add(new Sinonimo("Casa", "vivienda"));
        dicctest.getListaSinonimos().add(new Sinonimo("Casa", "hogar"));
        dicctest.getListaSinonimos().add(new Sinonimo("perro", "can"));
        dicctest.getListaSinonimos().add(new Sinonimo("calle", "rua"));
    }

    public void tearDown()
    {
        dicctest.getListaSinonimos().clear();
    }
}
