package ru.job4j.io.duplicates;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        String path = new File("./chapter_002/src/test/resources").getAbsolutePath();
        DuplicatesVisitor search = new DuplicatesVisitor();
        Files.walkFileTree(Path.of(path), search);
        search.printDublicates();
    }
}