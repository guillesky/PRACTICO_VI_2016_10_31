package sinonimos;

/*====================================================================================
 * Juego de entradas a la clase y salidas esperadas
 * ====================================Agregar_Sinonimo===============================
 * Sinonimo Nulo  --> debe devolver una excepcion
 * Sinonimo valido pero repetido --> debe devolver una excepcion
 * Sinonimo valido que no esta en la Lista --> debe agregarlo sin problemas
 * =====================================================================================
 * =================================Eliminar_Sinonimo===================================
 * Sinonimo Nulo --> devolver una excepcion
 * Sinonimo valido pero no esta en la lista --> devolver una excepcion
 * Sinonimo valido y esta en la lista --> Eliminarlo sin problemas
 * =====================================================================================
 * =================================Buscar_Sinonimos====================================
 * Si no se encuentran sinonimos en la  Lista --> devolver una excepcion
 * si la palabra_clave se encuentra en una o mas entradas de la lista --> devolver la 
 * lista completa de sinonimos de esa palabra
 * ======================================================================================
 */

import junit.framework.JUnit4TestAdapter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

/* El uso del DiccionarioTestSuite nos permite asumir que la clase diccionario esta comprabada
 * entonces nuestros alternativas seran las siguientes 
 * */
public class Reglas_de_negocioTest1 {
   
    Reglas_de_negocioFixture1 rgFixture1 = new Reglas_de_negocioFixture1();
  
    public Reglas_de_negocioTest1() {
    }

    public static void main(String[] args) {
        String[] args2 = { Reglas_de_negocioTest1.class.getName() };
        JUnitCore.main(args2);
    }

    @Before
    public void setUp() throws Exception {
        rgFixture1.setUp();    
    }

    @After
    public void tearDown() throws Exception {
        rgFixture1.tearDown();
    }

  
    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(Reglas_de_negocioTest1.class);
    }

    /**
     * @see Reglas_de_negocio#agregarsinonimo(String,String)
     */
    
    @Test
    public void testAgregarsinonimo1() 
    {
        rgFixture1.rg.setOptionPane(new MockOptionPane());
        rgFixture1.rg.agregarsinonimo(null, null);
        Assert.assertEquals("No Detecto Agregado de Sinonimo Nulo", "Sinonimo Invalido",  ((MockOptionPane) rgFixture1.rg.getOptionPane()).getMessage());
    }

    @Test
    public void testAgregarsinonimo2()
    {
        rgFixture1.rg.setOptionPane(new MockOptionPane());
        rgFixture1.rg.agregarsinonimo("Casa", "hogar");
        Assert.assertEquals("No Detecto Agregado de Sinonimo Repetido", "Sinonimo Repetido",  ((MockOptionPane) rgFixture1.rg.getOptionPane()).getMessage());
    }
    
    @Test
    public void testAgregarsinonimo3() {
        rgFixture1.rg.setOptionPane(new MockOptionPane());
        rgFixture1.rg.agregarsinonimo("Casa","Rancho");
        Assert.assertEquals("No Detecto Agregado Valido", "No Excepcion",  ((MockOptionPane) rgFixture1.rg.getOptionPane()).getMessage());
    }
    
    /**
     * @see Reglas_de_negocio#eliminarsinonimo(String,String)
     */
    @Test
    public void testEliminarsinonimo1() {
        rgFixture1.rg.setOptionPane(new MockOptionPane());
        rgFixture1.rg.eliminarsinonimo(null, null);
        System.out.println(((MockOptionPane) rgFixture1.rg.getOptionPane()).getMessage());
        Assert.assertEquals("No Detecto Eliminacion de Sinonimo Invalido", "Sinonimo Invalido",  ((MockOptionPane) rgFixture1.rg.getOptionPane()).getMessage()); 
    }
    /**
     * @see Reglas_de_negocio#eliminarsinonimo(String,String)
     */
    @Test
    public void testEliminarsinonimo2() {
        rgFixture1.rg.setOptionPane(new MockOptionPane());
        rgFixture1.rg.eliminarsinonimo("Casa", "rancho");
        Assert.assertEquals("No Detecto Eliminacion de Sinonimo Inexistente", "Sinonimo Inexistente",  ((MockOptionPane) rgFixture1.rg.getOptionPane()).getMessage());
    }

    /**
     * @see Reglas_de_negocio#eliminarsinonimo(String,String)
     */
    @Test
    public void testEliminarsinonimo3() {
        rgFixture1.rg.setOptionPane(new MockOptionPane());
        rgFixture1.rg.eliminarsinonimo("Casa", "hogar");
        Assert.assertEquals("No Detecto Eliminacion Valida", "No Excepcion",  ((MockOptionPane) rgFixture1.rg.getOptionPane()).getMessage());
    }

    /**
     * @see Reglas_de_negocio#leosinonimo(String)
     */
    @Test
    public void testLeosinonimo1() {
        rgFixture1.rg.setOptionPane(new MockOptionPane());
        rgFixture1.rg.leosinonimo("1Casa");
        Assert.assertEquals("No Detecto Busqueda Infructuosa", "Busqueda Infructuosa",  ((MockOptionPane) rgFixture1.rg.getOptionPane()).getMessage());
    }
    
    /**
     * @see Reglas_de_negocio#leosinonimo(String)
     */
    @Test
    public void testLeosinonimo2() {
        rgFixture1.rg.setOptionPane(new MockOptionPane());
        Boolean prueba=rgFixture1.rg.leosinonimo("perro").getRowCount()==1;
        Assert.assertTrue("No Detecto busqueda exitosa ", prueba);
    }
    
}
