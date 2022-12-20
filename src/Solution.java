import java.util.HashSet;

public class Solution {
    //Uses a modified version of counting sort.
    //inefficient with high numbers.
    public static boolean containsDuplicate2(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i:nums){
            if(max < i){
                max = i;
            }

            if(min > i){
                min = i;
            }
        }

        int [] count = new int[max-min+1];

        for(int i = 0; i < nums.length; i++){
            count[nums[i]-min]++;
            if(count[nums[i]-min] == 2)
                return true;
        }


        return false;
    }

    //use a hashset
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i : nums){
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        System.out.println(set);

        return nums.length != set.size();
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,3,4, -2};
        System.out.println(containsDuplicate(nums));
    }
}