package ar.gob.gcba.m4InspecAux.exception;

/**
 * Excepción estandarizada para capturar errores en servicios de invocación repositorios Meta4  
 * @author Armando Guzman
 * @date 26/02/2019
 **/
public class Meta4ApiServiceException extends Exception{

	private static final long serialVersionUID = -7744819290928159603L;

	public Meta4ApiServiceException() {
		super();
	}
	
	public Meta4ApiServiceException(String message) {
		super(message);
	}
	
	public Meta4ApiServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public Meta4ApiServiceException(String message, Throwable cause, boolean enableSuppression,
                           boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
