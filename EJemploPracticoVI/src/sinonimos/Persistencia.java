package sinonimos;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Persistencia
{

    private static Persistencia instancia = null;

    private Persistencia()
    {
        super();
        FileOutputStream os;
        try
        {
            os = new FileOutputStream("sinonimos.xml");
            XMLEncoder encoder = new XMLEncoder(os);
            encoder.writeObject(new Diccionario());
            encoder.close();
        }
        catch (FileNotFoundException e)
        {
        }
    }

    public static Persistencia getInstancia()
    {
        if (instancia == null)
        {
            instancia = new Persistencia();
        }
        return instancia;
    }


    public void persistir(Diccionario dic)
    {
        FileOutputStream os;
        try
        {
            os = new FileOutputStream("sinonimos.xml");
            XMLEncoder encoder = new XMLEncoder(os);
            encoder.writeObject(dic);
            encoder.close();
        }
        catch (FileNotFoundException e)
        {
        }
    }

    public Diccionario despersitir()
    {
        Diccionario dic;
        FileInputStream os;
        try
        {
            os = new FileInputStream("sinonimos.xml");
            XMLDecoder decoder = new XMLDecoder(os);
            dic = (Diccionario) decoder.readObject();
            decoder.close();
            return dic;
        }
        catch (FileNotFoundException e)
        {
            return null;
        }
    }

}
