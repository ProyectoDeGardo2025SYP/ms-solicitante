package co.edu.uco.burstcar.solicitante.dominio.validador;

import java.util.List;

public class ValidadorDeAtibutos {

    private static final String PATRON_CONTRASENA = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z\\d]).{8,16}$";
    private ValidadorDeAtibutos() {
    }

    private static void validateNoNulos(String valor, String nombreAtributo) {
        if(valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("El atributo " + nombreAtributo +" no puede estar nulo");
        }
    }

    public static void validarObjetoNoNulo(Object valor, String nombreAtributo) {
        if(valor == null) {
            throw new IllegalArgumentException("El atributo" + nombreAtributo +" no puede estar nulo");
        }
    }

    private static void validarTamanoTexto(String valor, String nombreAtributo, int tamano){
        if(valor.length()>tamano)
        {
            throw new IllegalArgumentException("El " + nombreAtributo +" es más grande de lo permitido, " +
                    "solo soporta " + tamano + " caracteres");
        }
    }

    public static void validarAtributosTexto(String valor, String mensaje, int tamano){
        validateNoNulos(valor, mensaje);
        validarTamanoTexto(valor, mensaje, tamano);
    }


    public static void sizePassword(String valor, String message)
    {
        if(!(valor.length()>=8 && valor.length()<=16))
        {
            throw new IllegalArgumentException(message);
        }
    }

    private static boolean acceptancePatternPassword(String data, String pattern)
    {
        return data.matches(pattern);
    }

    public static void validarContrasena(String contrasena) {
        if (contrasena == null) {
            throw new IllegalArgumentException("La contraseña no puede ser nula.");
        }

        if (contrasena.length() < 8 || contrasena.length() > 16) {
            throw new IllegalArgumentException("La contraseña debe tener entre 8 y 16 caracteres.");
        }

        if (!contrasena.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("La contraseña debe contener al menos una letra minúscula.");
        }

        if (!contrasena.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("La contraseña debe contener al menos una letra mayúscula.");
        }

        if (!contrasena.matches(".*\\d.*")) {
            throw new IllegalArgumentException("La contraseña debe contener al menos un número.");
        }

        if (!contrasena.matches(".*[^a-zA-Z\\d].*")) {
            throw new IllegalArgumentException("La contraseña debe contener al menos un carácter especial.");
        }
    }
}
