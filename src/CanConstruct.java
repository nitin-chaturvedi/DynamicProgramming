import java.util.HashMap;
import java.util.Map;

/**
 * Write a function canConstruct(target, wordBank) that accepts a target string and an array of strings.
 *
 * The function should return a boolean indicating weather or not the 'target' can be constructed by concatenating
 *  elements of the 'wordBank' array.
 *
 *  You may reuse elements of 'wordBank' as many times as needed
 */

public class CanConstruct {

  static boolean canConstruct(String target, String wordBank[], Map<String, Boolean> memo){
    if(memo.containsKey(target)) return memo.get(target);
    if("".equalsIgnoreCase(target)) return true;

    for (String word : wordBank){
      if(target.startsWith(word)){
        String suffix = target.substring(word.length(),target.length());
        if(canConstruct(suffix,wordBank, memo)==true) {
          memo.put(target,true);
          return true;
        }
      }

    }

    memo.put(target,false);
    return false;
  }

  public static void main(String args[]){

    System.out.println(canConstruct("abcdef", new String[]{"ab","abc","cd","def","abcd"},new HashMap<String, Boolean>()));
    System.out.println(canConstruct("aaaaaaaaaaaaaaaaaaaaaaf", new String[]{"a","aa","aaa","aaaa","aaaaa"},new HashMap<String, Boolean>()));
  }
}
