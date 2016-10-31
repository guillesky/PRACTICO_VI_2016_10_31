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
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;
   
import java.util.Iterator;

public class DiccionarioPR5Test2 {
    
        DiccionarioTestFixture2 fixture2 = new DiccionarioTestFixture2();
            
        public DiccionarioPR5Test2() {
        }

    /**
     * Inicio Fixture
     */

    @Before
    public void setUp()
    {
        fixture2.setUp();
    }

    @After
    public void tearDown() 
    {
        fixture2.tearDown();
    }
    
    /**
    * Fin Fixture
    **/
               
         /**
          * Lista vacia y sinonimo valido
          */
        
        @Test
        public void testAgregar_sinonimo4() {
            try
               { 
                Sinonimo sin = new Sinonimo("Casa","hogar");
                fixture2.dicctest.agregar_sinonimo(sin);
                assertTrue("Error al agregar un Sinonimo",fixture2.dicctest.getListaSinonimos().size()==1);
                }
            catch( final Exception e )
                {
                fail("Esta prueba de agregar_sinonimo, no debe disparar una excepcion");
                }
        }

        
        
         /**
          * lista vacia sinonimo invalido
          */
         
        @Test
        public void testAgregar_sinonimo5() {
            try
               { 
                Sinonimo sin = new Sinonimo(null,null);
                fixture2.dicctest.agregar_sinonimo(sin);
                fail("agregar sinonimo invalido no dispara excepcion.");
                }
            catch( final Exception e )
                {
    /*          Nota : La excepcion debe ser la correspondiente al mensaje */        
                final String msg = "Sinonimo Invalido";
                assertEquals("No genera la Excepcion de Sinonimo Invalido",msg, e.getMessage());
                }
        }

        
         /**
          * Lista vacia
          */
         
         @Test
         public void testEliminar_sinonimo4() {
             try
                { 
                    Sinonimo sin = new Sinonimo("Casa","hogar");
                    fixture2.dicctest.eliminar_sinonimo(sin);
                    fail("eliminar sinonimo de lista vacia no dispara excepcion.");
                }
             catch( final Exception e )
                {
    /*          Nota : La excepcion debe ser la correspondiente al mensaje */ 
                    final String msg = "Diccionario Vacio";
                    assertEquals("No genera la excepcion de Diccionario Vacio", msg, e.getMessage());
                }
         }   
      
       
        
        /**
           * busqueda en lista vacia
        */
       
        @Test
        public void testBusqueda_sinonimo1() 
        {
            
            try
                {
                Iterator it = fixture2.dicctest.busqueda_sinonimo("Casa").iterator();
                fail("Busqueda en lista vacia no dispara excepcion.");
                }
            catch( final Exception e )
                {
    /*          Nota : La excepcion debe ser la correspondiente al mensaje */ 
                final String msg = "Diccionario Vacio";
                assertEquals("No genera excepcion de Diccionario Vacio",msg, e.getMessage());
                }
        }
  

}
