package com.crxl.qpp.comicdis.configuration;

import org.springframework.context.annotation.Configuration;
        import org.springframework.web.servlet.config.annotation.CorsRegistry;
        import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by myz on 2017/7/10.
 *
 * 设置跨域请求
 */
/*@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); // 1
        corsConfiguration.addAllowedHeader("*"); // 2
        corsConfiguration.addAllowedMethod("*"); // 3
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("*//**", buildConfig()); // 4
 return new CorsFilter(source);
 }
 }*/
@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600);
    }
}
