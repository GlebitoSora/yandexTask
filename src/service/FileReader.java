package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileReader {
    public ArrayList<String> readFileContents(String fileName) {
        String path = "src/res/" + fileName;
        try {
            return new ArrayList<>(Files.readAllLines(Path.of(path)));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с отчётом. Возможно, файл отсутствует в нужной директории.");
            return new ArrayList<>();
        }
    }
}

