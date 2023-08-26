package com.alianazim.ms.product.util;

import java.util.Random;
import java.util.stream.IntStream;

public enum PanUtil {
    PAN_UTIL;

    public String primaryAccountNumberUtil() {
        var builder = new StringBuilder("400000");
        IntStream.range(0, 9).map(i -> new Random().nextInt(10)).forEach(builder::append);
        var almostPan = builder.toString();
        var checkDigit = calculateCheckDigit(almostPan);
        builder.append(checkDigit);
        return builder.toString();
    }

    private int calculateCheckDigit(String almostPan) {
        int sum = 0;
        for (int i = 0; i < almostPan.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(almostPan.charAt(i)));

            if (i % 2 == 0) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sum += digit;
        }

        return (10 - (sum % 10)) % 10;
    }
}

