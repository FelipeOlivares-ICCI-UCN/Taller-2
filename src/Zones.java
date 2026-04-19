import javax.swing.plaf.basic.BasicBorders;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Zones {
    Random rand = new Random();
    ArrayList<String> locations = new ArrayList<>();

    public Zones()
    {

        try (Scanner fileReader = new Scanner( new File("./data/Habitats.txt")))
        {
            while (fileReader.hasNextLine())
            {
                String zone = fileReader.nextLine();
                locations.add(zone);

            }


        } catch(FileNotFoundException e)
        {
            System.out.println("No se encontro Habitats.txt");

        }
    }

    public Pokemon huntZonePokemon(Pokedex pokedex, int zoneId)
    {
        ArrayList<String> zonePoke = pokedex.getLocationPokemons(locations.get(zoneId));

        float r = rand.nextFloat();
        float cumulative = 0;

        for (String pokeName : zonePoke)
        {
            cumulative += pokedex.getApparitionChance(pokeName);
            if (r < cumulative)
            {
                return pokedex.getPokemon(pokeName);
            }

        }

        return pokedex.getPokemon(zonePoke.get(zonePoke.size() - 1));


    }

    public void printZones()
    {
        int i = 1;
        for (String zone : locations)
        {
            System.out.println(i + ")" + zone);
            i++;
        }



    }

    public int getNumZones()
    {
        return locations.size();

    }

}
