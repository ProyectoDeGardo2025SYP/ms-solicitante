package co.edu.uco.burstcar.solicitante.infraestructura.controlador.solicitante.comando.model;

import co.edu.uco.burstcar.solicitante.aplicacion.casodeuso.solicitante.comando.dto.SolicitanteDto;

public class ComandoSolicitanteTestDataBuilder {
    private String numeroIdentificacion;
    private String nombre;
    private String usuario;
    private String contrasena;
    private Long numeroTelefonico;
    private String categoriaIdentificador;

    public ComandoSolicitanteTestDataBuilder porDefecto() {
        this.numeroIdentificacion = "765498363";
        this.nombre = "Juan Pérez";
        this.usuario = "Usuario22";
        this.contrasena = "miContrasena";
        this.numeroTelefonico = 3111234567L;
        this.categoriaIdentificador = "C.C";
        return this;
    }

    public ComandoSolicitanteTestDataBuilder conNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
        return this;
    }

    public ComandoSolicitanteTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoSolicitanteTestDataBuilder conUsuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    public ComandoSolicitanteTestDataBuilder conContrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }

    public ComandoSolicitanteTestDataBuilder conNumeroTelefonico(Long numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
        return this;
    }

    public ComandoSolicitanteTestDataBuilder conCategoriaIdentificador(String categoriaIdentificador) {
        this.categoriaIdentificador = categoriaIdentificador;
        return this;
    }

    public SolicitanteDto construir() {
        return new SolicitanteDto(numeroIdentificacion, nombre, usuario, contrasena, numeroTelefonico, categoriaIdentificador);
    }
}
