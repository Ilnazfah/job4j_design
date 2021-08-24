package ru.job4j.io;

import java.io.*;
import java.util.Scanner;

public class CSVReader {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        ArgsName ar = ArgsName.of(args);
        CSVReader csvReader = new CSVReader();
        csvReader.readFile("file.csv");
    }

    public void readFile(String path) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            in.lines().forEach(System.out::println);
        }
//        Scanner scanner = new Scanner();
//            while (scanner.hasNextInt()) {
//                System.out.print(scanner.nextInt());
//                System.out.print(" ");
//            }
    }
 }