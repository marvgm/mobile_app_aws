package com.appsdeveloperblog.app.ws.share;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class Utils {
    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    public String generateUserId(int length) {
        return generateRandomString(length);
    }

    public String generateRandomString(int length) {
        StringBuilder returnValue = new StringBuilder();

        for(int i = 0; i <= length; i++ ) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return new String(returnValue);
    }
}
