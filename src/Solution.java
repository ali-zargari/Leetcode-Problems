import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public void moveZeroes(int[] nums) {


        int numZeroes = 0;
        for(int i = 0; i < nums.length; i++){

            if((i + numZeroes) == nums.length){
                return;
            }

            if(nums[i] == 0){
                numZeroes++;
                int j = i;
                while(j < nums.length-1){


                    if(nums[j+1] == 0){
                        j++;
                        continue;
                    }

                    System.out.println("Before: "+Arrays.toString(nums));


                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    j++;

                    System.out.println("After: "+Arrays.toString(nums));
                    System.out.println();
                }
                System.out.println();

                if(nums[i] == 0){
                    i--;
                }

            }

        }
    }

    /*
     * This is a better solution.
     * This solution first counts the number of zeros in the array, and then moves all the non-zero
     * elements to the front of the array. Finally, it fills the remaining positions at the end of
     * the array with zeros. This approach should work correctly regardless of the initial arrangement
     * of zeros in the array.
     */
    public void moveZeroes2(int[] nums) {
        int numZeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numZeros++;
            } else {
                nums[i - numZeros] = nums[i];
            }
        }
        for (int i = nums.length - numZeros; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 0, 7, 7, 7, 0, 5, 5, 0,1,0,0,12};
        solution.moveZeroes(nums);
        System.out.println("\n\n\n");
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
