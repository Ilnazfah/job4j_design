package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;

import static org.hamcrest.MatcherAssert.assertThat;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenWriteLogThenRead() throws IOException {
        String logPath = "./../server.log";
        File targetPath = folder.newFile("target.csv");
        List<String> unavailableList = List.of("10:57:01;10:59:01", "11:01:02;11:02:02");
        List<String> target = new ArrayList<>();
        Analizy.unavailable(logPath, targetPath.getAbsolutePath());
        try (BufferedReader in = new BufferedReader(new FileReader(targetPath))) {
            in.lines().forEach(target::add);
        } catch (Exception  e) {
            e.printStackTrace();
        }
        assertThat(target, is(unavailableList));
    }
}