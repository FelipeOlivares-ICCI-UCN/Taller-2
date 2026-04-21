public class Pokemon {
    private String name;
    private int totalStats;
    private String type;
    private boolean isKnocked;

    public Pokemon(String name, int totalStats, String type)
    {
        this.name = name;
        this.totalStats = totalStats;
        this.type = type;
    }

    public String getState()
    {
        if (!isKnocked)
        {
            return "Vivo";
        }

        else
        {
            return "Debilitado";
        }


    }

    public void setState(String state)
    {
        if (state.equals("Vivo"))
        {
            this.isKnocked = false;
        }

        else if (state.equals("Debilitado"))
        {
            this.isKnocked = true;
        }

        else
        {
            System.out.println("Estado de pokemon invalido");
        }


    }

    public String getName()
    {
        return this.name;
    }


    @Override
    public String toString() {
        return this.name + "|" + this.type + "|Stats totales: " +  this.totalStats ;
    }
}
