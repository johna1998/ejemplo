
package ar.gob.gcba.m4InspecAux.reparticionDto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "cuil",
    "nombre",
    "apellido",
    "password",
    "correo",
    "bloqueado",
    "fecha_modificacion_password",
    "roles",
    "reparticiones"
})
@Getter
@Setter
@NoArgsConstructor
public class UsuarioValidador {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("cuil")
    public String cuil;
    @JsonProperty("nombre")
    public String nombre;
    @JsonProperty("apellido")
    public String apellido;
    @JsonProperty("password")
    public String password;
    @JsonProperty("correo")
    public Object correo;
    @JsonProperty("bloqueado")
    public Boolean bloqueado;
    @JsonProperty("fecha_modificacion_password")
    public Object fechaModificacionPassword;
    @JsonProperty("roles")
    public List<Object> roles = null;
    @JsonProperty("reparticiones")
    public List<Object> reparticiones = null;

}
