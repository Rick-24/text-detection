package dlut.edu.text.service.result;

import dlut.edu.text.service.result.model.DetectionModel;
import dlut.edu.text.service.result.model.SentenceModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/10/28 13:47
 */
@Data
public class DetectionResultDTO {
    @Deprecated
    private List<DetectionModel> provinceModel;
    @Deprecated
    private List<DetectionModel> cityModel;
    @Deprecated
    private List<DetectionModel> districtModel;

    private List<SentenceModel> sentenceModel;

    public DetectionResultDTO(){
        provinceModel = new ArrayList<>();
        cityModel = new ArrayList<>();
        districtModel = new ArrayList<>();
        sentenceModel = new ArrayList<>();
    }
}