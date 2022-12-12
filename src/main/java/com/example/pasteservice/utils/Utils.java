package com.example.pasteservice.utils;

import java.util.Random;

public class Utils {

    public static String generateRandomString(int length) {
        String randomString = "";

        final char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890".toCharArray();
        final Random random = new Random();
        for (int i = 0; i < length; i++) {
            randomString = randomString + chars[random.nextInt(chars.length)];
        }

        return randomString;
    }

}
