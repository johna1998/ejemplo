package ar.gob.gcba.m4InspecAux.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Interface swagger example meta 4 service api 
 * @author Alejandro
 * @date 19/07/2019
 **/
@Configuration
@EnableSwagger2
@Import(springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class)
public class InspecMeta4Swagger {
	
	
	/**
	 * Get docket instance to display the rest api documentation
	 * @return
	 */
	@Bean
	public Docket api() {
	 return new Docket(DocumentationType.SWAGGER_2)          
		      .select()                                       
		      .apis(RequestHandlerSelectors.basePackage("ar.gob.gcba.m4InspecAux.controller"))
		      .paths(PathSelectors.any())                     
		      .build()
		      .apiInfo(this.AdminCoreMetaData());
	}
	
	/**
	 * Get dgisi archetype info for the swagger interface
	 * @return
	 */
	private ApiInfo AdminCoreMetaData() {
        ApiInfo apiInfo = new ApiInfo(
                "INSPEC Meta4: Spring Boot REST API",
                "INSPEC Meta4 service api Restful",
                "1.0",
                "Terms of service",
                new Contact("ASI Systems Development", "https://asijira-confluence.buenosaires.gob.ar/dashboard.action", "aatella@buenosaires.gob.ar"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
        return apiInfo;
    }

}