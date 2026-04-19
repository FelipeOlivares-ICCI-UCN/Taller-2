public class Pokedata {
    private String name;

    private String location;
    private float apparitionChance;

    private int healthPoints;
    private int attackPoints;
    private int defensePoints;
    private int specialAttackPoints;
    private int specialDefensePoints;
    private int speedPoints;

    private int totalStats;
    private String type;


    public Pokedata(String name, String location, float apparitionChance, String type)
    {
        this.name = name;
        this.location = location;
        this.apparitionChance = apparitionChance;
        this.type = type;

    }

    public void setStats(int HP, int AP, int DP, int sAP, int sDP, int SP)
    {
        this.healthPoints = HP;
        this.attackPoints = AP;
        this.defensePoints = DP;
        this.specialAttackPoints = sAP;
        this.specialDefensePoints = sDP;
        this.speedPoints = SP;

        this.totalStats = (HP + AP + DP
                + sAP + sDP
                + SP);

    }

    public String getName()
    {
        return this.name;
    }

    public int getTotalStats() {
        return totalStats;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return this.name + "|" + this.totalStats + "|" + this.type;
    }
}
