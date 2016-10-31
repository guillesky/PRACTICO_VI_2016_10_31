
package sinonimos;


import java.awt.AWTException;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Robot;

import javax.swing.JFrame;

import javax.xml.parsers.ParserConfigurationException;

import sinonimos.MockOptionPane;

public class DGTestInstance {
    
    private static JFrame JFUI = null;
    private static Integer retraso; 
    private static DiccionarioGUI DG = null;
    private static GraphicsEnvironment environment;
    private static GraphicsDevice Pantalla;
    private static Robot robot;
    private static Point punto_Agregar;
    private static Point punto_Eliminar;
    private static Point punto_Buscar;
    
    public DGTestInstance() {
        super();
    }

    public static Integer getRetraso() {
        return retraso;
    }

    public static DiccionarioGUI getDG() {
        return DG;
    }

    public static Robot getRobot() {
        return robot;
    }

    public static Point getPunto_Agregar() {
        return punto_Agregar;
    }

    public static Point getPunto_Eliminar() {
        return punto_Eliminar;
    }

    public static Point getPunto_Buscar() {
        return punto_Buscar;
    }

    public static JFrame getInstancia() throws ParserConfigurationException 
      {
          
          if (JFUI == null) 
              {
                  JFUI = new JFrame();
                  JFUI.setLocation(100,100);
                  DG = new DiccionarioGUI(JFUI,false);
                  DG.setOptionPane(new MockOptionPane());
                  environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
                  Pantalla = environment.getDefaultScreenDevice();
                  try 
                  {
                      robot = new Robot(Pantalla);
                  } 
                  catch (AWTException e) 
                  {
                  }
                  DG.setVisible(true);
                  retraso=1200;
                  int x_Agregar= DG.getBoton_Agregar().getLocationOnScreen().x + DG.getBoton_Agregar().getWidth()/2;
                  int y_Agregar= DG.getBoton_Agregar().getLocationOnScreen().y + DG.getBoton_Agregar().getHeight()/2;
                  int x_Eliminar= DG.getBoton_Eliminar().getLocationOnScreen().x + DG.getBoton_Eliminar().getWidth()/2;
                  int y_Eliminar= DG.getBoton_Eliminar().getLocationOnScreen().y + DG.getBoton_Eliminar().getHeight()/2;
                  int x_Buscar= DG.getBoton_Buscar().getLocationOnScreen().x + DG.getBoton_Buscar().getWidth()/2;
                  int y_Buscar= DG.getBoton_Buscar().getLocationOnScreen().y + DG.getBoton_Buscar().getHeight()/2;
                  punto_Agregar = new Point(x_Agregar, y_Agregar);
                  punto_Eliminar = new Point(x_Eliminar,y_Eliminar);
                  punto_Buscar = new Point(x_Buscar, y_Buscar);
                  
              }
          return JFUI;
      }
}
