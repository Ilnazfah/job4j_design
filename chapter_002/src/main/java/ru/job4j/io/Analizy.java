package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public static void unavailable(String source, String target) {
        List<String> unavailable = new ArrayList<>();
        String on = null;
        String off;
        String line;
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            while ((line = in.readLine()) != null) {
                if (on == null && line.contains("400") || line.contains("500")) {
                    on = line.substring(4, 12);
                }
                if (on != null && line.contains("200") || line.contains("300")) {
                    off = line.substring(4, 12);
                    unavailable.add(on + ";" + off);
                    on = null;
                }
            }
            writeFile(target, unavailable);
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }

    private static void writeFile(String path, List<String> date) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(path))) {
            date.forEach(out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}