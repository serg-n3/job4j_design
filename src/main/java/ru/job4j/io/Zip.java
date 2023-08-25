package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        for (Path source : sources) {
            try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
                zip.putNextEntry(new ZipEntry(source.getFileName().toString()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source.getFileName().toString()))) {
                    zip.write(out.readAllBytes());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
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

    public static void main(String[] args) {
        Zip zip = new Zip();
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
        Zip zip1 = new Zip();
        zip1.packFiles(
                (List<Path>) new File("C:\\projects\\job4j_design\\"),
                new File("./job4j.zip")
        );
    }
}
