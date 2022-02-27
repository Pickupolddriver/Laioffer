package com.laioffer2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Combination4TelephonePad {
    // Given a telephone keypad,
    // and an int number,
    // print all words which are possible by pressing these numbers,
    // the output strings should be sorted.
    public String[] combinations(int number) {
        // Corner case
        if (number < 0) {
            return new String[0];
        }
        // Write your solution here
        List<String> resList = new ArrayList<>();
        HashMap<Integer, String> pad = new HashMap<>();
        pad.put(0, "");
        pad.put(1, "");
        pad.put(2, "abc");
        pad.put(3, "def");
        pad.put(4, "ghi");
        pad.put(5, "jkl");
        pad.put(6, "mno");
        pad.put(7, "pqrs");
        pad.put(8, "tuv");
        pad.put(9, "wxyz");
        List<Integer> tmp = new ArrayList<>();
        while (number != 0) {
            int digit = number % 10;
            tmp.add(digit);
            number = number / 10;
        }
        int[] digits = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            digits[i] = tmp.get(tmp.size() - i - 1);
        }
        StringBuilder sb = new StringBuilder();
        combinations(resList, sb, 0, digits, pad);
        String[] res = new String[resList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    private void combinations(List<String> resList, StringBuilder sb, int currIdx, int[] digits, HashMap<Integer, String> pad) {
        // Terminate condition
        if (currIdx == digits.length) {
            resList.add(new String(sb));
            return;
        }
        // Expanding Rule
        String currDigit = pad.get(digits[currIdx]);
        char[] array = currDigit.toCharArray();
        // in current level, try to add each char on this pad
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            combinations(resList, sb, currIdx + 1, digits, pad);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
