package ci.dojo.TondeuseKata.core;

import ci.dojo.TondeuseKata.core.input.Input;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileSystemInput implements Input {
    @Override
    public List<String> sharePosition() {
        List<String> instruction = new ArrayList<>();
        try(FileReader fileReader = new FileReader("data.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                instruction.add(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return instruction;
    }
}
