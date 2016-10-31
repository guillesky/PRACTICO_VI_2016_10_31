package sinonimos;


public class Sinonimo
{

    private String Palabra_clave;
    private String Sinonimo_clave;

    public Sinonimo()
    {
        super();
    }


    public Sinonimo(String Palabra_clave, String Sinonimo_clave)
    {
        this.Palabra_clave = Palabra_clave;
        this.Sinonimo_clave = Sinonimo_clave;
    }


    public void setPalabra_clave(String Palabra_clave)
    {
        this.Palabra_clave = Palabra_clave;
    }

    public String getPalabra_clave()
    {
        return Palabra_clave;
    }

    public void setSinonimo_clave(String Sinonimo_clave)
    {
        this.Sinonimo_clave = Sinonimo_clave;
    }

    public String getSinonimo_clave()
    {
        return Sinonimo_clave;
    }


    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof Sinonimo))
        {
            return false;
        }
        final Sinonimo other = (Sinonimo) object;
        if (!(Palabra_clave == null ? other.Palabra_clave == null : Palabra_clave.equals(other.Palabra_clave)))
        {
            return false;
        }
        if (!(Sinonimo_clave == null ? other.Sinonimo_clave == null : Sinonimo_clave.equals(other.Sinonimo_clave)))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + ((Palabra_clave == null) ? 0 : Palabra_clave.hashCode());
        result = PRIME * result + ((Sinonimo_clave == null) ? 0 : Sinonimo_clave.hashCode());
        return result;
    }

}
