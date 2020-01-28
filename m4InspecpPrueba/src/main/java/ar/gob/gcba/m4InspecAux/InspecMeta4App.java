package ar.gob.gcba.m4InspecAux;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 
 * StarUp INSPECCIONES ServiceApp
 * @author Armando Guzman
 **/
@SpringBootApplication
public class InspecMeta4App {
	private static final Logger LOGGER = LoggerFactory.getLogger(InspecMeta4App.class);
	
	public static void main(String[] args) {
		SpringApplication.run(InspecMeta4App.class, args);
		LOGGER.info("m4-inspec-service INSPEC Application running...");
	}

}