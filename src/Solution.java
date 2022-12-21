import java.util.Arrays;

public class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            if(digits[i] + 1 > 9){
                digits[i] = 0;
                int j = i-1;
                if(j < 0){
                    return new int[]{1, 0};
                }

                digits[j]++;
                while(digits[j] > 9){
                    digits[j] = 0;
                    j--;
                    if(j == -1){
                        int [] newDigits = new int[digits.length+1];
                        newDigits[0] = 1;
                        for (int k = 1; k < newDigits.length; k++) {
                            newDigits[k] = digits[k-1];
                        }
                        return newDigits;
                    }
                    digits[j]++;
                }
                return digits;

            } else {
                digits[digits.length-1]++;
                return digits;
            }

        }

        return new int[]{1};


    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] digits = {1};
        System.out.println(Arrays.toString(s.plusOne(digits)));
    }
}