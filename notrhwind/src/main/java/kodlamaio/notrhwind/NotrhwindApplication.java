package kodlamaio.notrhwind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2 //butun controllerimizi alıp apimizde adam gibi yapıyor.
public class NotrhwindApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotrhwindApplication.class, args);                                         
	    }
	@Bean //java classı dumduk class.
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("kodlamaio.notrhwind"))                                       
          .build();  
	}

}
