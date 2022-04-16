package dynamicProgramming.targetSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Write a function howSum(targetSum, numbers) that takes in a targetSum and an array of numbers as arguments.
 *
 * This function should return an array containing any combination of elements that add up to exactly the targetSum.
 * If there is no combination that adds upto targetSum then return null.
 *
 * If there are multiple combination possible, you may return one of them.
 */

public class HowSum {

  static int[] howSum(int targetSum, int numbers[], Map<Integer, List<Integer>> memo){
    if(memo.containsKey(targetSum)) {
      List<Integer> l = memo.get(targetSum);
      return l!=null? l.stream().mapToInt(i ->i).toArray(): null;
    }
    if(targetSum<0) return null;// sum not possible in the current path
    if(targetSum==0) return new int[0];//sum possible

    for(int i=0; i<numbers.length;i++){
      int remainder = targetSum - numbers[i];
      int[] combination = howSum(remainder,numbers,memo);
      if(null != combination){
        int[] combinationNew = new int[combination.length+1];
        combinationNew[0] = numbers[i];
        System.arraycopy(combination,0,combinationNew,1,combination.length);
        memo.put(remainder,Arrays.stream(combinationNew).boxed().collect(Collectors.toList()));
        return combinationNew;
      }
    }

    memo.put(targetSum,null);
    return null;//sum not possible in all paths
  }

  public static void main(String args[]){
    System.out.println(Arrays.toString(howSum(7, new int[]{5, 4, 3, 7}, new HashMap<Integer, List<Integer>>())));
    System.out.println(Arrays.toString(howSum(7, new int[]{2, 4}, new HashMap<Integer, List<Integer>>())));
    System.out.println(Arrays.toString(howSum(8, new int[]{5, 3, 4, 7}, new HashMap<Integer, List<Integer>>())));
    System.out.println(Arrays.toString(howSum(2, new int[]{5, 3, 4, 7}, new HashMap<Integer, List<Integer>>())));
    System.out.println(Arrays.toString(howSum(117, new int[]{5, 3, 4, 7}, new HashMap<Integer, List<Integer>>())));
    System.out.println(Arrays.toString(howSum(300, new int[]{7, 14}, new HashMap<Integer, List<Integer>>())));
    System.out.println(Arrays.toString(howSum(777, new int[]{5, 3, 4, 7}, new HashMap<Integer, List<Integer>>())));
  }
}
