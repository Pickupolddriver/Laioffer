package com.laioffer2022;

public class TotalOccurrence {
    public static void main(String[] args) {
        TotalOccurrence totalOccurrence = new TotalOccurrence();
        int[] array = {1, 1, 2, 2, 2, 3, 4};
        int res = totalOccurrence.totalOccurrence(array, 2);
        System.out.println(res);
    }

    public int totalOccurrence(int[] array, int target) {
        // Using binary search to find the first occurrence and last occurrence
        int firstOcc = firstOccurrence(array, target);
        if (firstOcc == -1) {
            return 0;
        }
        int lastOcc = lastOccurrence(array, target);
        return lastOcc - firstOcc + 1;
    }

    public int firstOccurrence(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                right = mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (array[left] == target) {
            return left;
        }
        if (array[right] == target) {
            return right;
        }
        return -1;
    }

    public int lastOccurrence(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                left = mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (array[right] == target) {
            return right;
        }
        if (array[left] == target) {
            return left;
        }
        return -1;
    }
}
