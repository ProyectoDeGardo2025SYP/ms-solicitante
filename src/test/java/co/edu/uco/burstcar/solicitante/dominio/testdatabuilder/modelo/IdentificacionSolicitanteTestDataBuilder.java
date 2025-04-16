package co.edu.uco.burstcar.solicitante.dominio.testdatabuilder.modelo;

import co.edu.uco.burstcar.solicitante.dominio.modelo.IdentificacionSolicitante;
public class IdentificacionSolicitanteTestDataBuilder {
    private String nombre;
    private String identificacionCategoriaId;

    public IdentificacionSolicitanteTestDataBuilder byDefault() {
        this.nombre = "Cedula";
        this.identificacionCategoriaId = "C.C";
        return this;
    }

    public IdentificacionSolicitanteTestDataBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    public IdentificacionSolicitanteTestDataBuilder conIdentificacionCategoriaId(String identificacionCategoriaId){
        this.identificacionCategoriaId = identificacionCategoriaId;
        return this;
    }


    public IdentificacionSolicitante build() {
        return IdentificacionSolicitante.nuevaIdentificacionSolicitante(nombre, identificacionCategoriaId);
    }
}
