package ar.gob.gcba.m4InspecAux.controller;

import javax.validation.constraints.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.gob.gcba.m4InspecAux.dto.Meta4ResponseInspec;
import ar.gob.gcba.m4InspecAux.service.InspecService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Controlador para consultar Reparticiones de empleados Meta4
 * 
 * @author Armando Guzman
 * @date 14/03/2019
 */
@Api(tags = "Inspec Meta4", description = "Servicios para consulta Inspec Meta4")
@RestController
@RequestMapping("/meta4")
@Validated
@CrossOrigin(origins = "*")
public class InspecMeta4Controller {

	private static final Logger LOGGER = LoggerFactory.getLogger(InspecMeta4Controller.class);

	@Autowired
	@Qualifier("inspecService")
	private InspecService inspecService;


	/*------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	/*------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	/**
	 * Obtiene Validación de Inspectores x DNI
	 * @param dni
	 * @return
	 * @throws Exception 
	 */
	@ApiOperation(value = "Validación de Inspectores x DNI", nickname = "validaInspector")
	@GetMapping(value = "/validaInspector/{dni}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Meta4ResponseInspec> getValidaInspector(@PathVariable("dni") @Pattern(regexp = "^\\d+$", message = "dni debe ser numérico") String cuil)
			throws Exception {
		Meta4ResponseInspec response = null;
		try {
			response = inspecService.callValidaInspec(cuil);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw e;
		}
		return new ResponseEntity<Meta4ResponseInspec>(response, HttpStatus.OK);
	}
	
	
}
