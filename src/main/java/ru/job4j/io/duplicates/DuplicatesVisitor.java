package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<FileProperty, List<Path>> dubl = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (Files.isRegularFile(file)) {
            FileProperty fileInfo = new FileProperty(Files.size(file), file.getFileName().toString());
            dubl.putIfAbsent(fileInfo, new ArrayList<>());
            dubl.get(fileInfo).add(file);
        }
        return super.visitFile(file, attrs);
    }

    public Map<FileProperty, List<Path>> getDuplicates() {
        return dubl;
    }
    }

