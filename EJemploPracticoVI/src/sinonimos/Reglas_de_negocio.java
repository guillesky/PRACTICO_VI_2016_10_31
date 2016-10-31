package sinonimos;

import java.util.Iterator;

import javax.swing.table.DefaultTableModel;

public class Reglas_de_negocio
{
    private Persistencia persis = Persistencia.getInstancia();
    private Diccionario diccsin = persis.despersitir();
    private DefaultTableModel ModeloSinonimos = new DefaultTableModel();
    private OptionPane optionPane = new DefaultOptionPane();

    public Reglas_de_negocio()
    {
        super();
    }

    public void setOptionPane(OptionPane o)
    {
        this.optionPane = o;
    }

    public OptionPane getOptionPane()
    {
        return this.optionPane;
    }

    public Diccionario getDiccionario()
    {
        return diccsin;
    }

    public void agregarsinonimo(String Clave, String textSinonimo)
    {
        Sinonimo sin = new Sinonimo(Clave, textSinonimo);
        try
        {
            diccsin.agregar_sinonimo(sin);
            persis.persistir(diccsin);
            optionPane.showMessageDialog(null, "No Excepcion");
        }
        catch (Exception e)
        {
            optionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void eliminarsinonimo(String Clave, String textSinonimo)
    {
        Sinonimo sin = new Sinonimo(Clave, textSinonimo);
        try
        {
            diccsin.eliminar_sinonimo(sin);
            persis.persistir(diccsin);
            optionPane.showMessageDialog(null, "No Excepcion");
        }
        catch (Exception e)
        {
            optionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public DefaultTableModel leosinonimo(String Clave)
    {
        ModeloSinonimos.addColumn("Palabra");
        ModeloSinonimos.addColumn("Sinonimos");
        try
        {
            Iterator it = diccsin.busqueda_sinonimo(Clave).iterator();
            while (it.hasNext())
            {
                Object[] renglon = new Object[2];
                Sinonimo sinu = (Sinonimo) it.next();
                renglon[0] = sinu.getPalabra_clave();
                renglon[1] = sinu.getSinonimo_clave();
                ModeloSinonimos.addRow(renglon);
            }
            return ModeloSinonimos;
        }
        catch (Exception e)
        {
            optionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }


}
