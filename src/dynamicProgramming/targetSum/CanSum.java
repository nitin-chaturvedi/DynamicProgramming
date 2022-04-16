package dynamicProgramming.targetSum;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a function canSum(targetSum,numbers) which takes in a target Sum and an array of numbers as argument.
 *
 * The function should return boolean indicating weather or not it is possible to generate the target sum using
 * numbers from the array.
 *
 * You may use an element of array as many times as needed
 *
 * You may assume all input numbers are non negative
 */

public class CanSum {

  static boolean canSum(int targetSum, int[] numbers, Map<Integer, Boolean> memo){
    if(memo.containsKey(targetSum)) return memo.get(targetSum);
    if(targetSum<0) return false;
    if(targetSum==0) return true;

    for(int i=0; i<numbers.length;i++){
      int remainder = targetSum-numbers[i];
      if(canSum(remainder,numbers, memo)) {
        memo.put(targetSum,true);
        return true;
      }
    }
    memo.put(targetSum,false);
    return false;
  }

  public static void main(String args[]){
    System.out.println(canSum(7, new int[]{5, 3, 4, 7},new HashMap<Integer,Boolean>()));
    System.out.println(canSum(7, new int[]{2, 4}, new HashMap<Integer, Boolean>()));
    System.out.println(canSum(8, new int[]{5, 3, 4, 7}, new HashMap<Integer, Boolean>()));
    System.out.println(canSum(2, new int[]{5, 3, 4, 7}, new HashMap<Integer, Boolean>()));
    System.out.println(canSum(117, new int[]{5, 3, 4, 7}, new HashMap<Integer, Boolean>()));
    System.out.println(canSum(300, new int[]{7,14}, new HashMap<Integer, Boolean>()));
    System.out.println(canSum(777, new int[]{5, 3, 4, 7}, new HashMap<Integer, Boolean>()));
  }
}
