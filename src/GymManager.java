import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GymManager {
    List<GymData> GymList = new ArrayList<>();


    public GymManager(int numMedals)
    {
        try (Scanner fileReader = new Scanner( new File("./data/Gimnasios.txt")))
        {
            while (fileReader.hasNextLine())
            {
                String[] data = fileReader.nextLine().split(";");

                int gymNumber = Integer.parseInt(data[0]);
                String gymName = data[1];
                boolean defeatState = false;

                if (numMedals >= gymNumber)
                {
                    defeatState = true;
                }


                int teamSize = Integer.parseInt(data[3]);

                String[] pokemonNames = new String[teamSize];

                for (int i = 0; i < teamSize; i++)
                {
                    pokemonNames[i] = data[4 + i];
                }

                GymList.add(new GymData(gymNumber, gymName, defeatState, pokemonNames));



            }


        } catch (FileNotFoundException e)
        {
            throw new RuntimeException("No se encontro el archivo Gimnasios.txt", e);
        }
    }

    public void writeSaveData()
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./data/Gimnasios.txt")))
        {
            boolean firstLine = true;
            for (GymData gD : GymList)
            {
                if (!firstLine)
                {
                    bw.newLine();
                }
                bw.write(gD.toString());
                firstLine = false;

            }



        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo...");
        }


    }

}


