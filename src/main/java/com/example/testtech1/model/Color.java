package com.example.testtech1.model;

import java.util.Arrays;
import java.util.Random;

public enum Color {
    BLACK("BLACK"),
    WHITE("WHITE"),
    RED("RED"),
    BLUE("BLUE"),
    GREEN("GREEN");

    private final String name;
    private static final Color[] COLORS = Color.values();

    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Color getRandomColor() {
        return COLORS[new Random().nextInt(COLORS.length)];
    }

    public static Color getEnumByName(String name) {
        return Arrays.stream(Color.values())
                .filter(e -> e.getName().equals(name.toUpperCase()))
                .findFirst().orElseThrow();
    }
}
