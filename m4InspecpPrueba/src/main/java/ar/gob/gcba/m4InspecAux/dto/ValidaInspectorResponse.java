package ar.gob.gcba.m4InspecAux.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonRootName(value = "validaInspector")
/**
 * Dto de respuesta a VALIDA_INSPECTOR  
 * @author Armando Guzman
 *
 */
public class ValidaInspectorResponse implements Serializable{

	private static final long serialVersionUID = 8359512983338908284L;
	@JsonProperty(value="INSPECTOR_VALIDO")
	@ApiModelProperty(position = 1, example = "inspector_valido")
	private String inspectorValido;
	@JsonProperty(value="AYN")
	@ApiModelProperty(position = 2, example = "ayn")
	private String ayn;
	@JsonProperty(value="COD_REP")
	@ApiModelProperty(position = 3, example = "cod_rep")
	private String codRep;
	@JsonProperty(value="DESC_REP")
	@ApiModelProperty(position = 4, example = "desc_rep")
	private String descRep;
	@JsonProperty(value="MENSAJE")
	@ApiModelProperty(position = 5, example = "mensaje")
	private String mensaje;
	

}