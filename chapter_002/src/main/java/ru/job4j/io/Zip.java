package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static ru.job4j.io.Search.search;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path source : sources) {
                zip.putNextEntry(new ZipEntry(source.toFile().getAbsolutePath().split(":\\\\")[1]));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source.toFile().getAbsolutePath()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        ArgsName ar = ArgsName.of(args);
        String directory = ar.get("d");
        String exclude  = ar.get("e");
        String output  = ar.get("o");
        Path start = Paths.get(directory);
        List<Path> paths = search(start, p -> !p.toFile().getName().endsWith(exclude));
        Zip zip = new Zip();
        zip.packFiles(paths, new File(output));
    }
}