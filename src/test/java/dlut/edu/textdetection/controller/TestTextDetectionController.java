package dlut.edu.textdetection.controller;

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
        textDetectionController.textDetect("Hello Everyone");
    }


}
