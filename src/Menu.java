import java.util.Scanner;

public class Menu {

    private int  selectOption(int max)
    {


        Scanner sc = new Scanner(System.in);

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
}