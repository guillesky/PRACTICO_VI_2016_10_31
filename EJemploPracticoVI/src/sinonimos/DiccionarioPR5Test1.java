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
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import java.util.Iterator;

public class DiccionarioPR5Test1 {
   
    DiccionarioTestFixture1 fixture1 = new DiccionarioTestFixture1();
        
    public DiccionarioPR5Test1() {
    }

    
    /**
     * Inicio Fixture
     */

    @Before
    public void setUp()
    {
        fixture1.setUp();
    }

    @After
    public void tearDown() 
    {
        fixture1.tearDown();
    }
  
  /**
   * Fin Fixture 
   **/
    
    /**
      * agregar un sinonimo nulo con lista llena
    */
  
    @Test
    public void testAgregar_sinonimo1() {
       try
          {
            Sinonimo sin = new Sinonimo(null,null);
            fixture1.dicctest.agregar_sinonimo(sin);
            fail("agregar sinonimo nulo no dispara excepcion.");
          }
          catch(Exception e )
          {
/*          Nota : La excepcion debe ser la correspondiente al mensaje */
            final String msg = "Sinonimo Invalido";
            System.out.println(e.getMessage());
            assertEquals("No genera la excepcion de Sinonimo Invalido", msg, e.getMessage());
          }
        
     }
     
     /**
      * sinonimo valido pero repetido
      */
       
    @Test
    public void testAgregar_sinonimo2() {
        try
           {
            Sinonimo sin = new Sinonimo("Casa","hogar");
            fixture1.dicctest.agregar_sinonimo(sin);
            fail("agregar sinonimo repetido no dispara excepcion.");
            }
        catch( final Exception e )
            {
/*          Nota : La excepcion debe ser la correspondiente al mensaje */           
            final String msg = "Sinonimo Repetido";
            assertEquals("No genera la excepcion de Sinonimo Repetido", msg, e.getMessage());
            }
    }

    
     /**
      * sinonimo valido que no esta en la lista
      */
     
    @Test
    public void testAgregar_sinonimo3() {
        try
           {  
            Sinonimo sin = new Sinonimo("Casa","Rancho");
            fixture1.dicctest.agregar_sinonimo(sin);
            assertTrue("Error al agregar un Sinonimo",fixture1.dicctest.getListaSinonimos().size()==5);
            }
        catch( final Exception e )
            {
            fail("Esta prueba de agregar_sinonimo, no debe disparar una excepcion");
            }
    }

     /**
     * Eliminar Sinonimo Invalido
     */
   
    @Test
    public void testEliminar_sinonimo1() {
        try
           { 
            Sinonimo sin = new Sinonimo(null,null);
            fixture1.dicctest.eliminar_sinonimo(sin);
            fail("eliminar sinonimo invalido no dispara excepcion.");
        }
        catch( final Exception e )
        {
/*          Nota : La excepcion debe ser la correspondiente al mensaje */           
            final String msg = "Sinonimo Invalido";
            assertEquals("No genera la excepcion de Sinonimo Invalido", msg, e.getMessage());
        }
    }
  
    
     /**
      * Sinonimo valido pero no esta en la lista
      */
     
     @Test
     public void testEliminar_sinonimo2() {
         try
            {  
             Sinonimo sin = new Sinonimo("Casa","rancho");
             fixture1.dicctest.eliminar_sinonimo(sin);
             fail("Eliminar sinonimo inexistente no dispara excepcion.");
         }
         catch( final Exception e )
         {
/*          Nota : La excepcion debe ser la correspondiente al mensaje */                        
            final String msg = "Sinonimo Inexistente";
            assertEquals("No Genera la excepcion de Sinonimo Inexistente",msg, e.getMessage());
         }
     }
  
     /**
      * Sinonimo Valido y esta en la lista
      */
     
     @Test
     public void testEliminar_sinonimo3() {
         try
            { 
             Sinonimo sin = new Sinonimo("Casa","hogar");
             fixture1.dicctest.eliminar_sinonimo(sin);
             assertFalse("Error al eliminar un Sinonimo", fixture1.dicctest.getListaSinonimos().contains(sin));
           }
         catch( final Exception e )
           {
             fail("Eliminar sinonimo valido y existente dispara excepcion.");
           }
     }
     
     
     /**
        * busqueda no arroja resultados
      */
     
     @Test
     public void testBusqueda_sinonimo2() 
     {   
         try
            {
             Iterator it = fixture1.dicctest.busqueda_sinonimo("rancho").iterator();
             fail("Busqueda sin resultados no dispara excepcion.");
            }
         catch( final Exception e )
            {
/*          Nota : La excepcion debe ser la correspondiente al mensaje */
            final String msg = "Busqueda Infructuosa";
            assertEquals("No genera excepcion de Busqueda Infructuosa",msg, e.getMessage()); 
            }
     }
     
     /**
        * busqueda arroja resultados
      */
     
     @Test
     public void testBusqueda_sinonimo3() 
     {       
         try
            {
             Iterator it = fixture1.dicctest.busqueda_sinonimo("Casa").iterator();
             boolean prueba=true;
             while (it.hasNext())
                {
                    if (!(((Sinonimo) it.next()).getPalabra_clave().equals("Casa")))
                    {
                        prueba=false;
                    }
                }       
            assertTrue("Error de Busqueda", prueba);
            }
         catch( final Exception e )
            {
            fail("Busqueda Exitosa no debe disparar una excepcion.");
            }
     }
     
    
 }
  

