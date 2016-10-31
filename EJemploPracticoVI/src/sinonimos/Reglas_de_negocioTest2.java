package sinonimos;

/*====================================================================================
     * Juego de entradas a la clase y salidas esperadas
     * ====================================Agregar_Sinonimo===============================
     * Si la lista esta vacia y el sinonimo es valido --> debe agregarse sin problemas
     * Si la lista esta vacia pero el sinonimo no es valido -->> debe devolver una excepcion
     * =====================================================================================
     * =================================Eliminar_Sinonimo===================================
     * Sinonimo valido y lista vacia --> devolver excepcion
     * =====================================================================================
     * =================================Buscar_Sinonimos====================================
     * Si la lista esta vacia -> devolver una excepcion
     * ======================================================================================
     */

import junit.framework.JUnit4TestAdapter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;

public class Reglas_de_negocioTest2
{
    Reglas_de_negocioFixture2 rgFixture2 = new Reglas_de_negocioFixture2();

    public Reglas_de_negocioTest2()
    {
    }

    public static void main(String[] args)
    {
        String[] args2 = { Reglas_de_negocioTest2.class.getName() };
        JUnitCore.main(args2);
    }

    @Before
    public void setUp() throws Exception
    {
        rgFixture2.setUp();
    }

    @After
    public void tearDown() throws Exception
    {
        rgFixture2.tearDown();
    }


    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter(Reglas_de_negocioTest2.class);
    }

    /**
     * @see Reglas_de_negocio#agregarsinonimo(String,String)
     */
    @Test
    public void testAgregarsinonimo4()
    {
        rgFixture2.rg.setOptionPane(new MockOptionPane());
        rgFixture2.rg.agregarsinonimo("Casa", "hogar");
        Assert.assertEquals("No Detecto Agregado Valido", "No Excepcion",
                            ((MockOptionPane) rgFixture2.rg.getOptionPane()).getMessage());
    }

    /**
     * @see Reglas_de_negocio#agregarsinonimo(String,String)
     */
    @Test
    public void testAgregarsinonimo5()
    {
        rgFixture2.rg.setOptionPane(new MockOptionPane());
        rgFixture2.rg.agregarsinonimo(null, null);
        Assert.assertEquals("No Detecto Agregado de Sinonimo Invalido", "Sinonimo Invalido",
                            ((MockOptionPane) rgFixture2.rg.getOptionPane()).getMessage());

    }

    /**
     * @see Reglas_de_negocio#eliminarsinonimo(String,String)
     */
    @Test
    public void testEliminarsinonimo4()
    {
        rgFixture2.rg.setOptionPane(new MockOptionPane());
        rgFixture2.rg.eliminarsinonimo("Casa", "hogar");
        Assert.assertEquals("No Detecto Diccionario Vacio", "Diccionario Vacio",
                            ((MockOptionPane) rgFixture2.rg.getOptionPane()).getMessage());
    }

    /**
     * @see Reglas_de_negocio#leosinonimo(String)
     */
    @Test
    public void testLeosinonimo3()
    {
        rgFixture2.rg.setOptionPane(new MockOptionPane());
        rgFixture2.rg.leosinonimo("perro");
        Assert.assertEquals("No Detecto Diccionario Vacio", "Diccionario Vacio",
                            ((MockOptionPane) rgFixture2.rg.getOptionPane()).getMessage());
    }
}
