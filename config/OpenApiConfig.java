@Configuration
public class OpenApiConfig {
 @Bean
 public OpenAPI customAPI(){
   return new OpenAPI()
   .components(new Components().addSecuritySchemes("bearerAuth", 
     new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
   .info(new Info().title("Banking Portal API").version("1.0"));
 }
}
