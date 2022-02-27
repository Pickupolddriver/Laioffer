package com.laioffer2022;

import java.util.ArrayList;
import java.util.List;

public class ValidParenthesis {
    public static void main(String[] args) {
        ValidParenthesis validParenthesis = new ValidParenthesis();
        List<String> res = validParenthesis.validParentheses(2);
    }

    public List<String> validParentheses(int n) {
        List<String> result = new ArrayList<>();
        char[] array = new char[n * 2];
        allParenthesis(array, n, n, 0, result);
        return result;
    }

    public void allParenthesis(char[] curr, int left, int right, int index, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(new String(curr));
            return;
        }
        if (left > 0) {
            curr[index] = '(';
            allParenthesis(curr, left - 1, right, index + 1, result);
        }
        if (right > left) {
            curr[index] = ')';
            allParenthesis(curr, left, right - 1, index + 1, result);
        }
    }
}
