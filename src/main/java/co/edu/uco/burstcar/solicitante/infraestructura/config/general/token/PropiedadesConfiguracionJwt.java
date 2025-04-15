package co.edu.uco.burstcar.solicitante.infraestructura.config.general.token;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
public class PropiedadesConfiguracionJwt {

    private String almacenajeLocalizacion;
    private String almacenajeContrasena;
    private String llaveAlias;
    private String llaveContrasena;
    private int tokenVencimiento;

    public String getAlmacenajeLocalizacion() {
        return almacenajeLocalizacion;
    }

    public void setAlmacenajeLocalizacion(String almacenajeLocalizacion) {
        this.almacenajeLocalizacion = almacenajeLocalizacion;
    }

    public String getAlmacenajeContrasena() {
        return almacenajeContrasena;
    }

    public void setAlmacenajeContrasena(String almacenajeContrasena) {
        this.almacenajeContrasena = almacenajeContrasena;
    }

    public String getLlaveAlias() {
        return llaveAlias;
    }

    public void setLlaveAlias(String llaveAlias) {
        this.llaveAlias = llaveAlias;
    }

    public String getLlaveContrasena() {
        return llaveContrasena;
    }

    public void setLlaveContrasena(String llaveContrasena) {
        this.llaveContrasena = llaveContrasena;
    }

    public int getTokenVencimiento() {
        return tokenVencimiento;
    }

    public void setTokenVencimiento(int tokenVencimiento) {
        this.tokenVencimiento = tokenVencimiento;
    }
}
