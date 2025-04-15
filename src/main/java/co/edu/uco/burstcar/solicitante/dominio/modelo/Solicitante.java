package co.edu.uco.burstcar.solicitante.dominio.modelo;

import co.edu.uco.burstcar.solicitante.dominio.validador.ValidadorDeAtibutos;
import java.util.UUID;

import co.edu.uco.burstcar.solicitante.dominio.validador.ValidadorDeObjetos;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class Solicitante extends EntidadIdentificador{

    private String numeroIdentificacion;
    private String nombre;
    private String usuario;
    private String contrasena;
    private Long numeroTelefonico;
    private IdentificacionSolicitante identificacionSolicitante;

    private Solicitante(String numeroIdentificacion, String nombre, String usuario, String contrasena, Long numeroTelefonico, IdentificacionSolicitante identificacionSolicitante) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.numeroTelefonico = numeroTelefonico;
        this.identificacionSolicitante = identificacionSolicitante;
    }

    public static Solicitante nuevoSolicitante(String numeroIdentificacion, String nombre, String usuario, String contrasena, Long numeroTelefonico, IdentificacionSolicitante identificacionSolicitante) {
        ValidadorDeAtibutos.validarAtributosTexto(numeroIdentificacion, "Número de identificación", 12);
        ValidadorDeAtibutos.validarAtributosTexto(nombre, "nombre", 30);
        ValidadorDeAtibutos.validarAtributosTexto(usuario, "usuario", 15);
        ValidadorDeAtibutos.validarAtributosTexto(contrasena, "contraseña", 16);
        ValidadorDeObjetos.validateNoNulos(numeroTelefonico, "Número telefonico");
        ValidadorDeObjetos.validateNoNulos(identificacionSolicitante, "Identificación del solicitante");
        return new Solicitante(numeroIdentificacion, nombre, usuario, contrasena, numeroTelefonico, identificacionSolicitante);
    }

    private Solicitante(UUID identificador, String numeroIdentificacion, String nombre, String usuario, String contrasena, Long numeroTelefonico, IdentificacionSolicitante identificacionSolicitante) {
        super(identificador);
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.numeroTelefonico = numeroTelefonico;
        this.identificacionSolicitante = identificacionSolicitante;
    }

    public static Solicitante nuevoSolicitanteConIdentificador(UUID id, String numeroIdentificacion, String nombre, String usuario, String contrasena, Long numeroTelefonico, IdentificacionSolicitante identificacionSolicitante) {
        ValidadorDeAtibutos.validarAtributosTexto(numeroIdentificacion, "Número de identificación", 12);
        ValidadorDeAtibutos.validarAtributosTexto(nombre, "nombre", 30);
        ValidadorDeAtibutos.validarAtributosTexto(usuario, "usuario", 15);
        ValidadorDeAtibutos.validarAtributosTexto(contrasena, "contraseña", 16);
        ValidadorDeObjetos.validateNoNulos(numeroTelefonico, "Número telefonico");
        ValidadorDeObjetos.validateNoNulos(identificacionSolicitante, "Identificación del solicitante");
        return new Solicitante(id, numeroIdentificacion, nombre, usuario, contrasena, numeroTelefonico, identificacionSolicitante);
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public Long getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public IdentificacionSolicitante getIdentificacionSolicitante() {
        return identificacionSolicitante;
    }
}
