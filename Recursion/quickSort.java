class Solution {

    private void swap(int[] nums, int a, int b) {

        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private int partition(int[] nums, int start, int end) {

        int position = start;

        for (int i = start; i <= end; i++) {

            if (nums[i] <= nums[end]) {
                swap(nums, i, position);
                position++;
            }
        }

        return position - 1;
    }

    private void quickSort(int[] nums, int start, int end) {

        if (start >= end) return;

        int pivotPosition = partition(nums, start, end);

        quickSort(nums, start, pivotPosition - 1);
        quickSort(nums, pivotPosition + 1, end);
    }

    public int[] sortArray(int[] nums) {

        quickSort(nums, 0, nums.length - 1);

        return nums;
    }
}
