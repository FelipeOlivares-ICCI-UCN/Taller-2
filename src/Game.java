import java.io.FileNotFoundException;
import java.util.List;

public class Game {
    public static void main(String[] args) throws FileNotFoundException {
        DataReader gameReader = new DataReader();
        String[] eliteData = gameReader.getEliteData();
        String[] gymData = gameReader.getGymData();
        String[] habitatData = gameReader.getHabitatData();
        String[] pokedexData = gameReader.getPokedexData();
        String[] saveData = gameReader.getSaveData();

        Menu menu = new Menu();

        menu.setPokedexData(pokedexData);
        menu.setHabitatsList(habitatData);

        menu.setSaveData(saveData);

        menu.startGame();


    }
}
