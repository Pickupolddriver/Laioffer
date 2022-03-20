package com.laioffer2022;

import java.util.List;

public class Driver {
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> res = sol.generateParenthesis(3);
        for (String x : res) {
            System.out.println(x);
        }
    }
}
