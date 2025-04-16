package co.edu.uco.burstcar.solicitante.dominio.testdatabuilder.modelo;

import co.edu.uco.burstcar.solicitante.dominio.modelo.IdentificacionSolicitante;
import co.edu.uco.burstcar.solicitante.dominio.modelo.Solicitante;

public class SolicitanteTestDataBuilder {
    private String numeroIdentificacion;
    private String nombre;
    private String usuario;
    private String contrasena;
    private Long numeroTelefonico;
    private IdentificacionSolicitante identificacionSolicitante;

    public SolicitanteTestDataBuilder byDefault() {
        this.numeroIdentificacion = "123456789";
        this.nombre = "Prueba";
        this.usuario = "usuario1";
        this.contrasena = "password";
        this.numeroTelefonico = 43575248723L;
        this.identificacionSolicitante = new IdentificacionSolicitanteTestDataBuilder().byDefault().build();
        return this;
    }


    public SolicitanteTestDataBuilder conNumeroIdentificaion(String id){
        this.numeroIdentificacion = id;
        return this;
    }

    public SolicitanteTestDataBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    public SolicitanteTestDataBuilder conUsuario(String usuario){
        this.usuario = usuario;
        return this;
    }

    public SolicitanteTestDataBuilder conContrasena(String contrasena){
        this.contrasena = contrasena;
        return this;
    }

    public SolicitanteTestDataBuilder conNumeroTelefonico(Long numeroTelefonico){
        this.numeroTelefonico = numeroTelefonico;
        return this;
    }

    public SolicitanteTestDataBuilder conIdentificacionSolicitante(IdentificacionSolicitante identificacionSolicitante){
        this.identificacionSolicitante = identificacionSolicitante;
        return this;
    }

    public Solicitante build() {
        return Solicitante.nuevoSolicitante(numeroIdentificacion,
                nombre, usuario,contrasena, numeroTelefonico, identificacionSolicitante);
    }
}
