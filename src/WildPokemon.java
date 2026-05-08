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

    public CapturedPokemon capturePokemon()
    {
        return new CapturedPokemon(super.name, super.type, super.totalStats, "Vivo");
    }

    @Override
    public String toString() {
        return super.name + "| "+ super.type + "| "+ super.totalStats + "| "+ this.apparitionChance;
    }
}
