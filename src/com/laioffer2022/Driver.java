package com.laioffer2022;

public class Driver {
    public static void main(String[] args) {
        ATOI atoi = new ATOI();
        String maxValue = String.valueOf(Integer.MAX_VALUE);
        String minValue = String.valueOf(Integer.MIN_VALUE);
        int res = atoi.myAtoi("-2147483647");
        System.out.println(res);
    }
}
