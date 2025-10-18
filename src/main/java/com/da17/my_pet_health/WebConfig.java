package com.da17.my_pet_health;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
        public void addResourceHandlers(@NonNull ResourceHandlerRegistry registry) {
        // Serve team avatar images even if they are still under templates/about/avatar
        registry.addResourceHandler("/about/avatar/**")
                .addResourceLocations(
                        "classpath:/static/about/avatar/",
                        "classpath:/templates/about/avatar/");

        // Serve general images from both static/images and resources/images
        registry.addResourceHandler("/images/**")
                .addResourceLocations(
                        "classpath:/static/images/",
                        "classpath:/images/");

        // Serve about page css from static (preferred) and fallback to templates
        registry.addResourceHandler("/about/*.css")
                .addResourceLocations(
                        "classpath:/static/about/",
                        "classpath:/templates/about/");
    }
}
