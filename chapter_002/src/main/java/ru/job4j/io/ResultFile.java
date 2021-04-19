package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        int[][] table = multiple(5);
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int[] ints : table) {
                for (int j = 0; j < table.length; j++) {
                    out.write((ints[j] + " ").getBytes());

                }
                out.write(System.getProperty("line.separator").getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     public static int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size; col++) {
                table[row - 1][col - 1] = row * col;
            }
        }
        return table;
    }
}