import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

    public void addCapturedPokemon(CapturedPokemon pk)
    {
        PCPokemons.add(pk);

    }

    public void saveData()
    {
        try( BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./data/Registros.txt", true)))
        {

            for (CapturedPokemon pk: PCPokemons)
            {
                bufferedWriter.newLine();
                bufferedWriter.write(pk.getName() + ";" + pk.getCombatState());
            }


        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }



    }




}
