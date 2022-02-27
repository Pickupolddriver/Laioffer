package com.leetcode;

public class addBinaryNum {
    public String addBinary(String a, String b) {
        // Corner case
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        // add from last to first
        int idxA = arrA.length - 1;
        int idxB = arrB.length - 1;
        int addOne = 0;
        while (idxA >= 0 && idxB >= 0) {
            if (arrA[idxA] == '1' && arrB[idxB] == '1') {
                arrA[idxA] = (char) ('0' + addOne);
                addOne = 1;
            } else if (arrA[idxA] == '0' && arrB[idxB] == '0') {
                arrA[idxA] = (char) (arrA[idxA] + addOne);
                addOne = 0;
            } else {
                if (addOne == 0) {
                    arrA[idxA] = '1';
                } else {
                    arrA[idxA] = '0';
                    addOne = 1;
                }
            }
            idxA--;
            idxB--;
        }

        while (idxA >= 0 && addOne != 0) {
            if (arrA[idxA] == '0') {
                arrA[idxA] = '1';
                addOne = 0;
            } else {
                arrA[idxA] = '0';
            }
            idxA--;
        }

        if (addOne == 0) {
            return new String(arrA);
        }

        return "1" + new String(arrA);
    }
}
