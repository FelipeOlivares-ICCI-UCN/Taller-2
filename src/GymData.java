import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GymData {
    int gymNumber;
    String leaderName;
    boolean wasDefeated;

    String[] gymPokemonNames;


    public GymData(int gymNumber, String leaderName, boolean wasDefeated, String[] gymPokemonNames) {
        this.gymNumber = gymNumber;
        this.leaderName = leaderName;
        this.wasDefeated = wasDefeated;


        this.gymPokemonNames = gymPokemonNames;

    }

    public String getState() {
        if (!wasDefeated) {
            return "Sin derrotar";
        } else {
            return "Derrotado";
        }


    }


    @Override
    public String toString() {
        return gymNumber + ";" + leaderName + ";" + getState() + ";" + gymPokemonNames.length + ";" + String.join(";", gymPokemonNames);
    }
}