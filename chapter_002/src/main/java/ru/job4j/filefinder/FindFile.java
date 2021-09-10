package ru.job4j.filefinder;

import ru.job4j.io.ArgsName;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static ru.job4j.io.Search.search;

public class FindFile {
    private final List<String> pathList = new ArrayList<>();

    public void checkArgs(ArgsName argsName) throws IOException {
        String d = argsName.get("d"); // директория, в которой начинать поиск
        String n = argsName.get("n"); // имя файла, маска
        String t = argsName.get("t"); // тип поиска: mask искать по маске, name по полному совпадение имени
        Path start = Paths.get(d);
        checkPath(start);
        switch (t) {
            case ("mask"):
                String endsWith = n.replace("*.", ".");
                search(start, p -> p.toFile().getName().endsWith(endsWith)).forEach(s -> pathList.add(s.toString()));
                break;
            case ("name") :
                search(start, p -> p.toFile().getName().contains(n)).forEach(s -> pathList.add(s.toString()));
                break;
            default:
                System.out.println("Тип поиска не соответствует критериям");
                System.out.println("-t - тип поиска: mask искать по маске, name по полному совпадение имени");
                System.exit(0);
        }
    }

    public void writeFile(String path) {
        try (PrintWriter outFile = new PrintWriter(
                new BufferedOutputStream(new FileOutputStream(path)))) {
            for (String s : pathList) {
                outFile.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getSize() {
        return pathList.size();
    }

    private void checkPath(Path path) {
        boolean res = Files.isDirectory(path);
        if (!res) {
            System.out.println("Несуществующая папка!");
            System.exit(0);
        }
    }
}