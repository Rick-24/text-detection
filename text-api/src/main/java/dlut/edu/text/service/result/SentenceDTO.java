package dlut.edu.text.service.result;

import dlut.edu.text.service.result.spec.SentenceSpec;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/1/6 12:23
 */
@Data
public class SentenceDTO <T>{
    private String input;
    
    private Integer segmentNum;
    
    private Integer sentenceNum;
    
    private List<T> sentenceSpecList;
    
    public SentenceDTO(String input, int segmentNum, int sentenceNum) {
        this.input = input;
        this.segmentNum = segmentNum;
        this.sentenceNum = sentenceNum;
        sentenceSpecList = new ArrayList<T>();
    }
}
