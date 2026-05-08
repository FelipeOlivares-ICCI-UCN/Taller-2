import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);

    private enum menuStates {START_MENU, MAIN_MENU, EXIT}

    private ArrayList<Habitat> habitatsList;
    private Trainer trainer;
    private PC pc = new PC();

    String[] saveData;
    String[] pokedexData;

    private int  selectOption(int max)
    {

        while (true)
        {
            System.out.print(">");

            if (sc.hasNextInt())
            {
                int i = sc.nextInt();

                if (0 < i && i <= max)
                {
                    sc.nextLine();
                    return i;
                }
            }
            sc.nextLine();
        }

    }

    public void printHabitatData()
    {
        for (Habitat habitat: habitatsList)
        {
            System.out.println(habitat.toString());
        }
    }

    public void setHabitatsList(String[] habitatData)
    {
        habitatsList = new ArrayList<>();

        for (String habitad: habitatData)
        {
            habitatsList.add(new Habitat(habitad));
        }

        for (String pkLine : pokedexData)
        {
            String[] pkData = pkLine.split(";");

            String pkHabitad = pkData[1];

            String pkName = pkData[0];
            String pkType = pkData[9];


            float pkApChance = Float.parseFloat(pkData[2]);

            int pkStats = 0;

            for (int i = 3; i < 9; i++)
            {
                pkStats += Integer.parseInt(pkData[i]);
            }


            for (Habitat habitat: habitatsList)
            {
                if (habitat.getName().equals(pkHabitad))
                {
                    habitat.addWildPokemon(new WildPokemon(pkName, pkType, pkStats, pkApChance));
                }
            }


        }

    }

    private void setTrainer()
    {

        String[] trainerData = this.saveData[0].split(";");

        trainer = new Trainer(trainerData[0], Integer.parseInt(trainerData[1]));

        if (saveData.length > 1)
        {
            for (int i = 1; i < trainerData.length; i++)
            {
                String[] pokemonData = trainerData[i].split(";");

                String pkName = pokemonData[0];

                String pkState = pokemonData[1];

                int pkIndex = searchPokedexData(pkName);

                pokemonData = pokedexData[pkIndex].split(";");

                String pkType = pokemonData[9];

                int pkStats = 0;

                for (int j = 3; j < 9; j++)
                {
                    pkStats += Integer.parseInt(pokedexData[j]);
                }

                pc.addCapturedPokemon(new CapturedPokemon(pkName, pkType, pkStats, pkState));

            }

        }

    }

    private int searchPokedexData(String pkName)
    {
        int i = 0;

        for (String name: pokedexData)
        {
            if (pkName.equals(name))
            {
                return i;
            }

            i++;

        }

        return -1;
    }

    public void setSaveData(String[] saveData)
    {
        this.saveData = saveData;
    }

    public void setPokedexData(String[] pokedexData)
    {
        this.pokedexData = pokedexData;
    }




    public void startGame()
    {

        menuStates currentState = menuStates.START_MENU;

        while (currentState != menuStates.EXIT)
        {
            currentState = menuManager(currentState);

        }
        System.out.println("Adios entrenador...");
    }

    
    private menuStates menuManager(menuStates current)
    {
        int option;
        switch (current)
        {
            case START_MENU:
                System.out.println("""
                        1) Continuar.
                        2) Nueva Partida.
                        3) Salir.""");

                option = selectOption(3);

                if (option == 1)
                {
                    if (saveData.length == 0) {
                        System.out.println("Sin datos guardados...");
                        return menuStates.START_MENU;
                    }

                    else
                    {

                        setTrainer();
                        return menuStates.MAIN_MENU;
                    }


                }

                if (option == 2)
                {
                    System.out.print("Ingrese su nombre: ");
                    String nickname = sc.nextLine();

                    trainer = new Trainer(nickname);

                    return menuStates.MAIN_MENU;

                }

                if (option == 3)
                {
                    return menuStates.EXIT;
                }



            case MAIN_MENU:
                System.out.println("Bienvenido Entrenador!");
                System.out.println("""
                        1) Revisar equipo.
                        2) Salir a capturar.
                        3) Acceso al PC (cambiar Pokémon del equipo).
                        4) Retar un gimnasio.
                        5) Desafío al Alto Mando.
                        6) Curar Pokémon.
                        7) Guardar.
                        8) Guardar y Salir.""");

                option = selectOption(8);

                if (option == 1)
                {
                    if (pc.isPCEmpty())
                    {
                        System.out.println("Sin pokemons...");
                        return menuStates.MAIN_MENU;
                    }


                    for (CapturedPokemon pk: pc.getTrainerTeam())
                    {
                        System.out.println(pk.toString());


                    }

                    return menuStates.MAIN_MENU;


                }

                else
                    if (option == 7)
                {
                    trainer.saveData();
                    pc.saveData();

                    return menuStates.MAIN_MENU;
                }


                else if (option == 8)
                {
                    trainer.saveData();
                    pc.saveData();

                    return menuStates.EXIT;
                }

                else
                {
                    System.out.println("TBA");
                    return menuStates.EXIT;

                }



            case EXIT:
                break;



        }


        System.out.println("Estado invalido. Saliendo del juego...");
        return menuStates.EXIT;
    }



}