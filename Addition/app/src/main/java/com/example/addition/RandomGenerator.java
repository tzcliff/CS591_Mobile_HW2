package com.example.addition;

import java.util.Random;

public class RandomGenerator {
    public RandomGenerator() {

    }
    public int generate(int max, int min) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}