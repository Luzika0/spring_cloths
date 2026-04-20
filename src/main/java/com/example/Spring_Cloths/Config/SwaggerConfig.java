package com.example.Spring_Cloths.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        Server httpsServer = new Server();
        httpsServer.setUrl("https://ulta.apsarallc.ggff.net");
        httpsServer.setDescription("Production HTTPS Server");

        return new OpenAPI()
                .addServersItem(httpsServer);
    }
}
