import java.io.File;
import java.util.Scanner;

public class Menu {
    private enum menuStates {START_MENU, MAIN_MENU, HUNT_MENU , EXIT, SWAP_MENU}
    Pokedex pokedex = new Pokedex();
    Zones zones = new Zones();
    Trainer player = new Trainer();



    Scanner sc = new Scanner(System.in);


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
                    return i;
                }
            }
            sc.nextLine();
        }

    }

    public Menu()
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
        int option2;
        switch (current)
        {
            case START_MENU:
                System.out.println("----------------");
                System.out.println("""
                        1) Continuar.
                        2) Nueva Partida.
                        3) Salir.""");
                System.out.println("----------------");

                option = selectOption(3);

                if (option == 1 && hasSavedData())
                {
                    player.readSaveData(pokedex);
                    System.out.println("Saludos " + player.getName() + "!");
                    return menuStates.MAIN_MENU;
                }

                else if (option == 1 && !hasSavedData())
                {
                    System.out.println("Sin datos guardados...");
                    return menuStates.START_MENU;
                }

                else if (option == 2)
                {
                    System.out.print("Ingrese su nombre: ");
                    String name = sc.next();

                    player.newPlayer(name);

                    System.out.println("Bienvenido " + player.getName() + "!");

                    return menuStates.MAIN_MENU;
                }
                else if (option == 3) {
                    return  menuStates.EXIT;
                }

            case MAIN_MENU:
                System.out.println("----------------");
                System.out.println("""
                        1) Revisar equipo.
                        2) Salir a capturar.
                        3) Acceso al PC (cambiar Pokémon del equipo).
                        4) Retar un gimnasio.
                        5) Desafío al Alto Mando.
                        6) Curar Pokémon.
                        7) Guardar.
                        8) Guardar y Salir.""");
                System.out.println("----------------");

                System.out.print("Que deseas hacer? ");
                option = selectOption(8);

                if (option == 1)
                {
                    player.printTeam(false);
                    return menuStates.MAIN_MENU;


                }

                else if (option == 2)
                {
                    return menuStates.HUNT_MENU;

                }

                else if (option == 3)
                {
                    return menuStates.SWAP_MENU;
                }

                else if (option == 7)
                {
                    player.writeSaveData();
                    return menuStates.MAIN_MENU;
                }

                else if (option == 8)
                {
                    player.writeSaveData();
                    return menuStates.EXIT;

                }

                return menuStates.EXIT;

            case HUNT_MENU:
                System.out.println("----------------");
                zones.printZones();
                System.out.println("----------------");

                option = selectOption(zones.getNumZones());

                Pokemon catched = zones.huntZonePokemon(pokedex, option - 1);

                System.out.println("----------------");
                System.out.println("Encontraste a " + catched.getName());

                if (player.wasPokemonCatched(catched.getName()))
                {
                    System.out.println("Dado que ya tienes a " + catched.getName() + " lo liberas");
                    System.out.println("----------------");
                    return menuStates.MAIN_MENU;
                }

                System.out.println("""
                        1) Capturarlo
                        2) Huir""");
                System.out.print("Que deseas hacer? ");
                option = selectOption(2);
                if (option == 1)
                {
                    player.addPokemon(catched);
                    System.out.println("Capturas a " + catched.getName());
                    System.out.println("----------------");

                }



                else if (option == 2)
                {
                    System.out.println("Huiste de " + catched.getName());
                    System.out.println("----------------");
                }

                return menuStates.MAIN_MENU;


            case SWAP_MENU:
                if (player.getTeamSize() <= 2)
                {
                    System.out.println("Sin suficientes pokemon para cambiar");
                    return menuStates.MAIN_MENU;
                }

                player.printTeam(true);

                System.out.print("Seleccione el indice del Pokemon a cambiar: ");
                option = selectOption(player.getTeamSize());

                System.out.print("Seleccione el indice del Pokemon sustituto: ");
                option2 = selectOption(player.getTeamSize());

                player.swapTeam(option, option2);

                return menuStates.MAIN_MENU;





            case EXIT:
                break;



        }

        System.out.println("Estado invalido. Saliendo del juego...");
        return menuStates.EXIT;
    }



private boolean hasSavedData()
{
    File saveData = new File("./data/Registros.txt");

    if (saveData.exists() && saveData.length() > 0)
    {
        return true;
    }

    else
    {
        return false;
    }


}




}