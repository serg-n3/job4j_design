package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("data/dataresult.txt")) {
            int array;
            for (int row = 1; row <= 9; row++) {
                for (int cell = 1; cell <= 9; cell++) {
                    array = row  * cell;
                    out.write((row + " x " + cell + " = " + array).getBytes());
                    out.write(System.lineSeparator().getBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}