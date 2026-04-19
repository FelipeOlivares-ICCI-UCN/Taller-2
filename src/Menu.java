import java.io.File;
import java.util.Scanner;

public class Menu {
    private enum menuStates {START_MENU, MAIN_MENU, EXIT}
    Pokedex pokedex = new Pokedex();
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
        switch (current)
        {
            case START_MENU:
                System.out.println("""
                        1) Continuar.
                        2) Nueva Partida.
                        3) Salir.""");

                int option = selectOption(3);

                if (option == 3)
                {
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