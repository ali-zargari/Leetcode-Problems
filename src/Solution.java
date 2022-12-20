import java.util.Arrays;

class Solution {
    public static void rotate(int[] nums, int k) {
        int [] copy = nums.clone();
        while(k > nums.length){
            k -= nums.length;
        }

        for(int i = 0; i < nums.length; i++){
            if(i+k < nums.length) {
                nums[i + k] = copy[i];
            } else {
                System.out.println(i+k);

                if((i+k) % nums.length == 0){
                    k -= nums.length;
                }
                nums[i + k] = copy[i];
            }
        }
    }


    /***
     * THERE IS A BETTER FUNCTION THAN THIS WITH SPACE COMPLEXITY O(1).
     * @param args
     */

    /*
     *
     * 1, 2, 3, 4, 5 | k=3
     *
     *
     */

    public static void main(String[] args) {
        int [] test = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(test, 7);
        System.out.println(Arrays.toString(test));
    }
}