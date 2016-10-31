package sinonimos;
/*====================================================================================
 * La prueba de persistencia debe demostrar :
 * Se puede crear un Diccionario Vacio
 * Se pueden agregar Sinonimos y que estos persistan al momento de ser agregados
 * Se puedan eliminar Sinonimos y que estos persistan al momento de ser eliminados
 * ======================================================================================
 */

import junit.framework.JUnit4TestAdapter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

public class PersistenciaTest
{

    Reglas_de_negocio rg = new Reglas_de_negocio();

    public PersistenciaTest()
    {
    }

    public static void main(String[] args)
    {
        String[] args2 = { PersistenciaTest.class.getName() };
        JUnitCore.main(args2);
    }

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {

    }

    @BeforeClass
    public static void setUpBeforeClass()
    {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {

    }

    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter(PersistenciaTest.class);
    }

    /**
     * @see Persistencia#getInstancia()
     */
    @Test
    public void testGetInstancia()
    {
        Persistencia persis = Persistencia.getInstancia();
        Assert.assertNotNull("No se pudo instanciar mecanismo de persistencia", persis);
    }

    /**
     * @see persistencia#persistir(diccionario)
     */

    @Test
    public void testPersistir()
    {
        Persistencia persis = Persistencia.getInstancia();
        rg.agregarsinonimo("uno", "dos");
        rg.agregarsinonimo("uno", "tres");
        Diccionario dicpersis = persis.despersitir();
        Assert.assertNotEquals("Persistencia incorrecta (alta) Memoria > Disco", rg.getDiccionario(), dicpersis);
        rg.eliminarsinonimo("uno", "dos");
        rg.eliminarsinonimo("uno", "tres");
        dicpersis = persis.despersitir();
        Assert.assertNotEquals("Persistencia incorrecta (baja) Memoria > Disco", rg.getDiccionario(), dicpersis);
    }

    /**
     * @see Persistencia#despersitir()
     */
    @Test
    public void testDespersitir()
    {
        Persistencia persis = Persistencia.getInstancia();
        persis.persistir(rg.getDiccionario());
        Diccionario dicpersis = persis.despersitir();
        Assert.assertNotEquals("Persistencia incorrecta Disco > Memoria", rg.getDiccionario(), dicpersis);
    }
}
