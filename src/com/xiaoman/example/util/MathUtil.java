package com.xiaoman.example.util;

import java.util.Random;

public class MathUtil {

    public static int rangInt(int max, int min) {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }
}
