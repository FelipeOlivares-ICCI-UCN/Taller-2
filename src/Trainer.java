import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Trainer {
    private String nickname;
    private int medals;

    public List<CapturedPokemon> trainerTeam = new ArrayList<>();

    public Trainer(String nickname, int medals)
    {
        this.nickname = nickname;
        this.medals = medals;
    }

    public Trainer(String nickname)
    {
        this.nickname = nickname;
        this.medals = 0;
    }

    public void addMedal()
    {
        medals++;
    }

    public int getMedals()
    {
        return this.medals;
    }

    public void updateTeam(PC box)
    {
        trainerTeam = box.getTrainerTeam();
    }

    public String getNickname()
    {
        return this.nickname;

    }

    public void saveData()
    {
        try( BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./data/Registros.txt")))
        {
            bufferedWriter.write(this.nickname + ";" + this.medals);


        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }



    }




}
