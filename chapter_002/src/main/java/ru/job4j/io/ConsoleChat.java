package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String logPath;
    private final String botAnswers;
    private final List<String> log = new ArrayList<>();

    public ConsoleChat(String logPath, String botAnswers) {
        this.logPath = logPath;
        this.botAnswers = botAnswers;
    }

    // TODO пробная версия метода. Доработать
    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> botAnswers = readBotAnswers();
        while (true) {
            String user = reader.readLine();
            int random = (int) (Math.random() * botAnswers.size());
            log.add("User: " + user);
            if (user.equalsIgnoreCase(OUT)) {
                break;
            }
            String bot = botAnswers.get(random);
            log.add("Bot: " + bot);
            System.out.println(bot);
        }
        writelog();
    }

    private List<String> readBotAnswers() {
        List<String> res = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers, Charset.forName("WINDOWS-1251")))) {
            in.lines().forEach(res::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    private void writelog() {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(new FileOutputStream(logPath)))) {
            for (String s : log) {
                out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat("./chapter_002/ccLog.txt", "./chapter_002/botAnswers.txt");
        cc.run();
    }
}