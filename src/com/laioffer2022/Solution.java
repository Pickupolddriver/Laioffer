package com.laioffer2022;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // Corner case
        if (n == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        generateParenthesis(0, 0, n, sb, res);
        return res;
    }

    public void generateParenthesis(int left, int right, int n, StringBuilder sb, List<String> res) {
        // Terminate condition
        if (left == n && right == n) {
            String curr = new String(sb);
            res.add(curr);
            return;
        }

        // Expanding Rule
        if (left < n) {
            sb.append("(");
            generateParenthesis(left + 1, right, n, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (left > right && right < n) {
            sb.append(")");
            generateParenthesis(left, right + 1, n, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
