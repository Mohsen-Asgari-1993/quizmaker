package ir.maktab25.quizmaker.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan
public class ThymeleafMvcConfig implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler(
                        "/static/**",
                        "/dist/**",
                        "/jquery/**",
                        "/other/**",
                        "/plugins/**",
                        "/jalali/**")
                .addResourceLocations(
                        "classpath:/static/dist/",
                        "classpath:/static/jquery/",
                        "classpath:/static/other/",
                        "classpath:/static/plugins/",
                        "classpath:/static/jalali/");
    }

}
