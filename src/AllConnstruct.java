import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a function allConstruct(target, wordBank) that accepts a target string and Array of strings.
 *
 * The function should return a 2D array containing all of the ways that the target can be constructed by concatenating
 * elements of the wordBank Array. Each element of 2D array should represent one combination that constructs the target.
 *
 * You may reuse elements of wordBank array as many times as needed.
 */

public class AllConnstruct {
  static String [][] allConstruct(String target, String wordBank[], Map<String, String[][] > memo){
    if(memo.containsKey(target)) return memo.get(target);
    if("".equals(target)) return new String[1][0];

    String [][] allCombinations = new String[0][];
    for(String word: wordBank){
      if(target.startsWith(word)){
        String suffix = target.substring(word.length());
        String [][] allCombinationNew = allConstruct(suffix,wordBank,memo);
//        System.out.println(Arrays.deepToString(allCombination));
        if(null != allCombinationNew && allCombinationNew.length>0){
          //add to array and return
          String retNew[][] = new String[allCombinationNew.length+ allCombinations.length][];
          for(int i=0; i< allCombinationNew.length; i++){
            String temp[] = new String[allCombinationNew[i].length+1];
            temp[0] = word;
            System.arraycopy(allCombinationNew[i],0,temp,1,allCombinationNew[i].length);
            retNew[i]=temp;
          }
          //replicate the branch/previous solution
          for(int i=0; i< allCombinations.length; i++){
            String temp[] = new String[allCombinations[i].length];
            System.arraycopy(allCombinations[i],0,temp,0,allCombinations[i].length);
            retNew[i+allCombinationNew.length]=temp;
          }
          allCombinations = retNew;
        }
      }
    }

    memo.put(target,allCombinations);
    return  allCombinations;
  }


  public static void main(String args[]){
    System.out.println(Arrays.deepToString(allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<String, String[][]>())));
    System.out.println(Arrays.deepToString(allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef"}, new HashMap<String, String[][]>())));
    System.out.println(Arrays.deepToString(allConstruct("aaaaaaaaaaaaaaaaaaaaaaaaaaaf", new String[]{"a","aa","aaa","aaaa","aaaaa"}, new HashMap<String, String[][]>())));
  }
}
