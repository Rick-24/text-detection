package dlut.edu.textdetection.test;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/19 12:16
 */
public class testRegex {
    @Test
    public void test(){
        String test = "中萨法维若覅12541发噶山豆根";
        String pattern = ".*\\d.*";
        boolean isMatch = Pattern.matches(pattern, test);
        System.out.println(isMatch);
    }
}
