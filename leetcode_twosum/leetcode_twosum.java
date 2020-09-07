import java.util.*;

class Solution {
    int[] answer = new int[2];
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            if(!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                answer[0] = map.get(target - nums[i]);
                answer[1] = i;
            }
        }
        return answer;
    }
}