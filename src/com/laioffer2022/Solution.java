package com.laioffer2022;

public class Solution {
    public int minJump(int[] array) {
        // Corner case
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] canJump = new int[array.length];
        for (int i = 1; i < canJump.length; i++) {
            canJump[i] = -1;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (canJump[i] == -1) {
                return -1;
            }
            if (i + array[i] >= array.length - 1) {
                return canJump[i] + 1;
            }
            for (int j = i; j <= i + array[i]; j++) {
                if (canJump[j] == -1) {
                    canJump[j] = canJump[i] + 1;
                } else {
                    canJump[j] = Math.min(canJump[j], canJump[i] + 1);
                }

            }
        }
        return canJump[array.length - 1];
    }
}
