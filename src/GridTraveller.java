import java.util.HashMap;
import java.util.Map;

/**
 * Say that you are traveller on a 2d grid. You begin at top left corner and your goal is to reach bottom right corner.
 * Yoo may only move right or down
 *
 * In how many ways can you travel to the goal on a grid with dimension m * n?
 *
 * Write a function gridTraveller(m,n) to calculate this
 */

public class GridTraveller {
  static long gridTraveller(int m, int n, Map<String,Long> memo){
    String key = m+"_"+n;
    if(memo.containsKey(key))return memo.get(key);
    if(m==0 || n==0) return 0;
    if(m==1 && n==1) return 1;

    memo.put(key,gridTraveller(m-1,n,memo) + gridTraveller(m,n-1,memo));
    return memo.get(key);
  }

  public static void main(String args[]){
    System.out.println(gridTraveller(0,1,new HashMap<String,Long>()));
    System.out.println(gridTraveller(1,0,new HashMap<String,Long>()));
    System.out.println(gridTraveller(1,1,new HashMap<String,Long>()));
    System.out.println(gridTraveller(3,1,new HashMap<String,Long>()));
    System.out.println(gridTraveller(1,3,new HashMap<String,Long>()));
    System.out.println(gridTraveller(2,3,new HashMap<String,Long>()));
    System.out.println(gridTraveller(3,2,new HashMap<String,Long>()));
    System.out.println(gridTraveller(3,3,new HashMap<String,Long>()));

    System.out.println(gridTraveller(18,18,new HashMap<String,Long>()));

  }

}
