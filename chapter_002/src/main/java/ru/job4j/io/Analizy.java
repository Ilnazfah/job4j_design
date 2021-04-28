package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            List<String> unavailable = new ArrayList<>();
            String on = null;
            String off = null;
            while (in.readLine() != null) {
                String line = in.readLine();
                if (line.contains("400") || line.contains("500")) {
                    on = line.substring(4, 12);
                }
                if (line.contains("200") || line.contains("300")) {
                    off = line.substring(4, 12);
                    unavailable.add(on + ";" + off);
                }
            }
            writeFile(target, unavailable);
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }

    private void writeFile(String path, List<String> date) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(path))) {
            date.forEach(out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("server.log", "target.csv");
    }
}