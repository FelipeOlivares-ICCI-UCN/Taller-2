import java.util.ArrayList;
import java.util.List;

public class Elite {
    String name;
    int number;

    List<CapturedPokemon> eliteTeam = new ArrayList<>(6);

    public Elite(String name, int number)
    {
        this.name = name;
        this.number = number;
    }

}
