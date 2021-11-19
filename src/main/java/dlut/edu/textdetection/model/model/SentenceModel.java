package dlut.edu.textdetection.model.model;

import dlut.edu.textdetection.model.model.spec.SentenceSpec;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/19 21:43
 */
@Data
public class SentenceModel {

    private String input;

    private int segmentNum;

    private int sentenceNum;

    private List<SentenceSpec> sentenceSpecList;

    public SentenceModel(String input, int segmentNum, int sentenceNum) {
        this.input = input;
        this.segmentNum = segmentNum;
        this.sentenceNum = sentenceNum;

        sentenceSpecList = new ArrayList<>();
    }
}
