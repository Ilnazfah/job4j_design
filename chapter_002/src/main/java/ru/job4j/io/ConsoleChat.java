package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void run() {
        Scanner scan = new Scanner(System.in);
        List<String> botAnswers = readBotAnswers();
        String user = scan.nextLine();
        log.add("User: " + user);
        while (!user.equals(OUT)) {
            if (user.equals(STOP)) {
                while (!user.equals(CONTINUE)) {
                    user = scan.nextLine();
                    if (user.equals(OUT)) {
                        log.add("User: " + user);
                        writelog();
                        return;
                    }
                    log.add("User: " + user);
                }
            }
            int random = (int) (Math.random() * botAnswers.size());
            String bot = botAnswers.get(random);
            log.add("Bot: " + bot);
            System.out.println(bot);
            user = scan.nextLine();
            log.add("User: " + user);
        }
        writelog();
    }

    private List<String> readBotAnswers() {
        List<String> res = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers, StandardCharsets.UTF_8))) {
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