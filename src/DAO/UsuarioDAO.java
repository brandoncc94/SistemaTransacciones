
package DAO;

import Classes.Usuario;
import java.util.List;

public interface UsuarioDAO {
    
    public List<Integer> iniciarSesion(String pUsuario, String pPassword);
    
    public List<String> obtenerNombre(int pId);
    
    public String obtenerPassword(int pId);
    
    public int cambiarPassword(String pPassword, int pIdUsuario);
    
    public int crearAgente(Usuario pUsuario, int pAgenciaId);
    
    public List seleccionarAgencias();
}
