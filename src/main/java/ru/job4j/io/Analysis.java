package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(target)))) {
            boolean flag = true;
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                String[] res = line.split(" ");
                //System.out.println(res[0]);
                if (flag && ("500".equals(res[0]) || "400".equals(res[0]))) {
                    out.append(res[1]).append("; ");
                    flag = false;
                } else if (!flag && ("200".equals(res[0]) || "300".equals(res[0]))) {
                    out.append(res[1]).append(";").append(System.lineSeparator());
                    flag = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
