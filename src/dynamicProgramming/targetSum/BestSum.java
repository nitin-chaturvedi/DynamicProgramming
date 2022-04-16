package dynamicProgramming.targetSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Write a function bestSum(targetSum,numbers) that takes in a targetSum and an array of numbers as input.
 *
 *The array should contain shortest combination of numbers that add upto exactly the target sum.
 *
 * If there is a tie for the shortest combination, you may return any of the shortest.
 */

public class BestSum {

  static int[] bestSum(int targetSum, int numbers[], Map<Integer,int []> memo){
    if(memo.containsKey(targetSum)) return memo.get(targetSum);
    if(targetSum<0) return null;
    if(targetSum==0) return new int[0];

    int shortestCombination[] = null;
    for(int i=0; i<numbers.length; i++){
      int remainder = targetSum - numbers[i];
      int combination[] = bestSum(remainder,numbers,memo);
      if(combination!=null) {
        int combinationNew[] = new int[combination.length + 1];
        combinationNew[0] = numbers[i];
        System.arraycopy(combination, 0, combinationNew, 1, combination.length);
        if (shortestCombination == null || combinationNew.length <= shortestCombination.length) {
          shortestCombination = combinationNew;
        }
      }
    }

    memo.put(targetSum,shortestCombination);
    return shortestCombination;
  }

  public static void main(String args[]){
    System.out.println(Arrays.toString(bestSum(7, new int[]{5, 4, 3, 7}, new HashMap<Integer, int []>())));
    System.out.println(Arrays.toString(bestSum(7, new int[]{5, 4, 3, 7}, new HashMap<Integer, int []>())));
    System.out.println(Arrays.toString(bestSum(7, new int[]{2, 4}, new HashMap<Integer, int []>())));
    System.out.println(Arrays.toString(bestSum(8, new int[]{5, 3, 4, 7}, new HashMap<Integer, int []>())));
    System.out.println(Arrays.toString(bestSum(2, new int[]{5, 3, 4, 7}, new HashMap<Integer, int []>())));
    System.out.println(Arrays.toString(bestSum(117, new int[]{5, 3, 4, 7}, new HashMap<Integer, int []>())));
    System.out.println(Arrays.toString(bestSum(300, new int[]{7, 14}, new HashMap<Integer, int []>())));
    System.out.println(Arrays.toString(bestSum(777, new int[]{5, 3, 4, 7}, new HashMap<Integer, int []>())));
  }
}
