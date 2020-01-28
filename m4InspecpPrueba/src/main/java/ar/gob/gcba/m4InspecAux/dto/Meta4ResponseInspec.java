package ar.gob.gcba.m4InspecAux.dto;

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
@JsonRootName(value = "meta4ResponseInspec")
/**
 * DTO de respuesta a cliente para el caso en que la respuesta contenga en su cuerpo un elemento Json
 * @author Armando Guzman
 *
 */
public class Meta4ResponseInspec {
	
	@JsonProperty(value="----")
    private ValidaInspectorResponse validaInspectorResponse;
	@JsonProperty(value="error")
	@ApiModelProperty(position = 1, example = "error")
    private String error;
	@JsonProperty(value="detalle_error")
	@ApiModelProperty(position = 2, example = "detalle_error")
    private String detalleError;

}
