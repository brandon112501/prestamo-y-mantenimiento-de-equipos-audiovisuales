package Service;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {



    public String registrarUsuario(String nombre, String correo, String rol) {

        return "Usuario " + nombre + " registrado exitosamente con el rol: " + rol;
    }


    public boolean esAdministrador(Long idUsuario) {

        return true;
    }


    public void validarPermisos(String rolRequerido, String rolActual) {
        if (!rolRequerido.equals(rolActual)) {


            throw new IllegalArgumentException("No tienes permisos suficientes para realizar esta acción.");


        }
    }
}
