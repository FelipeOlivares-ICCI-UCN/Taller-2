public class WildPokemon extends Pokemon {
    private float apparitionChance;

    public WildPokemon(String name, String type, int totalStats, float apparitionChance)
    {
        super(name, type, totalStats);
        this.apparitionChance = apparitionChance;
    }

    public float getApparitionChance()
    {
        return this.apparitionChance;
    }

}
