import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


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

    public void printTeam(boolean printAll)
    {
        System.out.println("----------------");
        if (TrainerTeam.isEmpty())
        {
            System.out.println("Sin pokemons...");
            System.out.println("----------------");
            return;

        }

        int i = 1;

        for (Pokemon p : TrainerTeam)
        {
            if (printAll) {
                if (i > 6) {
                    return;
                }
            }
            System.out.println(i + ")" + p.toString());
            i++;

        }

        System.out.println("----------------");
    }

    public void swapTeam(int selectedTeamIndex, int selectedBoxIndex)
    {


        if (selectedTeamIndex == selectedBoxIndex)
        {
            System.out.println("Error, Mismo indice");
            return;

        }


        selectedBoxIndex--;
        selectedTeamIndex--;

        Pokemon temp = TrainerTeam.get(selectedBoxIndex);

        TrainerTeam.set(selectedBoxIndex, TrainerTeam.get(selectedTeamIndex));
        TrainerTeam.set(selectedTeamIndex, temp);

    }

    public int getTeamSize()
    {
        return TrainerTeam.size();
    }



    public void writeSaveData()
    {
        try (FileWriter fileWriter = new FileWriter("./data/Registros.txt", false))
        {
            fileWriter.write(this.name + ";" + this.medals);
            for (Pokemon p :TrainerTeam)
            {
                fileWriter.write("\n");
                fileWriter.write(p.getName() + ";" + p.getState());
            }



        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo...");
        }


    }





    public void addPokemon(Pokemon pk)
    {
        TrainerTeam.add(pk);

    }

    public boolean wasPokemonCatched(String pkName)
    {
        for (Pokemon p :TrainerTeam)
        {
            if (pkName.equals(p.getName()))
            {
                return true;
            }


        }

        return false;
    }


    public String getName() {
        return name;
    }

    public int getMedals()
    {
        return this.medals;
    }
}
