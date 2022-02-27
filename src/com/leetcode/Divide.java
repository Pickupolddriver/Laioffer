package com.leetcode;

public class Divide {
    // ???????? divisor / dividend
    public int divide(int dividend, int divisor) {
        // Corner case
        if (divisor == 0 || dividend > divisor) {
            return 0;
        }
        if (dividend == 1) {
            return divisor;
        }
        // Using Expanding Binary Search
        int left = 1;
        int right = 2;
        while (Integer.MAX_VALUE / right > dividend && divisor / right <= left) {
            int mid = left + (right - left) / 2;
            // Compare with mid
            if (mid * dividend == divisor) {
                return mid;
            } else if (mid * dividend > divisor) {
                right = mid - 1;
            } else {
                // mid * dividend < divisor
                // need to Expand right
                left = mid;
                right = right * 2;
            }
        }

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            // Compare with mid
            if (mid * dividend == divisor) {
                return mid;
            } else if (mid * dividend > divisor) {
                right = mid - 1;
            } else {
                // mid * dividend < divisor
                // need to Expand right
                left = mid;
            }
        }

        if (right * dividend <= divisor) {
            return right;
        }

        return left;
    }

    public static void main(String[] args) {
        Divide divide = new Divide();
        int res = divide.divide(2, 7);
        System.out.println(res);
    }
}
