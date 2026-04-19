import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Trainer {
    private String name;
    private int medals;

    private LinkedList<Pokemon> TrainerTeam = new LinkedList<>();


    public void newPlayer(String name)
    {
        this.name = name;
        this.medals = 0;
    }

    public void readSaveData(Pokedex pkdex)
    {
        try (Scanner fileReader = new Scanner( new File("./data/Registros.txt")))
        {
            String[] data = fileReader.nextLine().split(";");

            this.name = data[0];
            this.medals = Integer.parseInt(data[1]);

            while (fileReader.hasNextLine())
            {
                data = fileReader.nextLine().split(";");

                String pName = data[0];
                String state = data[1];

                Pokemon p = pkdex.getPokemon(pName);
                p.setState(state);

                TrainerTeam.add(p);


            }




        } catch (FileNotFoundException e)
        {
            throw new RuntimeException("Error, los datos del entrenador no existen", e);
        }

    }

    public void printTeam()
    {
        if (TrainerTeam.size() == 0)
        {
            System.out.println("Sin pokemons...");
            return;

        }

        for (Pokemon p : TrainerTeam)
        {
            System.out.println(p.toString());

        }
    }

    public void addPokemon(Pokemon pk)
    {
        TrainerTeam.add(pk);

    }


    public String getName() {
        return name;
    }
}
