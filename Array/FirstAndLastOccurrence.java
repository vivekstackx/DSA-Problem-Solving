
class Solution {

    // find the first and last occurance in array (using linearSearch)
    int[] getRange(int[] arr, int target) {
        int first = -1, last = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }
        return new int[] { first, last };
    }

    // function to get the first occurance in array
    int getFirstOccurance(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        int leftOcr = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                leftOcr = mid;
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return leftOcr;
    }

    // function to get the last occurance in array
    int getLastOccurance(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        int lastOcr = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                lastOcr = mid;
                start = mid + 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return lastOcr;
    }

    // find the first and last occurance in array (using binarySearch)
    int[] getRangeBinarySearch(int[] arr, int target) {
        int[] occurances = { -1, -1 };

        if (arr == null || arr.length == 0) {
            return occurances;
        }

        int firstOcr = getFirstOccurance(arr, target);
        if (firstOcr == -1) {
            return occurances;
        }
        int lastOcr = getLastOccurance(arr, target);

        occurances[0] = firstOcr;
        occurances[1] = lastOcr;
        return occurances;
    }

}

public class FirstAndLastOccurrence {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = { 5, 3, 2, 7, 3, 7, 8, 1, 9, 7, 22, 12 };

        int target1 = 7;

        int[] ans1 = obj.getRange(arr, target1);

        System.out.println("first occurance is : " + ans1[0]);
        System.out.println("last occurance is : " + ans1[1]);

        System.out.println("----------------");

        int[] sortedArr = { 2, 4, 8, 8, 8, 8, 8, 9, 12, 12, 13, 16, 18, 18, 19, 20, 22 };

        int target2 = 8;

        int[] ans2 = obj.getRangeBinarySearch(sortedArr, target2);

        System.out.println("first occurance is : " + ans2[0]);
        System.out.println("last occurance is : " + ans2[1]);

    }
}
