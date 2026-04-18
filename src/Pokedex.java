import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pokedex {
    private ArrayList<Pokedata> pokedex = new ArrayList<>();


    public Pokedex()
    {
        try (Scanner fileReader = new Scanner( new File("./data/Pokedex.txt"))) {
            while (fileReader.hasNextLine())
            {
                String[] data = fileReader.nextLine().split(";");
                String name = data[0];
                String location = data[1];
                float apparitionChance = Float.parseFloat(data[2]);
                int hp = Integer.parseInt(data[3]);
                int ap =  Integer.parseInt(data[4]);
                int dp = Integer.parseInt(data[5]);
                int sap = Integer.parseInt(data[6]);
                int sdp = Integer.parseInt(data[7]);
                int sp = Integer.parseInt(data[8]);


                String type = data[9];


                Pokedata pData = new Pokedata(name, location, apparitionChance, type);
                pData.setStats(hp,ap, dp, sap, sdp, sp);

                pokedex.add(pData);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("The file was not found" ,e);
        }

    }


    public void printPokedex()
    {
        for (Pokedata p : pokedex)
        {
            System.out.println(p.toString());
        }


    }






}
