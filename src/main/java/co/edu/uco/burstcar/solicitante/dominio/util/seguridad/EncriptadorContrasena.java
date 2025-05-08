package co.edu.uco.burstcar.solicitante.dominio.util.seguridad;



public class EncriptadorContrasena {

    public EncriptadorContrasena() {
    }

    public static String encriptarContrasenaConSalt(String contrasenaPlano) {
        String salt = BaseContrasena.generateSalt();
        String hash = BaseContrasena.hashPassword(contrasenaPlano, salt);
        return salt + "$" + hash;
    }

    public static boolean validarContrasena(String contrasenaPlano, String contrasenaAlmacenada) {
        if (contrasenaAlmacenada == null || !contrasenaAlmacenada.contains("$")) {
            return false;
        }
        String[] partes = contrasenaAlmacenada.split("\\$");
        String salt = partes[0];
        String hashEsperado = partes[1];
        String hashCalculado = BaseContrasena.hashPassword(contrasenaPlano, salt);
        return hashEsperado.equals(hashCalculado);
    }

}
