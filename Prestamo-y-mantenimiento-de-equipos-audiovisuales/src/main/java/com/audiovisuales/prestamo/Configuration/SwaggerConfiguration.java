package com.audiovisuales.prestamo.Configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
   @Bean
   public OpenAPI customOpenAPI() {
       return new OpenAPI()
               .info(new Info()
                       .title("MediaControl API")
                       .version("1.0.0")
                       .description("API REST para la gestión de equipos audiovisuales, préstamos y mantenimientos.")
                       .contact(new Contact()
                               .email("soporte@mediacontrol.com"))
                       .license(new License()
                               .name("Apache 2.0")
                               .url("https://www.apache.org/licenses/LICENSE-2.0")));
   }
}

