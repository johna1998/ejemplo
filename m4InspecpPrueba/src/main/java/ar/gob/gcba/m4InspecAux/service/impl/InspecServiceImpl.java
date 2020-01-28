package ar.gob.gcba.m4InspecAux.service.impl;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.gob.gcba.m4InspecAux.dto.Meta4ResponseInspec;
import ar.gob.gcba.m4InspecAux.exception.CallProcedureException;
import ar.gob.gcba.m4InspecAux.exception.Meta4ApiServiceException;
import ar.gob.gcba.m4InspecAux.repository.ProcedureInspecRepository;
import ar.gob.gcba.m4InspecAux.service.InspecService;

/**
 * Implementación de servicios llamadas a procedimientos Meta4 requerídos para evaluación de desempeño
 * @author Armando Guzman
 */
@Service(value = "inspecService")
public class InspecServiceImpl implements InspecService {

	private static final Logger LOGGER = LoggerFactory.getLogger(InspecServiceImpl.class);
	private static final String MENSAJE_ERROR_GENERICO = "Error en servicio ";
	
	@Autowired
	@Qualifier("procedureInspecRepository")
	private ProcedureInspecRepository procedureInspecRepository;
	
	/*----------------------------------------------------------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------------------------------------------------------*/
	/**
	 * Implementación de servicio validación de inspectores x dni
	 * Procedure: VALIDA_INSPECTOR
	 */
	@Override
	public Meta4ResponseInspec callValidaInspec(String dni) throws CallProcedureException, SQLException, Meta4ApiServiceException {
		
		Meta4ResponseInspec response= null;
		try {
			response = procedureInspecRepository.callValidaInspec(dni);
		} catch (CallProcedureException | SQLException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error("");
			throw new Meta4ApiServiceException(MENSAJE_ERROR_GENERICO,e);
		}
		return response;
	}
	
	
	
}