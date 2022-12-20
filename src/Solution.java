import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.*;

import static java.util.Arrays.copyOfRange;

public class Solution {

    public static int removeDuplicates1(int @NotNull [] nums) {
        int count = 0;
        for(int i = 1; i < nums.length; i++){

            if(nums[i] == -999){
                break;
            }

            if(nums[i-1] == nums[i]){
                nums[i] = -999;

                int v = i;
                while(v < nums.length-1){
                    int temp = nums[v+1];
                    nums[v+1] = nums[v];
                    nums[v] = temp;
                    if(i > 0 && nums[v] == nums[i]){
                        i--;
                    }

                    v++;

                }

                count++;
            }
        }

        System.out.println(Arrays.toString(nums));

        return nums.length - count;
    }


    /***
     * When you need to remove duplicates from a collection of elements, use a hashset.
     * You can add all the elements to a HashSet and then retrieve the unique elements by iterating through the set.
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int [] nums) {

        Set<Integer> set = new HashSet<>();
        int index = 0;

        for (int num : nums) {
            if (set.add(num)) {
                nums[index++] = num;
            }
        }

        // Set the remaining elements to 0
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }


        return set.size();

    }

    public static void main(String[] args) {
        int [] x = {0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4};

        System.out.println(removeDuplicates2(x));


    }
}
