package io.github.luanelioliveira.library.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

  @Bean
  public OpenAPI customOpenAPI(
      @Value("${spring.application.description}") String appDescription,
      @Value("${spring.application.version}") String appVersion) {
    return new OpenAPI()
        .components(new Components())
        .info(
            new Info()
                .title("Library API")
                .description(appDescription)
                .version(appVersion)
                .license(new License().name("Apache 2.0").url("https://springdoc.org")));
  }
}
