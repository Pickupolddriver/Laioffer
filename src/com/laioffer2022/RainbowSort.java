package com.laioffer2022;

public class RainbowSort {
    public static void main(String[] args) {
        RainbowSort rainbowSort = new RainbowSort();
        int[] array = {1,1,0,-1,0,1,-1};
        rainbowSort.rainbowSort(array);
        for (int x : array) {
            System.out.println(x);
        }

    }

    public int[] rainbowSort(int[] array) {
        // Corner case
        if (array == null || array.length <= 1) {
            return array;
        }
        int m1 = -1;
        int zero = -1;
        int one = array.length;
        int currIdx = 0;
        while (currIdx < one) {
            if (array[currIdx] == -1) {
                swap(array, currIdx, ++m1);
                zero++;
                currIdx++;
            } else if (array[currIdx] == 0) {
                swap(array, currIdx, ++zero);
                currIdx++;
            } else {
                // array[i]==1
                swap(array, currIdx, --one);
            }
        }
        return array;
    }

    public void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
