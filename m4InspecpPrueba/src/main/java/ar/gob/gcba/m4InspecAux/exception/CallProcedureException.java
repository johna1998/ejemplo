package ar.gob.gcba.m4InspecAux.exception;

/**
 * Excepción estandarizada para capturar errores de invocación a store procedures Meta4  
 * @author Armando Guzman
 * @date 26/02/2019
 **/
public class CallProcedureException extends Exception{

	private static final long serialVersionUID = -7744819290928159603L;

	public CallProcedureException() {
		super();
	}
	
	public CallProcedureException(String message) {
		super(message);
	}
	
	public CallProcedureException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CallProcedureException(String message, Throwable cause, boolean enableSuppression,
                           boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
