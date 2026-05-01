public class Pokemon {
    protected String name;
    protected String type;
    protected int totalStats;

    public Pokemon(String name, String type, int totalStats)
    {
        this.name = name;
        this.type = type;
        this.totalStats = totalStats;
    }

    public String getName()
    {
        return this.name;
    }

}
