import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import jdk.jfr.Description;

public class AllConstructTest {

  @Test
  @Description("sucess test")
  public void allConstructTest1(){
    String resp[][] = AllConnstruct.allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<String, String[][]>());
    Assert.assertNotNull(resp);
    Assert.assertArrayEquals(new String[][]{{"abc","def"}},resp);
  }

  @Test
  public void allConstructTest2(){
    String resp[][] = AllConnstruct.allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef"}, new HashMap<String, String[][]>());
    Assert.assertNotNull(resp);
    //[[abcd, ef], [abc, def], [ab, cd, ef]]
    Assert.assertArrayEquals(new String[][]{{"abcd", "ef"}, {"abc", "def"}, {"ab", "cd", "ef"}},resp);

  }
}
