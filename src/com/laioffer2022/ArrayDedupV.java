package com.laioffer2022;

import java.util.Arrays;

public class ArrayDedupV {
    public int[] dedup(int[] array) {
        // Corner case
        if (array == null || array.length <= 2) {
            return array;
        }
        // imitate the stack on the left side of the array
        // Using fast and slow pointer to copy the elements
        int top = -1;
        int cont = 0;
        for (int i = 0; i < array.length; i++) {
            if (top == -1 || array[i] != array[top]) {
                // the stack is empty or element is diff
                array[++top] = array[i];
                // reset the cont
                cont = 1;
            } else if (cont < 2) {
                // when the element is same as top
                array[++top] = array[i];
                cont++;
            }
        }
        return Arrays.copyOfRange(array, 0, top + 1);
    }

    public String deDup(String input) {
        // Corner case
        if (input == null || input.length() <= 2) {
            return input;
        }
        char[] array = input.toCharArray();
        int top = -1;
        for (int i = 0; i < array.length; i++) {
            if (top < 1 || array[top - 1] != array[i]) {
                array[++top] = array[i];
            }
        }
        return new String(array, 0, top + 1);
    }

    public static void main(String[] args) {
        ArrayDedupV arrayDedupV = new ArrayDedupV();
        String input = "aaaabbbccd";
        String res = arrayDedupV.deDup(input);
        System.out.println(res);
    }
}
