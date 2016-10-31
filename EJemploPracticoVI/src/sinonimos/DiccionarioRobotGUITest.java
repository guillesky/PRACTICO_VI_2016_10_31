package sinonimos;

/*
 * Clase de Prueba del GUI
 * Tenemos tres campos de entrada (Texto_Clave, Texto_Sinonimo, Texto_Busqueda
 * y los Botones Boton_Agregar, Boton_Buscar y Boton_Eliminar
 * Debemos validar que al momento de Agregar y Eliminar, el campo Texto_Busqueda
 * este vacio y al momento de Buscar los campos Texto_Clave y Texto_Sinonimo esten
 * vacios. Tambien que al momento de agregar y eliminar los Campos Texto_Clave
 * y Texto_Sinonimo no esten vacios y que Texto_Busqueda tenga contenido cuando
 * Buscamos.
 * ----------------------------------------------------------------------
 * Las operaciones de agregado, eliminacion o Busqueda se las prueba en las reglas
 * de negocio, por lo que se dan por validadas, entonces solo se prueban los caminos
 * de la GUI explicitados anteriormente.
 * Adicionalmente se corrobora que si carguen efectivamente los datos de la busqueda
 *
 * En resumen habra los siguientes casos de prueba:
 *
 * si aprieto Agregar, Texto_Busqueda debe estar vacio, en tanto que Texto_Clave y Texto_Sinonimo deben tener contenido
 * si aprieto Eliminar Texto_Busqueda debe estar vacio, en tanto que Texto_Clave y Texto_Sinonimo deben tener contenido
 * si aprieto Buscar el Texto_Busqueda debe contener algo, en tanto que texto_Clave y Texto_Sinonimo deben estar vacios
 *    
 */

import java.awt.AWTException;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import javax.swing.JFrame;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import junit.framework.JUnit4TestAdapter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import org.w3c.dom.NodeList;


public class DiccionarioRobotGUITest {
    
   
   
    private static JFrame JF = null;
    
        
    public DiccionarioRobotGUITest() 
    {
        try {
            JF = DGTestInstance.getInstancia();
            }
        catch (ParserConfigurationException e) 
        {
        }
    }
    
    

    public static void main(String[] args) {
        String[] args2 = { DiccionarioRobotGUITest.class.getName() };
        JUnitCore.main(args2);
    }

    @Before
    public void setUp() throws Exception 
    {
        DGTestInstance.getDG().regla_negocio.getDiccionario().getListaSinonimos().add(new Sinonimo("Casa","vivienda"));
        DGTestInstance.getDG().regla_negocio.getDiccionario().getListaSinonimos().add(new Sinonimo("Casa","hogar"));
        DGTestInstance.getDG().regla_negocio.getDiccionario().getListaSinonimos().add(new Sinonimo("perro","can"));
        DGTestInstance.getDG().regla_negocio.getDiccionario().getListaSinonimos().add(new Sinonimo("calle","rua"));
    }

    @After
    public void tearDown() throws Exception {
        DGTestInstance.getDG().regla_negocio.getDiccionario().getListaSinonimos().clear(); 
        }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        
    }

    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(DiccionarioRobotGUITest.class);
    }
    
    public void poneparametros(String inClave, String inSinonimo, String inBusqueda) {
        DGTestInstance.getDG().getTexto_Clave().setText(inClave);
        DGTestInstance.getDG().getTexto_Sinonimo().setText(inSinonimo);
        DGTestInstance.getDG().getTexto_Busqueda().setText(inBusqueda);
    }
    
    public void accionRobot(Point coordenadas)   {
        DGTestInstance.getRobot().delay(DGTestInstance.getRetraso());
        DGTestInstance.getRobot().mouseMove(coordenadas.x,coordenadas.y);
        DGTestInstance.getRobot().mousePress(InputEvent.BUTTON1_DOWN_MASK);
        DGTestInstance.getRobot().delay(DGTestInstance.getRetraso());
        DGTestInstance.getRobot().mouseRelease(InputEvent.BUTTON1_MASK);
        DGTestInstance.getRobot().delay(DGTestInstance.getRetraso());
    }
    
    @Test
    public void testAgregarBusqueda_No_Vacio() 
    {
            poneparametros("","","No Vacio");
            accionRobot(DGTestInstance.getPunto_Agregar());
            Assert.assertEquals("Agregar con Datos Inconsistentes", "Agregar con datos inconsistentes",  ((MockOptionPane) DGTestInstance.getDG().getOptionPane()).getMessage());
    }
    
    @Test
    public void testAgregarClave_Vacio() 
    {
            poneparametros("","No Vacio","");
            accionRobot(DGTestInstance.getPunto_Agregar());
            Assert.assertEquals("Agregar con Datos Inconsistentes", "Agregar con datos inconsistentes",  ((MockOptionPane) DGTestInstance.getDG().getOptionPane()).getMessage());
    }
    
    @Test
    public void testAgregarSinonimo_Vacio() 
    {
            poneparametros("No Vacio","","");
            accionRobot(DGTestInstance.getPunto_Agregar());
            Assert.assertEquals("Agregar con Datos Inconsistentes", "Agregar con datos inconsistentes",  ((MockOptionPane) DGTestInstance.getDG().getOptionPane()).getMessage());
      }
            
    @Test
    public void testEliminarBusqueda_No_Vacio() 
    {
            poneparametros("","","No Vacio");
            accionRobot(DGTestInstance.getPunto_Eliminar());
            Assert.assertEquals("Eliminar con Datos Inconsistentes", "Eliminar con datos inconsistentes",  ((MockOptionPane) DGTestInstance.getDG().getOptionPane()).getMessage());
     }
    
    @Test
    public void testEliminarClave_Vacio() 
    { 
            poneparametros("","No Vacio","");
            accionRobot(DGTestInstance.getPunto_Eliminar());
            Assert.assertEquals("Eliminar con Datos Inconsistentes", "Eliminar con datos inconsistentes",  ((MockOptionPane) DGTestInstance.getDG().getOptionPane()).getMessage());
    }
    
  
    @Test
    public void testEliminarSinonimo_Vacio() 
    {
            poneparametros("No Vacio","","");
            accionRobot(DGTestInstance.getPunto_Eliminar());
            Assert.assertEquals("Eliminar con Datos Inconsistentes", "Eliminar con datos inconsistentes",  ((MockOptionPane) DGTestInstance.getDG().getOptionPane()).getMessage());
    }

    @Test
    public void testBuscarInconsistente() 
    {
            poneparametros("","","");
            accionRobot(DGTestInstance.getPunto_Buscar());
            Assert.assertEquals("Busqueda con datos inconsistentes", "Busqueda con datos inconsistentes",  ((MockOptionPane) DGTestInstance.getDG().getOptionPane()).getMessage());
    }
    
    @Test
    public void testBuscarClave_no_Vacio() 
    {
            poneparametros("No Vacio","","Casa");
            accionRobot(DGTestInstance.getPunto_Buscar());
            Assert.assertEquals("Busqueda Clave No Vacia", "Busqueda con datos inconsistentes",  ((MockOptionPane) DGTestInstance.getDG().getOptionPane()).getMessage());
    }
    
    @Test
    public void testBuscarSinonimo_no_Vacio() 
    {
            poneparametros("","No Vacio","Casa");
            accionRobot(DGTestInstance.getPunto_Buscar());
            Assert.assertEquals("Busqueda Sinonimo no Vacio", "Busqueda con datos inconsistentes",  ((MockOptionPane) DGTestInstance.getDG().getOptionPane()).getMessage());      
    }
}
