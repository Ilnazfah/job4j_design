package ru.job4j.io.duplicates;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Map<FileProperty, List<String>> paths = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        long size = file.toFile().length();
        String name = file.toFile().getName();
        FileProperty files = new FileProperty(size, name);
        if (paths.get(files) == null) {
            List<String> fullPath = new ArrayList<>();
            fullPath.add(file.toFile().getAbsolutePath());
            paths.put(files, fullPath);
        } else {
            paths.get(files).add(file.toFile().getAbsolutePath());
        }
        return FileVisitResult.CONTINUE;
    }

    public void printDublicates() {
        for (Map.Entry<FileProperty, List<String>> dub : paths.entrySet()) {
            List<String> value = dub.getValue();
            if (value.size() > 1) {
                System.out.println("Найдено " + value.size() + " дубликата(ов) с именем файла: " + dub.getKey().getName() + " и размером " + dub.getKey().getSize() + " байтов");
                for (String s : value) {
                    System.out.println(s);
                }
                System.out.println();
            }
        }
    }
}