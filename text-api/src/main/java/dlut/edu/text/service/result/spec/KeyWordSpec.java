package dlut.edu.text.service.result.spec;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/1/6 12:31
 */
@Data
@AllArgsConstructor
public class KeyWordSpec {
    String keyWord;
    List<Integer> startIndex;
}