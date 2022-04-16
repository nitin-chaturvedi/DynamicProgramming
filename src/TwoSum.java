/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target
 */

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class TwoSum {
  public int[] twoSum(int[] nums, int target) {

    return calcTwoSum(
      nums,target,2,new HashMap());

  }

  private int[] calcTwoSum(int[] nums, int target, int loop,Map<Integer,Integer> memo){
    if(target<0 || loop<=0 || nums.length == 0)
      return null;
    if(target == 0)
      return new int[0];
    int num = nums[0];
    int remainder[] = calcTwoSum(Arrays.copyOfRange(nums,1,nums.length),target-num,loop--,memo);

    if(remainder != null){
      int newR[] = new int[remainder.length+1];
      newR[0]=num;
      System.arraycopy(remainder,0,newR,1,remainder.length);
      remainder = newR;
    }
    return remainder;
  }
}

//class Solution1 {
//  public int[] twoSum(int[] nums, int target) {
//    Map<Integer,Integer> num1 = new HashMap<Integer,Integer>();
//    for(int i=0;i<nums.length;i++){
//      int compliment=Math.abs(nums[i]-target);
//      if(num1.containsKey(compliment)){
//        return new int[]{i,num1.get(compliment)};
//      }
//      num1.put(nums[i],i);
//    }
//    return null;
//  }
//
//}

