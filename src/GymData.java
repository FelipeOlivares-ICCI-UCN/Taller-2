import java.util.ArrayList;
import java.util.List;

public class GymData {
    int gymNumber;
    String leaderName;
    boolean wasDefeated;

    String[] gymPokemonNames;



    public GymData(int gymNumber, String leaderName, boolean wasDefeated, String[] gymPokemonNames)
    {
        this.gymNumber = gymNumber;
        this.leaderName = leaderName;
        this.wasDefeated = wasDefeated;


        this.gymPokemonNames = gymPokemonNames;

    }




}
