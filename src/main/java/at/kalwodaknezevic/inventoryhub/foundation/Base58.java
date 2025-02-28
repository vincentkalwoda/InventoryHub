package at.kalwodaknezevic.inventoryhub.foundation;

import java.security.SecureRandom;

public record Base58(String value) {
    private static final char[] ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz".toCharArray();
    private static final SecureRandom RANDOM = new SecureRandom();

    public Base58 {
    }

    public static String random(int length) {
        char[] result = new char[length];
        for (int i = 0; i < length; ++i) {
            char pick = ALPHABET[RANDOM.nextInt(ALPHABET.length)];
            result[i] = pick;
        }
        return new String(result);
    }
}