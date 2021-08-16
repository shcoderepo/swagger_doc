package com.tenable.swagger.doc.poc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;

@SpringBootApplication
public class SwaggerAnnotationPocApplication {
    public static void main(String[] args) {
        SpringApplication.run(SwaggerAnnotationPocApplication.class, args);
    }

    @Value("classpath:/user-example.json")
    private Resource userExample;

    @Value("classpath:/users-example.json")
    private Resource usersExample;

    @Value("classpath:/user-429-example.html")
    private Resource user429Example;

    public static String asString(Resource resource) {
        try (Reader reader = new InputStreamReader(resource.getInputStream())) {
            return FileCopyUtils.copyToString(reader);
        }
        catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
    @Bean
    public OpenAPI customOpenAPI(@Value("${application-description}") String appDescription,
                                 @Value("${application-version}") String appVersion,
                                  @Value("${application-title}") String appTitle) {
        return new OpenAPI().info(new Info().title(appTitle) .version(appVersion)
                        .description(appDescription).license(new License().name("Tenable.io")));
    }

    @Bean
    public OpenApiCustomiser openApiCustomiser(Collection<Map.Entry<String, Example>> examples) {
        return openAPI -> {
            examples.forEach(example -> {
                openAPI.getComponents().addExamples(example.getKey(), example.getValue());
            });
        };
    }

    @Bean
    public Map.Entry<String, Example> userExample() {
        Example userEx = new Example();
        Map.Entry<String, Example> entry = new AbstractMap.SimpleEntry("userExample", userEx);
        userEx.setValue(asString(userExample));
        return entry;
    }

    @Bean
    public Map.Entry<String, Example> usersExample() {
        Example usesrEx = new Example();
        Map.Entry<String, Example> entry = new AbstractMap.SimpleEntry("usersExample", usesrEx);
        usesrEx.setValue(asString(usersExample));
        return entry;
    }

    @Bean
    public Map.Entry<String, Example> user429Example() {
        Example user429Ex = new Example();
        Map.Entry<String, Example> entry = new AbstractMap.SimpleEntry("user429Example", user429Ex);
        user429Ex.setValue(asString(user429Example));
        return entry;
    }

}
