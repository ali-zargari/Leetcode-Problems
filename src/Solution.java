import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList result = new ArrayList();

        for(int i : nums1){
            if(map.get(i) != null)
                map.put(i, map.get(i)+1);
            else
                map.put(i, 1);

        }

        for(int i : nums2){
            if(map.containsKey(i)){
                result.add(i);
                map.put(i, map.get(i)-1);
                if(map.get(i) == 0){
                    map.remove(i);
                }
            }
        }

        return result.stream().mapToInt(i->(int)i).toArray();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = new int[]{1,2,2,1,3};
        int[] nums2 = new int[]{2,2};
        int[] result = s.intersect(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}