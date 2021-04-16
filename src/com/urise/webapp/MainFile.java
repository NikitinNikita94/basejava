package com.urise.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) {
        String filePath = ".\\.gitignore";

        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("ERROR", e);
        }

        File dir = new File("./src/com/urise/webapp");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name : list) {
                System.out.println(name);
            }
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileRecursion(String.valueOf(dir));

    }

    public static void fileRecursion(String path) {
        File f = new File(path);
        File[] fl = f.listFiles();
        if (fl == null) {
            throw new RuntimeException("Error : file is null");
        }
        for (File file : fl) {
            if (file.isDirectory() && !file.isHidden()) {
                System.out.println(file.getAbsolutePath());
                fileRecursion(file.getAbsolutePath());
            } else {
                System.out.println(file.getName());
            }
        }
    }
}
