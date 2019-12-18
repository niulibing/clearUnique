package cn.commdata.cleardatabase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 Configuration
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    /**
     * swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     *
     * @return Docket
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("cn.commdata.cleardatabase.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
     *
     * @return ApiInfo
     */
    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                //页面标题
                .title("中通华数据软件技术有限公司成都分公司")
                //创建人
                .contact(new Contact("cncommdata", "http://www.cncommdata.cn", "dev@cncommdata.cn"))
                //版本号
                .version("0.0.1")
                //描述
                .description("清除数据库工程")
                .build();
    }

}
