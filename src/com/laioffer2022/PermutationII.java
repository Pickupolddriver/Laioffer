package com.laioffer2022;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermutationII {
    public static void main(String[] args) {
        PermutationII permutationII = new PermutationII();
        List<String> res = permutationII.permutations("abab");
        for (String x : res) {
            System.out.println(x);
        }
    }

    public List<String> permutations(String input) {
        List<String> res = new ArrayList<>();
        // Corner case
        if (input == null || input.length() == 0) {
            return res;
        }
        char[] array = input.toCharArray();
        generatePermutation(array, 0, res);
        return res;
    }

    private void generatePermutation(char[] array, int index, List<String> res) {
        // Terminate condition
        if (index == array.length) {
            res.add(new String(array));
            return;
        }
        HashSet<Character> usedCharacter = new HashSet<>();
        for (int i = index; i < array.length; i++) {
            if (usedCharacter.add(array[i])) {
                swap(array, index, i);
                generatePermutation(array, index + 1, res);
                swap(array, index, i);
            }
        }
    }

    public void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
