package sinonimos;

import java.awt.Component;

/* Esta interface nos permite utilizar el jOptionPane en la clase reglas_de_negocios y a[un asi
 * poder construir un caso de prueba automatico.
 * Si colocamos en reglas_de_negocios el jOptionPane directamente, este nos obligara a interactuar
 * para contestar el mensaje, impidiendo la prueba automatica.
 * Incluir esta interface obliga a adecuar el programa a probar de forma tal que en produccion uso
 * la version original o de defecto y para la prueba usemos la MockOPtionPane, que es una clase derivada
 * de esta interfase que maquetiza la a jOPtionPane pero nos libera de la interactuacion */


public interface OptionPane
{
    int userConfirmation(Component component, Object message, String title, int optionType);

    void showMessageDialog(Component parentComponent, Object message);

}
