
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataReader {

    public String[] getGymData()
    {
        List<String> gymData = new ArrayList<>();
        Scanner gymSc = new FileReader("Gimnasios.txt").getFileScan();

        while (gymSc.hasNextLine())
        {
            String gymLine = gymSc.nextLine();
            gymData.add(gymLine);

        }

        gymSc.close();

        return gymData.toArray(new String[0]);
    }

    public String[] getPokedexData()
    {
        List<String> pokedexData = new ArrayList<>();
        Scanner pkdexSc = new FileReader("Pokedex.txt").getFileScan();

        while (pkdexSc.hasNextLine())
        {
            String pkdexLine = pkdexSc.nextLine();
            pokedexData.add(pkdexLine);
        }

        pkdexSc.close();

        return pokedexData.toArray(new String[0]);
    }

    public String[] getEliteData()
    {
        List<String> eliteData = new ArrayList<>();
        Scanner eliteSc = new FileReader("Alto Mando.txt").getFileScan();

        while (eliteSc.hasNextLine())
        {
            String eliteLine = eliteSc.nextLine();
            eliteData.add(eliteLine);
        }

        eliteSc.close();

        return eliteData.toArray(new String[0]);
    }

    public String[] getSaveData()
    {
        List<String> saveData = new ArrayList<>();
        Scanner saveSc = new FileReader("Registros.txt").getFileScan();

        while (saveSc.hasNextLine())
        {
            String saveLine = saveSc.nextLine();
            saveData.add(saveLine);
        }

        saveSc.close();

        return saveData.toArray(new String[0]);
    }

    public String[] getHabitatData()
    {
        List<String> habitatData = new ArrayList<>();
        Scanner habitatSc = new FileReader("Habitats.txt").getFileScan();

        while (habitatSc.hasNextLine())
        {
            String habitatLine = habitatSc.nextLine();
            habitatData.add(habitatLine);
        }

        return habitatData.toArray(new String[0]);
    }

}
