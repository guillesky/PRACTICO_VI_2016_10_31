package sinonimos;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Persistencia
{

   


    public static void persistir(Diccionario dic) throws FileNotFoundException
    {
        FileOutputStream os;
       
            os = new FileOutputStream("sinonimos.xml");
            XMLEncoder encoder = new XMLEncoder(os);
            encoder.writeObject(dic);
            encoder.close();
     
    }

    public static Diccionario despersitir() throws FileNotFoundException
    {
        Diccionario dic;
        FileInputStream os;
       
            os = new FileInputStream("sinonimos.xml");
            XMLDecoder decoder = new XMLDecoder(os);
            dic = (Diccionario) decoder.readObject();
            decoder.close();
            return dic;
       
    }

}
