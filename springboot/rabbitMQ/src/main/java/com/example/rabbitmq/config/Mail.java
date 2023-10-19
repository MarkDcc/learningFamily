package com.example.rabbitmq.config;

/**
 * @Author:dongchen
 * @Date: 2023/8/2 17:34
 */
public class Mail {
    private static final String HYPHEN = " - ";
    public static void main(String[] args) {
        System.out.println((HYPHEN).length());
        System.out.println("Hollow MF".indexOf(HYPHEN));
        System.out.println("Hollow MF".indexOf(HYPHEN) + (HYPHEN).length());
        System.out.println("Hello MF".substring("Hello MF".indexOf(HYPHEN) + (HYPHEN).length()));
    }
}