package com.example.Spring_Cloths.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        
        // Add JWT Security Scheme
        SecurityScheme securityScheme = new SecurityScheme();
        securityScheme.setType(SecurityScheme.Type.HTTP);
        securityScheme.setScheme("bearer");
        securityScheme.setBearerFormat("JWT");
        securityScheme.setDescription("Enter JWT token received from /auth/login endpoint");

        // Add security requirement to all endpoints
        SecurityRequirement securityRequirement = new SecurityRequirement();
        securityRequirement.addList("Bearer Authentication");

        Server httpsServer = new Server();
        httpsServer.setUrl("https://ulta.apsarallc.ggff.net");
        httpsServer.setDescription("Production HTTPS Server");

        return new OpenAPI()
                .info(new Info()
                        .title("Spring Clothes API")
                        .version("1.0")
                        .description("API with JWT Authentication"))
                .addServersItem(httpsServer)
                .addSecurityItem(securityRequirement)
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("Bearer Authentication", securityScheme));
    }
}

