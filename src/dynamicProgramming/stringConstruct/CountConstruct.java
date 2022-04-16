package dynamicProgramming.stringConstruct;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a function 'countConstruct(target, wordBank)' that accepts a target string and an array of strings.
 *
 * The function should return the number of ways that the target can be constructed by concatenating elements of wordBank array.
 *
 * You may reuse elements of wordBank as many times as needed.
 */

public class CountConstruct {

   static long countConstruct(String target, String wordBank[], Map<String ,Long> memo){
    if(memo.containsKey(target)) return memo.get(target);
    if("".equals(target)) return 1;

    long count =0;
    for (String word : wordBank){
      if(target.startsWith(word)){
        String suffix = target.substring(word.length(),target.length());
        count += countConstruct(suffix,wordBank,memo);
      }
    }

    memo.put(target, count);
    return count;
  }

  public static void main(String args[]){
    System.out.println(countConstruct("abcdef", new String[]{"ab","abc","cd","def","abcd"}, new HashMap<String, Long>()));
    System.out.println(countConstruct("abcdef", new String[]{"ab","abc","cd","def","abcd","ef"}, new HashMap<String, Long>()));
    System.out.println(countConstruct("aaaaaaaaaaaaaaaaaaaaaaaaaaaf", new String[]{"a","aa","aaa","aaaa","aaaaa"}, new HashMap<String, Long>()));
  }
}
