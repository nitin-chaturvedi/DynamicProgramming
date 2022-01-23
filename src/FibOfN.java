import java.util.HashMap;
import java.util.Map;

/**
 * Write a function fib(n) that takes in a number n and returns nth nnumber of fibonacci series
 * 1st and 2nd number is 1 to gernerate next 2 sum previous 2
 */

public class FibOfN {

  static long fib(long n, Map<Long,Long> memo){
    if(memo.containsKey(n)) return memo.get(n);
    if(n<=2) return 1;

    memo.put(n,fib(n-1,memo)+fib(n-2,memo));
    return memo.get(n);
  }

  public static void main(String args[]){
    System.out.println(fib(1,new HashMap<Long,Long>()));
    System.out.println(fib(2,new HashMap<Long,Long>()));
    System.out.println(fib(3,new HashMap<Long,Long>()));
    System.out.println(fib(4,new HashMap<Long,Long>()));

    System.out.println(fib(50,new HashMap<Long,Long>()));

  }

}
