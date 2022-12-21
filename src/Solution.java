import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Build a map of the elements in the array and their counts
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // Iterate over the indices of the array
        for (int i = 0; i < nums.length; i++) {
            // Check if the element at index i can be paired with another element to sum to the target
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                //find the index of the complement
                return new int[]{i, map.get(complement)};
            }
        }

        return null;
    }





    public static void main(String[] args) {

        //run and calculate runtime and print
        long startTime = System.nanoTime();
        int [] nums = {3, 2, 3};
        int target = 6;
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.twoSum(nums, target)));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration);

    }
}
