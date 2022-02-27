package com.laioffer2022;

public class SmallestLargerThan {

  // Given a target integer T and an integer array A sorted in ascending order,
  // find the index of the smallest element in A that is larger than T
  // or return -1 if there is no such index.
  public int smallestElementLargerThanTarget(int[] array, int target) {
    // Write your solution here
    int left = 0;
    int right = array.length - 1;
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        left = mid + 1;
      } else if (array[mid] < target) {
        left = mid + 1;
      } else {
        // array[mid] > target
        right = mid;
      }
    }
    if (array[left] > target) {
      return left;
    }
    if (array[right] > target) {
      return right;
    }
    return -1;
  }
}
