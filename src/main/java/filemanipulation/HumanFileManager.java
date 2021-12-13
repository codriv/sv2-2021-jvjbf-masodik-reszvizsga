package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {

    private List<Human> humans = new ArrayList<>();

    public List<Human> getHumans() {
        return humans;
    }

    public void readHumansFromFile(Path path) {
        try {
            fillHumans(Files.readAllLines(path));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    private void fillHumans(List<String> dataFromCsv) {
        for (String line: dataFromCsv) {
            String name = line.split(";")[0];
            String identityNumber = line.split(";")[1];
            humans.add(new Human(name, identityNumber));
        }
    }

    public void writeMaleHumansToFile(Path path) {
        try {
            Files.write(path, getMaleHumansToCsv());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private List<String> getMaleHumansToCsv() {
        List<String> maleHumansToCsv = new ArrayList<>();
        for (Human human: humans) {
            if (!human.getIdentityNumber().startsWith("2")) {
                maleHumansToCsv.add(human.toString());
            }
        }
        return maleHumansToCsv;
    }
}