package at.kalwodaknezevic.inventoryhub.foundation;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class Base58 {
    private static final char[] ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz".toCharArray();
    private static final SecureRandom RANDOM = new SecureRandom();

    // Default constructor is required for Spring's dependency injection
    public Base58() {
        // Intentionally left blank
    }

    public String randomString(int length) {
        char[] result = new char[length];

        for(int i = 0; i < length; ++i) {
            char pick = ALPHABET[RANDOM.nextInt(ALPHABET.length)];
            result[i] = pick;
        }

        return new String(result);
    }
}
