package com.laioffer2022;

import java.util.HashSet;
import java.util.Set;

public class ATOI {
    public int myAtoi(String s) {
        // Corner case
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Set<Character> validCharacter = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            validCharacter.add((char) ('0' + i));
        }

        char[] array = s.toCharArray();
        int idxBegin = 0;
        // Skip all the space character
        while (idxBegin < array.length && array[idxBegin] == ' ') {
            idxBegin++;
        }
        // check the first non-space character
        if (idxBegin == array.length) {
            return 0;
        }
        if (!validCharacter.contains(array[idxBegin]) && array[idxBegin] != '-' && array[idxBegin] != '+') {
            return 0;
        }
        int sign = 1;
        int res = 0;
        if (array[idxBegin] == '-') {
            sign = -1;
            idxBegin++;
        } else if (array[idxBegin] == '+') {
            idxBegin++;
        }

        // Read the numbers in
        while (idxBegin < array.length && validCharacter.contains(array[idxBegin])) {
            // Need to validate the res
            if (Integer.MAX_VALUE / 10 < res) {
                return resOutOfBound(sign);
            }
            res = res * 10;
            if (sign > 0 && Integer.MAX_VALUE - (int) (array[idxBegin] - '0') < res) {
                return resOutOfBound(sign);
            } else if (sign < 0 && Integer.MAX_VALUE - (int) (array[idxBegin] - '0') < res - 1) {
                return resOutOfBound(sign);
            }
            res = res + (int) (array[idxBegin] - '0');
            idxBegin++;
        }
        if (sign == 1) {
            return res;
        } else {
            res = res * sign;
            return res;
        }
    }

    public int resOutOfBound(int sign) {
        if (sign > 0) {
            return Integer.MAX_VALUE;
        } else {
            return Integer.MIN_VALUE;
        }
    }
}
