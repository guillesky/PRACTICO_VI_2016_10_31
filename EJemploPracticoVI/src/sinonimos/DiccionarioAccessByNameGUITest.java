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
 */

import java.awt.AWTException;
import java.awt.Component;
import java.awt.Container;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

import javax.swing.JFrame;

import junit.framework.JUnit4TestAdapter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import java.awt.event.*;
import java.awt.image.*;

import java.util.HashMap;
import java.util.Iterator;

import java.util.Map;

import javax.swing.*;


public class DiccionarioAccessByNameGUITest
{

    JFrame JF = new JFrame();
    DiccionarioGUI DG = new DiccionarioGUI(JF, false);
    GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice Pantalla = environment.getDefaultScreenDevice();
    Map DGComponentes = null;

    public DiccionarioAccessByNameGUITest()
    {
        DG.setVisible(true);
        DGComponentes = TraerTodoslosComponentes(DG, DGComponentes);
    }

    public static Map TraerTodoslosComponentes(Container padre, Map MapaDeComponentes)
    {
        Map mapa;
        Component[] Componentes;

        if (MapaDeComponentes == null)
            mapa = new HashMap();
        else
            mapa = MapaDeComponentes;
        Componentes = padre.getComponents();
        mapa.put(padre.getName(), padre);
        for (int i = 0; i < Componentes.length; i++)
        {
            mapa.put(Componentes[i].getName(), Componentes[i]);
            if (Componentes[i] instanceof Container)
            {
                mapa = TraerTodoslosComponentes((Container) Componentes[i], mapa);
            }
        }
        return mapa;
    }

    public Component traerComponentePorNombre(String Nombre)
    {
        if (DGComponentes.get(Nombre) instanceof Component)
        {
            return (Component) DGComponentes.get(Nombre);
        }
        else
            return null;
    }

    public static void main(String[] args)
    {
        String[] args2 = { DiccionarioAccessByNameGUITest.class.getName() };
        JUnitCore.main(args2);
    }

    @Before
    public void setUp() throws Exception
    {
        DG.regla_negocio.getDiccionario().getListaSinonimos().add(new Sinonimo("Casa", "vivienda"));
        DG.regla_negocio.getDiccionario().getListaSinonimos().add(new Sinonimo("Casa", "hogar"));
        DG.regla_negocio.getDiccionario().getListaSinonimos().add(new Sinonimo("perro", "can"));
        DG.regla_negocio.getDiccionario().getListaSinonimos().add(new Sinonimo("calle", "rua"));
    }

    @After
    public void tearDown() throws Exception
    {
        DG.regla_negocio.getDiccionario().getListaSinonimos().clear();
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {

    }

    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter(DiccionarioAccessByNameGUITest.class);
    }

    @Test
    public void testAgregarBusqueda_No_Vacio()
    {
        DG.setOptionPane(new MockOptionPane());
        ((JTextField) traerComponentePorNombre("Texto_Clave")).setText("");
        ((JTextField) traerComponentePorNombre("Texto_Sinonimo")).setText("");
        ((JTextField) traerComponentePorNombre("Texto_Busqueda")).setText("No Vacio");
        ((JButton) traerComponentePorNombre("Boton_Agregar")).doClick();
        Assert.assertEquals("Agregar con Datos Inconsistentes", "Agregar con datos inconsistentes",
                            ((MockOptionPane) DG.getOptionPane()).getMessage());
    }

    @Test
    public void testAgregarClave_Vacio()
    {
        DG.setOptionPane(new MockOptionPane());
        ((JTextField) traerComponentePorNombre("Texto_Clave")).setText("");
        ((JTextField) traerComponentePorNombre("Texto_Sinonimo")).setText("No Vacio");
        ((JTextField) traerComponentePorNombre("Texto_Busqueda")).setText("");
        ((JButton) traerComponentePorNombre("Boton_Agregar")).doClick();
        Assert.assertEquals("Agregar con Datos Inconsistentes", "Agregar con datos inconsistentes",
                            ((MockOptionPane) DG.getOptionPane()).getMessage());
    }

    @Test
    public void testAgregarSinonimo_Vacio()
    {
        DG.setOptionPane(new MockOptionPane());
        ((JTextField) traerComponentePorNombre("Texto_Clave")).setText("No Vacio");
        ((JTextField) traerComponentePorNombre("Texto_Sinonimo")).setText("");
        ((JTextField) traerComponentePorNombre("Texto_Busqueda")).setText("");
        ((JButton) traerComponentePorNombre("Boton_Agregar")).doClick();
        Assert.assertEquals("Agregar con Datos Inconsistentes", "Agregar con datos inconsistentes",
                            ((MockOptionPane) DG.getOptionPane()).getMessage());
    }

    @Test
    public void testEliminarBusqueda_No_Vacio()
    {
        DG.setOptionPane(new MockOptionPane());
        ((JTextField) traerComponentePorNombre("Texto_Clave")).setText("");
        ((JTextField) traerComponentePorNombre("Texto_Sinonimo")).setText("");
        ((JTextField) traerComponentePorNombre("Texto_Busqueda")).setText("No Vacio");
        ((JButton) traerComponentePorNombre("Boton_Eliminar")).doClick();
        Assert.assertEquals("Eliminar con Datos Inconsistentes", "Eliminar con datos inconsistentes",
                            ((MockOptionPane) DG.getOptionPane()).getMessage());

    }

    @Test
    public void testEliminarClave_Vacio()
    {
        DG.setOptionPane(new MockOptionPane());
        ((JTextField) traerComponentePorNombre("Texto_Clave")).setText("");
        ((JTextField) traerComponentePorNombre("Texto_Sinonimo")).setText("No Vacio");
        ((JTextField) traerComponentePorNombre("Texto_Busqueda")).setText("");
        ((JButton) traerComponentePorNombre("Boton_Eliminar")).doClick();
        Assert.assertEquals("Eliminar con Datos Inconsistentes", "Eliminar con datos inconsistentes",
                            ((MockOptionPane) DG.getOptionPane()).getMessage());
    }

    @Test
    public void testEliminarSinonimo_Vacio()
    {
        DG.setOptionPane(new MockOptionPane());
        ((JTextField) traerComponentePorNombre("Texto_Clave")).setText("No Vacio");
        ((JTextField) traerComponentePorNombre("Texto_Sinonimo")).setText("");
        ((JTextField) traerComponentePorNombre("Texto_Busqueda")).setText("");
        ((JButton) traerComponentePorNombre("Boton_Eliminar")).doClick();
        Assert.assertEquals("Eliminar con Datos Inconsistentes", "Eliminar con datos inconsistentes",
                            ((MockOptionPane) DG.getOptionPane()).getMessage());
    }

    @Test
    public void testBuscarInconsistente()
    {
        DG.setOptionPane(new MockOptionPane());
        ((JTextField) traerComponentePorNombre("Texto_Clave")).setText("");
        ((JTextField) traerComponentePorNombre("Texto_Sinonimo")).setText("");
        ((JTextField) traerComponentePorNombre("Texto_Busqueda")).setText("");
        ((JButton) traerComponentePorNombre("Boton_Buscar")).doClick();
        Assert.assertEquals("Busqueda con datos inconsistentes", "Busqueda con datos inconsistentes",
                            ((MockOptionPane) DG.getOptionPane()).getMessage());
    }

    @Test
    public void testBuscarClave_no_Vacio()
    {
        DG.setOptionPane(new MockOptionPane());
        ((JTextField) traerComponentePorNombre("Texto_Clave")).setText("No Vacio");
        ((JTextField) traerComponentePorNombre("Texto_Sinonimo")).setText("");
        ((JTextField) traerComponentePorNombre("Texto_Busqueda")).setText("Casa");
        ((JButton) traerComponentePorNombre("Boton_Buscar")).doClick();
        Assert.assertEquals("Busqueda con datos inconsistentes", "Busqueda con datos inconsistentes",
                            ((MockOptionPane) DG.getOptionPane()).getMessage());
    }

    @Test
    public void testBuscarSinonimo_no_Vacio()
    {
        DG.setOptionPane(new MockOptionPane());
        ((JTextField) traerComponentePorNombre("Texto_Clave")).setText("");
        ((JTextField) traerComponentePorNombre("Texto_Sinonimo")).setText("Np Vacio");
        ((JTextField) traerComponentePorNombre("Texto_Busqueda")).setText("Casa");
        ((JButton) traerComponentePorNombre("Boton_Buscar")).doClick();
        Assert.assertEquals("Busqueda con datos inconsistentes", "Busqueda con datos inconsistentes",
                            ((MockOptionPane) DG.getOptionPane()).getMessage());
    }

}
