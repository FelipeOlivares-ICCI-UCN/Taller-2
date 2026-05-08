import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Habitat{
    private String name;
    Random random = new Random();

    public Habitat(String name)
    {
        this.name = name;
    }

    private List<WildPokemon> wildPokemonsList = new ArrayList<>();

    public void addWildPokemon(WildPokemon pk)
    {
        wildPokemonsList.add(pk);
    }

    public String getName()
    {
        return this.name;
    }

    public CapturedPokemon captureRandomPokemon()
    {
        float p = 0;
        float randomValue = random.nextFloat();

        for (WildPokemon pk: wildPokemonsList)
        {
            if (p >= randomValue)
            {
                return pk.capturePokemon();
            }

            p += pk.getApparitionChance();
        }

        return wildPokemonsList.getLast().capturePokemon();

    }

    @Override
    public String toString() {
        return name + "|" + wildPokemonsList;
    }
}
