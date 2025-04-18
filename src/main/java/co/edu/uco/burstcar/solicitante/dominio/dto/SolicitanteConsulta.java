package co.edu.uco.burstcar.solicitante.dominio.dto;

import java.util.UUID;

public class SolicitanteConsulta {

    private UUID identificador;
    private String numeroIdentificacion;
    private String nombre;
    private Long numeroTelefonico;
    private String categoriaIdentificacion;

    public SolicitanteConsulta() {
    }

    private SolicitanteConsulta(UUID identificador, String numeroIdentificacion, String nombre, Long numeroTelefonico, String categoriaIdentificacion) {
        this.identificador = identificador;
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre = nombre;
        this.numeroTelefonico = numeroTelefonico;
        this.categoriaIdentificacion = categoriaIdentificacion;
    }

    public static SolicitanteConsulta solicitanteConsulta(UUID identificador, String numeroIdentificacion, String nombre, Long numeroTelefonico, String categoriaIdentificacion) {
        return new SolicitanteConsulta(identificador, numeroIdentificacion, nombre,
                numeroTelefonico, categoriaIdentificacion);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(Long numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getCategoriaIdentificacion() {
        return categoriaIdentificacion;
    }

    public void setCategoriaIdentificacion(String categoriaIdentificacion) {
        this.categoriaIdentificacion = categoriaIdentificacion;
    }
}
