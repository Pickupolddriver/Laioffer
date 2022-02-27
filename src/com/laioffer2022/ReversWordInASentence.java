package com.laioffer2022;

public class ReversWordInASentence {
    public static void main(String[] args) {
        String input = "    I     Love  Google  ";
        ReversWordInASentence reversWordInASentence = new ReversWordInASentence();
        String res = reversWordInASentence.reverseWords(input);
        System.out.println(res);
    }

    public String reverseWords(String input) {
        // Corner case
        if (input == null || input.isEmpty()) {
            return input;
        }
        char[] array = input.toCharArray();
        // need to remove all heading ,trailing and duplicate space
        String aftDedup = deduplicateSpaces(array);
        char[] dedupedArray = aftDedup.toCharArray();
        reverse(dedupedArray, 0, dedupedArray.length - 1);
        int slow = 0;
        for (int i = 0; i < dedupedArray.length; i++) {
            if (dedupedArray[i] == ' ') {
                reverse(dedupedArray, slow, i - 1);
                slow = i + 1;
            }
        }
        reverse(dedupedArray, slow, dedupedArray.length - 1);
        return new String(dedupedArray);
    }

    public String deduplicateSpaces(char[] array) {
        int start = 0;
        while (start < array.length && array[start] == ' ') {
            start++;
        }
        if (start == array.length) {
            return "";
        }
        // Stop at a non-space point
        // Using fast and slow pointer
        int slow = start - 1;
        for (int fast = start; fast < array.length; fast++) {
            if (fast == start || array[fast] != ' ' || array[fast - 1] != ' ') {
                array[++slow] = array[fast];
            }
        }
        // check if the last is space
        if (array[slow] == ' ') {
            return new String(array, start, slow - start);
        } else {
            return new String(array, start, slow - start + 1);
        }
    }

    public void reverse(char[] array, int left, int right) {
        while (left < right) {
            swap(array, left, right);
            left++;
            right--;
        }
    }

    public void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
