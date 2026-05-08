import java.util.ArrayList;
import java.util.List;

public class Gym {
    String name;
    int number;
    boolean wasDefeated;
    int teamSize;

    List<CapturedPokemon> gymTeam;

    public Gym(String name, int number, String state, int teamSize )
    {
        this.name = name;
        this.number = number;
        setState(state);

        this.teamSize = teamSize;
        gymTeam = new ArrayList<>(teamSize);

    }

    private void setState(String state)
    {
        if (state.equals("Sin derrotar"))
        {
            this.wasDefeated = false;
        }

        else if (state.equals("Derrotado"))
        {
            this.wasDefeated = true;
        }

        else
        {
            System.out.println("Estado invalido");
        }

    }


}
