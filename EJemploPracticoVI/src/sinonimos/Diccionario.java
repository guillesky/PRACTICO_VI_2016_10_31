package sinonimos;

import java.util.ArrayList;

public class Diccionario
{

    private ArrayList<Sinonimo> ListaSinonimos = new ArrayList();

    public Diccionario()
    {
        super();
    }


    public void agregar_sinonimo(Sinonimo sin) throws Exception
    {
        if ((sin.getPalabra_clave() == null) || (sin.getSinonimo_clave() == null))
        {
            throw new Exception("Sinonimo Invalido");
        }
        else
        {
            if (ListaSinonimos.contains(sin))
            {
                throw new Exception("Sinonimo Repetido");
            }
            else
                ListaSinonimos.add(sin);
        }
    }

    public void eliminar_sinonimo(Sinonimo sin) throws Exception
    {
        if (ListaSinonimos.isEmpty())
        {
            throw new Exception("Diccionario Vacio");
        }
        else
        {
            if ((sin.getPalabra_clave() == null) || (sin.getSinonimo_clave() == null))
            {
                throw new Exception("Sinonimo Invalido");
            }
            else
            {
                if (!ListaSinonimos.contains(sin))
                {
                    throw new Exception("Sinonimo Inexistente");
                }
                else
                    ListaSinonimos.remove(sin);
            }
        }
    }

    public ArrayList<Sinonimo> busqueda_sinonimo(String Palabra) throws Exception
    {
        ArrayList<Sinonimo> salida = new ArrayList();
        if (ListaSinonimos.isEmpty())
        {
            throw new Exception("Diccionario Vacio");
        }
        else
        {
            ListaSinonimos.forEach(sinonimo -> { if (sinonimo.getPalabra_clave().equals(Palabra))
                {
                    salida.add(sinonimo);
                } });
            if (salida.isEmpty())
            {
                throw new Exception("Busqueda Infructuosa");
            }
            else
                return salida;
        }
    }


    public void setListaSinonimos(ArrayList<Sinonimo> ListaSinonimos)
    {
        this.ListaSinonimos = ListaSinonimos;
    }

    public ArrayList<Sinonimo> getListaSinonimos()
    {
        return ListaSinonimos;
    }
}
