package com.sky.config;

import com.sky.interceptor.JwtTokenAdminInterceptor;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration class to register web layer components
 */
@Configuration
@Slf4j
public class WebMvcConfiguration implements WebMvcConfigurer {

    /**
     * The JwtTokenAdminInterceptor.
     */
    private final JwtTokenAdminInterceptor jwtTokenAdminInterceptor;

    /**
     * The constructor with specific parameters.
     *
     * @param jwtTokenAdminInterceptor the JwtTokenAdminInterceptor
     */
    public WebMvcConfiguration(final JwtTokenAdminInterceptor jwtTokenAdminInterceptor) {
        this.jwtTokenAdminInterceptor = jwtTokenAdminInterceptor;
    }

    /**
     * Register customer interception.
     *
     * @param registry the InterceptorRegistry
     */
    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        log.info("Add custom interceptor...");
        registry.addInterceptor(jwtTokenAdminInterceptor)
            .addPathPatterns("/admin/**")
            .excludePathPatterns("/admin/employee/login");
    }

    /**
     * Generate API documentation using Knife4j.
     *
     * @return The Docket.
     */
    @Bean
    public OpenAPI openAPI() {
        final Info apiInfo = new Info()
            .title("sky take out project interface document")
            .version("2.0")
            .description("sky take out project interface document");
        return new OpenAPI()
            .info(apiInfo)
            .addSecurityItem(new SecurityRequirement().addList("BearerAuth"))
            .components(new io.swagger.v3.oas.models.Components()
                .addSecuritySchemes("BearerAuth",
                    new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")
                        .name("Authorization")));
    }

    /**
     * Set static resource handlers.
     *
     * @param registry The ResourceHandlerRegistry.
     */
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/swagger-ui/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/swagger-ui/");
    }

//    /**
//     * Extend message converters.
//     *
//     * @param converters converters
//     */
//    @Override
//    public void extendMessageConverters(final List<HttpMessageConverter<?>> converters) {
//        log.info("Extend message converters");
//        // create a message converter
//        final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//
//        // set object mapper
//        converter.setObjectMapper(new JacksonObjectMapper());
//        converter.setSupportedMediaTypes(List.of(
//            new MediaType("application", "json"),
//            new MediaType("application", "*+json")
//        ));
//
//        // add converter
//        converters.add(0, converter);
//    }
}
