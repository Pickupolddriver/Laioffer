package com.laioffer2022;

public class CuttingRope {
    public static void main(String[] args) {
        CuttingRope cuttingRope = new CuttingRope();
        int res = cuttingRope.maxProduct(3);
        System.out.println(res);
    }

    public int maxProduct(int length) {
        // Corner case
        if (length <= 2) {
            return 1;
        }
        int[] maxCut = new int[length + 1];
        maxCut[1] = 1;
        maxCut[2] = 2;
        for (int i = 3; i < maxCut.length; i++) {
            // initialize by one cut
            maxCut[i] = i - 1;
            // Look back for i/2 step
            for (int j = i - 1; j >= i / 2; j--) {
                maxCut[i] = Math.max(maxCut[i], maxCut[i - j] * maxCut[j]);
                maxCut[i] = Math.max(maxCut[i], (i - j) * j);
            }
        }
        return maxCut[length];
    }
}
