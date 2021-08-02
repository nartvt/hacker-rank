package com.nartvt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReadFile {

    private static final String folder = System.getProperty("user.dir") + File.separator + "java/validate-html-tag/testcase/";

    public static List<String> listFilesForFolder() {
        List<String> filePaths = new ArrayList<>();
        File files = new File(folder);
        for (final File fileEntry : Objects.requireNonNull(files.listFiles())) {
            if (fileEntry.isFile()) {
                filePaths.add(fileEntry.getPath());
            }
        }
        return filePaths;
    }

    public static List<String[]> readFile() {
        final List<String[]> results = new ArrayList<>();

        final List<String> filePaths = listFilesForFolder();
        for (String filePath : filePaths) {

            try (InputStream inputStream = new FileInputStream(filePath)) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                    int number = Integer.parseInt(br.readLine());
                    String[] files = new String[number];
                    int numbk = number;
                    while (number > 0) {
                        String line = br.readLine();
                        files[numbk - number] = line;
                        number--;
                    }
                    results.add(files);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}
