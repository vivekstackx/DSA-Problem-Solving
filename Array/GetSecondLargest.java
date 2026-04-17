/*
  Example For testing...
  -> {10, 20, 30, 40, 50, 60,70, 80}
  -> {15, 10, 7, 9, 15, 14, 12, 8, 15}
*/
class Solution {

  // get the second largest element from array (using 2 loop)
  int getSecondMax(int[] arr) {

    if (arr == null || arr.length < 2) {
      return -1;
    }

    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;

    // step 1 find first largest element
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max1) {
        max1 = arr[i];
      }
    }

    // step 2 find second largest element
    for (int j = 0; j < arr.length; j++) {
      if (arr[j] != max1) {
        if (arr[j] > max2) {
          max2 = arr[j];
        }
      }
    }
    return max2;

  }

  // get the second largest element from array (using 1 loop)
  int getSecondMaxOptimized(int[] arr) {
    if (arr == null || arr.length < 2) {
      return -1; // no second largest element
    }

    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max1) {
        max2 = max1;
        max1 = arr[i];
      } else if (arr[i] > max2 && arr[i] != max1) {
        max2 = arr[i];
      }
    }

    return max2 == Integer.MIN_VALUE ? -1 : max2;
  }
}

public class GetSecondLargest {
  public static void main(String[] args) {
    Solution obj = new Solution();

    int[] arr = { 5, 10, 7, 9, 3, 11, 14, 8, 6 };

    System.out.println(obj.getSecondMax(arr));

    System.out.println("---------------");


    System.out.println(obj.getSecondMaxOptimized(arr));
  }
}
