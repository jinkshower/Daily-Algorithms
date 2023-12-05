package filereading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderPrac {

    public List<String> readLines() {

        try {
            File text = new File("src/main/java/filereading/example.md");
            List<String> result = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(text));
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                result.add(string);
            }
            return result;
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {

    }
}
