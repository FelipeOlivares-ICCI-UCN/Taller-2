import java.util.ArrayList;
import java.util.List;

public class PC {
    static List<CapturedPokemon> PCPokemons = new ArrayList<>();

    public List<CapturedPokemon> getTrainerTeam()
    {
        int i = 1;
        List<CapturedPokemon> combatTeam = new ArrayList<>();

        for (CapturedPokemon pokemon: PCPokemons)
        {
            if (i > 6)
            {
                return combatTeam;
            }
            combatTeam.add(pokemon);
            i++;


        }

        return null;

    }

    public boolean isPCEmpty()
    {
        return PCPokemons.isEmpty();
    }



}
