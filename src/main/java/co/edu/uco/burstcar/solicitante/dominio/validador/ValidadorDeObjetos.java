package co.edu.uco.burstcar.solicitante.dominio.validador;

public class ValidadorDeObjetos {

    private ValidadorDeObjetos() {
    }

    public static void validateNoNulos(Object valor, String nombreAtributo) {
        if(valor == null) {
            throw new IllegalArgumentException("El atributo " + nombreAtributo +" no puede estar nulo");
        }
    }
}
