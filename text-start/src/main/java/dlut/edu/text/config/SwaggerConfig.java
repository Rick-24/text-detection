package dlut.edu.text.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/1/27 12:44
 */
@Configuration
public class SwaggerConfig {
    
    @Bean
    public Docket createRestApi() {
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameterBuilder.name("token").description("令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        parameters.add(parameterBuilder.build());
    
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameters);
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().build();
    }
}
