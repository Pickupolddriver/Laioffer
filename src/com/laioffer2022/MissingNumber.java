package com.laioffer2022;

public class MissingNumber {
    // Find the missing number in sorted array
    // from 1-n in an n-1 array
    public static int missing(int[] nums) {
        // Corner case
        if (nums == null || nums.length == 0) {
            return 1;
        }
        if (nums[0] != 0) {
            return 0;
        }
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] != left) {
            return left;
        }
        return right;
    }

    public static void main(String[] args) {
        int[] array = {0,1,2,4};
        int res = missing(array);
        System.out.println(res);
    }
}
