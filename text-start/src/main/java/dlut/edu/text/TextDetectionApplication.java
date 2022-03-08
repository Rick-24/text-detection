package dlut.edu.text;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/21 12:43
 */
@EnableSwagger2
@SpringBootApplication
public class TextDetectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(TextDetectionApplication.class, args);
    }

}
