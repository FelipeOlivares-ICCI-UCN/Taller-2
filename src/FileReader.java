import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    private String filePath;

    public FileReader(String fileName)
    {
        this.filePath = "./data/" + fileName;
    }

    public Scanner getFileScan()  {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Arcivo no encontrado");
        }

        return sc;



    }


}
