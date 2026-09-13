package Service;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    /**
     * Endpoint transversal: Registrar usuario válido y aplicar rol permitido
     */
    public String registrarUsuario(String nombre, String correo, String rol) {
        // TODO: Aquí encriptaremos la contraseña y guardaremos al usuario en la BD.
        return "Usuario " + nombre + " registrado exitosamente con el rol: " + rol;
    }

    /**
     * Validar si un usuario tiene permisos de Administrador
     */
    public boolean esAdministrador(Long idUsuario) {
        // TODO: Consultar en base de datos si el usuario tiene el rol 'ADMINISTRADOR'.
        // Esto será útil para proteger los endpoints de reportes (RF09).
        return true;
    }

    /**
     * Regla de seguridad: Impedir que un rol ejecute operaciones que no le corresponden
     */
    public void validarPermisos(String rolRequerido, String rolActual) {
        if (!rolRequerido.equals(rolActual)) {
            // Aquí usamos el manejador de excepciones que creaste antes
            throw new IllegalArgumentException("No tienes permisos suficientes para realizar esta acción.");
        }
    }
}