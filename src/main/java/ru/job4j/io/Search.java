package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        valid(args);
        Path start = Path.of(args[0]);
        search(start, p -> p.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void valid(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Incorrect number of arguments");
        }
        Path test = Path.of(args[0]);
        if (!Files.exists(test)) {
            throw new IllegalArgumentException(String.format("Not exist %s", test.toAbsolutePath()));
        }
        if (!Files.isDirectory(test)) {
            throw new IllegalArgumentException(String.format("Not directory %s", test.toAbsolutePath()));
        }
        if (!args[1].matches("\\.\\w+")) {
            throw new IllegalArgumentException("Incorrect file extension");
        }
    }
}