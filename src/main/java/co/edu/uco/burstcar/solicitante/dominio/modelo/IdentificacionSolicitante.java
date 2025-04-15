package co.edu.uco.burstcar.solicitante.dominio.modelo;

import co.edu.uco.burstcar.solicitante.dominio.validador.ValidadorDeAtibutos;
import java.util.UUID;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class IdentificacionSolicitante extends EntidadIdentificador{

    private String nombre;
    private String identificacionCategoriaId;

    private IdentificacionSolicitante(String nombre, String identificacionCategoriaId) {
        this.nombre = nombre;
        this.identificacionCategoriaId = identificacionCategoriaId;
    }

    public static IdentificacionSolicitante nuevaIdentificacionSolicitante(String nombre, String identificacionCategoriaId){
        ValidadorDeAtibutos.validarAtributosTexto(nombre, "nombre de la identificacion", 30);
        ValidadorDeAtibutos.validarAtributosTexto(identificacionCategoriaId, "Categoría de la identificación", 5);
        return new IdentificacionSolicitante(nombre, identificacionCategoriaId);
    }

    private IdentificacionSolicitante(UUID identificador, String nombre, String identificacionCategoriaId) {
        super(identificador);
        this.nombre = nombre;
        this.identificacionCategoriaId = identificacionCategoriaId;
    }

    public static IdentificacionSolicitante nuevaIdentificacionSolicitanteConIdentificador(UUID id, String nombre, String identificacionCategoriaId){
        ValidadorDeAtibutos.validarAtributosTexto(nombre, "nombre de la identificacion", 30);
        ValidadorDeAtibutos.validarAtributosTexto(identificacionCategoriaId, "Categoría de la identificación", 5);
        return new IdentificacionSolicitante(id, nombre, identificacionCategoriaId);
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacionCategoriaId() {
        return identificacionCategoriaId;
    }
}
