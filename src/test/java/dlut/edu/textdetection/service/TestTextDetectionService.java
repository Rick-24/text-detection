package dlut.edu.textdetection.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/10/19 21:40
 */
@SpringBootTest
public class TestTextDetectionService {
    @Autowired
    TextDetectionService textDetectionService;

    @Test
    void testProcess() {
        textDetectionService.process("abc");
    }

}
