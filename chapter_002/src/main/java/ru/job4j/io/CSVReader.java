package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        ArgsName ar = ArgsName.of(args);
        String path = ar.get("path");
        String delimiter = ar.get("delimiter");
        String out = ar.get("out");
        String filter = ar.get("filter");
        CSVReader csvReader = new CSVReader();
        csvReader.run(path, delimiter, out, filter);
    }

    public void run(String path, String delimiter, String out, String filter) {
        List<String> file = readFile(path, delimiter, filter);
        if (out.equals("stdout")) {
            for (String s : file) {
                    System.out.println(s);
            }
        } else {
            try (PrintWriter outFile = new PrintWriter(
                    new BufferedOutputStream(new FileOutputStream(out)))) {
                for (String s : file) {
                    outFile.println(s);
                }
            } catch (Exception e) {
                    e.printStackTrace();
            }
        }
    }

    private List<String> readFile(String path, String delimiter, String filter) {
        List<String> result = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            Scanner scan = new Scanner(in);
                String[] filterArr = filter.split(",");
                int[] indexes = null;
                while (scan.hasNextLine()) {
                    List<String> lineArr = Arrays.asList(scan.nextLine().split(delimiter));
                    String line = "";
                    if (indexes == null) {
                        indexes = new int[filterArr.length];
                        for (int i = 0; i < indexes.length; i++) {
                            indexes[i] = lineArr.indexOf(filterArr[i]);
                        }
                    }
                    for (int i = 0; i < filterArr.length; i++) {
                        line += lineArr.get(indexes[i]) + " ";
                    }
                    result.add(line.strip());
                }
                scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
 }