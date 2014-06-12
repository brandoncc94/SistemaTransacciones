
package DAO;

import Classes.Sesion;
import Classes.Usuario;
import java.util.List;
import javax.swing.JTable;

public interface AdministradorDAO {
    
    public int crearAgente(Usuario pUsuario, int pAgenciaId, int pIdAdmin);
    
    public int seleccionarUsuarios(JTable pTable);
    
    public List<Integer> seleccionarParticipantes(JTable pTable);
    
    public int suspenderUsuario(int pIdUsuario);
    
    public int isSuspendido(int pIdUsuario);
    
    public int mostrarPizarra(String pOrdenar, JTable pTable);
    
    public List<Integer> seleccionarSesiones();
    
    public int crearSesion(Sesion pSesion);
    
    public int cancelarSesion(int pIdSesion);
    
    public int seleccionarTransacciones(int pSesion, JTable pTable);
    
    public int seleccionarEstadisticasTransacciones(int pSesion, JTable pTable);
    
    public List<Integer> seleccionarTodasSesiones();
    
}