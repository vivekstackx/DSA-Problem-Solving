
class Solution {

  // delete element at ending position
  int deleteElementAtEnd(int[] arr, int size) {
    if (arr == null || size <= 0) {
      return size;
    }

    return size - 1;
  }

  // print array
  void printArray(int[] arr, int size) {
    for (int i = 0; i < size; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}

public class DeleteAtEnd {
  public static void main(String[] args) {
    Solution obj = new Solution();

    int capacity = 5;

    int[] arr = new int[capacity];

    int size = 4;

    arr[0] = 10;
    arr[1] = 20;
    arr[2] = 30;
    arr[3] = 40;

    System.out.println("Before deletion : ");
    obj.printArray(arr, size);

    size = obj.deleteElementAtEnd(arr, size);

    System.out.println("After deletion : ");
    obj.printArray(arr, size);
  }
}
