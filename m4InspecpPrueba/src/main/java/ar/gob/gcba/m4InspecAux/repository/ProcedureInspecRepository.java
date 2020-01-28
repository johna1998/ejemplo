package ar.gob.gcba.m4InspecAux.repository;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import ar.gob.gcba.m4InspecAux.dto.Meta4ResponseInspec;
import ar.gob.gcba.m4InspecAux.dto.ValidaInspectorResponse;
import ar.gob.gcba.m4InspecAux.exception.CallProcedureException;

/**
 * DAO de acceso a datos de servicios procedimientos META4 
 * @author Alejandro Atela
 *
 */
@Repository(value = "procedureInspecRepository")
public class ProcedureInspecRepository {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProcedureInspecRepository.class);
	
	
	private static final String P_DNI = "P_DNI";
	private static final String P_INSPECTOR_VALIDO = "P_INSPECTOR_VALIDO";
	private static final String P_AYN = "P_AYN";
	private static final String P_COD_REP = "P_COD_REP";
	private static final String P_DESC_REP = "P_DESC_REP";
	private static final String P_MENSAJE = "P_MENSAJE";
    private static final String MENSAJE_ERROR = "Error llamando a procedimiento ";
	private static final String P_ERROR ="P_ERROR";
	private static final String P_DETALLE_ERROR ="P_DETALLE_ERROR";
	
	
	

	@Autowired
	EntityManager entityManager;
	
	@Value(value="${meta4.evaldesem.dbPackage}")//propiedad cargado por archivo application.properties
	private String dbPackage;
	


	/*---------------------------------------------------------------------------------------------------------------------------*/
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	
	/**
	 * Llamada procedimiento VALIDA_INSPECTOR por DNI
	 * @param dni
	 * @return
	 * @throws SQLException
	 * @throws CallProcedureException 
	 */
	public Meta4ResponseInspec callValidaInspec(String dni) throws SQLException, CallProcedureException {

		Meta4ResponseInspec build = null;
		try {
			StoredProcedureQuery proc = entityManager.createStoredProcedureQuery(dbPackage+ ".VALIDA_INSPECTOR");
			proc.registerStoredProcedureParameter(P_DNI, String.class, ParameterMode.IN);
			proc.registerStoredProcedureParameter(P_INSPECTOR_VALIDO, String.class, ParameterMode.OUT);
			proc.registerStoredProcedureParameter(P_AYN, String.class, ParameterMode.OUT);
			proc.registerStoredProcedureParameter(P_COD_REP, String.class, ParameterMode.OUT);
			proc.registerStoredProcedureParameter(P_DESC_REP, String.class, ParameterMode.OUT);
			proc.registerStoredProcedureParameter(P_MENSAJE, String.class, ParameterMode.OUT);
			proc.registerStoredProcedureParameter(P_ERROR, String.class, ParameterMode.OUT);
			proc.registerStoredProcedureParameter(P_DETALLE_ERROR, String.class, ParameterMode.OUT);

			proc.setParameter(P_DNI, dni);

			ValidaInspectorResponse validaInspectorResponse = new ValidaInspectorResponse();
			validaInspectorResponse.setAyn((String) proc.getOutputParameterValue(P_AYN));
			validaInspectorResponse.setInspectorValido((String) proc.getOutputParameterValue(P_INSPECTOR_VALIDO));
			validaInspectorResponse.setMensaje((String) proc.getOutputParameterValue(P_MENSAJE));
			validaInspectorResponse.setDescRep((String) proc.getOutputParameterValue(P_DESC_REP));
			validaInspectorResponse.setCodRep((String) proc.getOutputParameterValue(P_COD_REP));

			build = Meta4ResponseInspec.builder().error((String) proc.getOutputParameterValue(P_ERROR))
					.detalleError((String) proc.getOutputParameterValue(P_DETALLE_ERROR)).build();
			build.setValidaInspectorResponse(validaInspectorResponse);
	
		} catch (Exception e) {
			LOGGER.error(MENSAJE_ERROR + "validando inspector por DNI", e);
			throw new CallProcedureException(MENSAJE_ERROR +"VALIDO_INSPECTOR : validando inspector por DNI " + e.getMessage());
		}
		return build;
	}
	
}


