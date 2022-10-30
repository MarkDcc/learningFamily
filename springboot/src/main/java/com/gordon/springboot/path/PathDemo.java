package com.gordon.springboot.path;

import java.nio.file.Path;

/**
 * @author dongchen
 * @Data 2022/10/5
 * @Time 9:36
 */
public class PathDemo {
    public static void main(String[] args) {

        Path path = Path.of("C:/Users/dongchen/Downloads/demo.txt");
        System.out.println(path.getRoot());
        System.out.println(path.isAbsolute());
        Path of = Path.of("SpringbootApplication.java");
        System.out.println(of.toAbsolutePath());
        System.out.println(of.endsWith(".java"));
        System.out.println(of.endsWith("SpringbootApplication.java"));

    }
}
