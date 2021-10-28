package dlut.edu.textdetection.controller;

import dlut.edu.textdetection.model.model.result.DetectionResultDTO;
import dlut.edu.textdetection.model.result.InvokeResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/10/19 21:41
 */
@SpringBootTest
public class TestTextDetectionController {
    @Autowired
    TextDetectionController textDetectionController;

    @Test
    public void testTextDetect(){
        InvokeResult<DetectionResultDTO> hello_everyone = textDetectionController.textDetect("Hello Everyone");
        DetectionResultDTO value = hello_everyone.getValue();
        System.out.println(value);
    }


}
