package com.bank.portal.config;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(name="bearerAuth", type=SecuritySchemeType.HTTP, scheme="bearer", bearerFormat="JWT")
public class OpenApiConfig {
    @Bean public OpenAPI customAPI(){
        return new OpenAPI().info(new Info().title("Enterprise Banking Portal API").version("1.0").description("Fullstack Banking API with JWT"))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
    }
}
