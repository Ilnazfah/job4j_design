package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;

import static org.hamcrest.MatcherAssert.assertThat;

public class AnalizyTest {

    @Test
    public void whenWriteLogThenRead() {
        String logPath = "./../server.log";
        String targetPath = "./../target.csv";
        List<String> unavailableList = List.of("10:57:01;10:59:01", "11:01:02;11:02:02");
        List<String> target = new ArrayList<>();
        Analizy.unavailable(logPath, targetPath);
        try (BufferedReader in = new BufferedReader(new FileReader(targetPath))) {
            in.lines().forEach(target::add);
        } catch (Exception  e) {
            e.printStackTrace();
        }
        assertThat(target, is(unavailableList));
    }
}
