package ru.job4j.filefinder;

import ru.job4j.io.ArgsName;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        if (args.length < 4) {
            System.out.println("Для корректной работы программы должны быть указаны следующие аргументы:\n");
            System.out.println("-d - директория, в которой начинать поиск");
            System.out.println("-n - имя файла, маска");
            System.out.println("-t - тип поиска: mask искать по маске, name по полному совпадение имени");
            System.out.println("-o - путь для записи результата в файл\n");
            throw new IllegalArgumentException("Неверные аргументы!");
        }

        FindFile findFile = new FindFile();
        ArgsName argsName = ArgsName.of(args);
        System.out.println("Идет поиск, пожалуйста подождите...");
        findFile.checkArgs(argsName);
        findFile.writeFile(argsName.get("o"));
        System.out.println("Количество найденных файлов: " + findFile.getSize());
        System.out.println("Результаты поиска записаны в файл: " + argsName.get("o"));
    }
}