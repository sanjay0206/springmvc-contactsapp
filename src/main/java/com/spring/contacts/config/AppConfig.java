package com.spring.contacts.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.spring.contacts")
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://127.0.0.1:5500")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                //  These headers can be included in the actual request from the client.
                .allowedHeaders(HttpHeaders.AUTHORIZATION, HttpHeaders.COOKIE, HttpHeaders.CONTENT_TYPE,  HttpHeaders.ACCEPT)
                // These headers will be exposed to the client in the response.
                .exposedHeaders(HttpHeaders.AUTHORIZATION,  HttpHeaders.COOKIE, HttpHeaders.CONTENT_TYPE, HttpHeaders.LOCATION);
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON); // Set default content type
        configurer.favorPathExtension(true); // Enable content negotiation based on file extensions
        configurer.mediaType("xml", MediaType.APPLICATION_XML); // Define media type for XML
        configurer.mediaType("json", MediaType.APPLICATION_JSON); // Define media type for JSON
    }
}