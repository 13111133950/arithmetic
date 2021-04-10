package day01;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TwoSum
 * @Author Kurisu
 * @Description
 * @Date 2021-2-23 19:01
 * @Version 1.0
 **/
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.get(target - nums[i])!=null){
                return new int[]{i,map.get(target - nums[i])};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};

        int[] twoSum = twoSum(nums, 6);
        for (int i = 0; i < twoSum.length; i++) {
            System.out.println(twoSum[i]);

        }
    }
}
