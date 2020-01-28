package ar.gob.gcba.m4InspecAux.service;

import java.sql.SQLException;

import ar.gob.gcba.m4InspecAux.dto.Meta4ResponseInspec;
import ar.gob.gcba.m4InspecAux.exception.CallProcedureException;
import ar.gob.gcba.m4InspecAux.exception.Meta4ApiServiceException;

/**
 * Servicios de llamadas a procedimientos PROMHOR Meta4
 * @author Alejandro Atela
 *
 */
public interface InspecService {
	
     /*---------------------------------------------------------------------------------------------------*/
	 /*---------------------------------------------------------------------------------------------------*/
	 /**
	 * @param dni
	 * @return
	 * @throws Meta4ApiServiceException
	 * @throws CallProcedureException
	 * @throws SQLException
	 */
	 public Meta4ResponseInspec callValidaInspec(String dni) throws Meta4ApiServiceException, CallProcedureException, SQLException;
}