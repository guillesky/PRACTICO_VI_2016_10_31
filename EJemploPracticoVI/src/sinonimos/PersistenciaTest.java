package sinonimos;
/*====================================================================================
 * La prueba de persistencia debe demostrar :
 * Se puede crear un Diccionario Vacio
 * Se pueden agregar Sinonimos y que estos persistan al momento de ser agregados
 * Se puedan eliminar Sinonimos y que estos persistan al momento de ser eliminados
 * ======================================================================================
 */

import java.io.File;

import java.io.FileNotFoundException;

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
    Diccionario dic;
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
                dic=new Diccionario();
        File archivo = new File("sinonimos.xml");
        if (archivo.exists())archivo.delete(); 
                    
    }

    @After
    public void tearDown() throws Exception
    {

    }

  

    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter(PersistenciaTest.class);
    }

   

    @Test
    public void testCrearArchivo()
    {
        try
        {
            Persistencia.persistir(dic);
            File archivo = new File("sinonimos.xml");
            Assert.assertTrue("Debería existir el archivo sinonimos.xml",archivo.exists());
                
        } catch (FileNotFoundException e)
        {
            Assert.fail("No debería lanzar excepcion: "+e.getMessage());
        }
    }

    @Test
    public void testDiccionarioVacioArchivo()
    {
        try
        {
            Persistencia.persistir(dic);
            Diccionario diccionario2=Persistencia.despersitir();
           
            Assert.assertEquals("Los diccionarios deberían ser vacíos", this.dic, diccionario2);
               
        } catch (FileNotFoundException e)
        {
            Assert.fail("No debería lanzar excepcion: "+e.getMessage());
        }

    }
    
    
    @Test
    public void testDiccionarioConSinonimos()
    {
        try
        {
           this.llenaDiccionario(dic);
            Persistencia.persistir(dic);
            Diccionario diccionario2=Persistencia.despersitir();
            
            Assert.assertEquals("Los diccionarios deberían tener cuatro sinónimos", this.dic, diccionario2);
                
        } catch (FileNotFoundException e)
        {
            Assert.fail("No debería lanzar excepcion: "+e.getMessage());
        }

    }
    
        
    @Test
    public void testDespersitirSinArchivo()
    {
        try
        {
            dic = Persistencia.despersitir();
            Assert.fail("Debría haber lanzado una excepcion de tipo FilaNotFound");
        } catch (FileNotFoundException e)
        {
            
        }
        
    
    }
    private void llenaDiccionario(Diccionario diccionario)
    {
        try
        {
            diccionario.agregar_sinonimo(new Sinonimo("casa", "hogar"));
            diccionario.agregar_sinonimo(new Sinonimo("casa", "vivienda"));
            diccionario.agregar_sinonimo(new Sinonimo("automovil", "coche"));
            diccionario.agregar_sinonimo(new Sinonimo("automovil", "carro"));
            
        } catch (Exception e)
        {
            Assert.fail("no debería lanzar excepcion");
        }


    }
}
