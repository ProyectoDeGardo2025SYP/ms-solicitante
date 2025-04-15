package co.edu.uco.burstcar.solicitante.dominio.validador;

import java.util.List;

public class ValidadorDeAtibutos {

    private static final String PATTERN = "^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}";
    private static final String PATTERN_NUMBER = "[0-9]*";
    private static final String PATTERN_DECIMAL = "^-?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?$";

    private ValidadorDeAtibutos() {
    }

    private static void validateNoNulos(String valor, String nombreAtributo) {
        if(valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("El atributo" + nombreAtributo +" no puede estar nulo");
        }
    }

    private static void validarTamanoTexto(String valor, String nombreAtributo, int tamano){
        if(valor.length()>=tamano)
        {
            throw new IllegalArgumentException("El " + nombreAtributo +" es más grande de lo permitido, " +
                    "solo soporta " + tamano + " caracteres");
        }
    }

    public static void validarAtributosTexto(String valor, String mensaje, int tamano){
        validateNoNulos(valor, mensaje);
        validarTamanoTexto(valor, mensaje, tamano);
    }


    public static void noEmpty(List<? extends Object> lista, String mensaje){
        if(lista == null || lista.isEmpty()){
            throw  new IllegalArgumentException(mensaje);
        }
    }

    private static boolean acceptancePatternNumber(String valor, String pattern) {
        return valor.matches(pattern);
    }

    private static boolean acceptancePatternDecimal(String valor, String pattern) {
        return valor.matches(pattern);
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

    public static void specialCharactersPassword(String password, String message)
    {
        if(!acceptancePatternPassword(password, PATTERN))
        {
            throw new IllegalArgumentException(message);
        }
    }
}
