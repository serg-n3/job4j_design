package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) throws IllegalArgumentException {
        if (values.get(key) == null) {
            throw new IllegalArgumentException("This key: '" + key + "' is missing");
        }
        return values.get(key);
    }

    private void parse(String[] args) throws IllegalArgumentException {
        for (String ar : args) {
            valid(ar);
            ar = ar.substring(1);
            String[] ra = ar.split("=", 2);
            values.put(ra[0], ra[1]);
        }
    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    private void valid(String arg) {
        if (!arg.startsWith("-")) {
            throw new IllegalArgumentException("Error: This argument '" + arg + "' does not start with a '-' character");
        }
        if (arg.startsWith("-=")) {
            throw new IllegalArgumentException("Error: This argument '" + arg + "' does not contain a key");
        }
        if (arg.endsWith("=") && (arg.indexOf("=") == arg.lastIndexOf("="))) {
            throw new IllegalArgumentException("Error: This argument '" + arg + "' does not contain a value");
        }
        if (!arg.contains("=")) {
            throw new IllegalArgumentException("Error: This argument '" + arg + "' does not contain an equal sign");
        }
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}