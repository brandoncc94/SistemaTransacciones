
package DAO;

import Classes.Usuario;
import Factory.SQLServerDAOFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ConsultasUsuarioDAO implements UsuarioDAO {
    
    public ConsultasUsuarioDAO(){ }
   
    // Implement search persons here using the supplied criteria.
    // Alternatively, implement to return a Collection of Transfer Objects.
    @Override
    public List<Integer> iniciarSesion(String pUsuario, String pPassword){
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        int tipo = 0;
        int id = 0;
        List<Integer> info = new ArrayList<>();
        
        try{         
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC SPUConsultarInicioDeSesion @usuario = ?, @password = ?");
            stmt.setString(1, pUsuario);
            stmt.setString(2, pPassword);            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                id = rs.getInt("idUsuario");
                tipo = rs.getInt("tipo");
            }
            info.add(id);
            info.add(tipo);
        } 
        catch(SQLException e){
            info = null;
            System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
        }
        finally{
            if(conn != null){
                try{
                    conn.close();
                }
                catch(SQLException e){
                    System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
                }
            }
        }        
        return info;
    }
    
    @Override
     public String obtenerPassword(int pId){
         Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        String info = "";
        
        try{         
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC SPUObtenerPassword @idUsuario = ?");
            stmt.setInt(1, pId);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                info = rs.getString("password");
            }
        } 
        catch(SQLException e){
            info = null;
            System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
        }
        finally{
            if(conn != null){
                try{
                    conn.close();
                }
                catch(SQLException e){
                    System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
                }
            }
        }        
        return info;
     }
     
     @Override
     public List<String> obtenerNombre(int pId){
         Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        List<String> info = new ArrayList<>();
        
        try{         
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC SPUObtenerNombre @idUsuario = ?");
            stmt.setInt(1, pId);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                info.add(rs.getString("nombre"));
                info.add(rs.getString("apellidoP"));
                info.add(rs.getString("apellidoM"));
            }
        } 
        catch(SQLException e){
            info = null;
            System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
        }
        finally{
            if(conn != null){
                try{
                    conn.close();
                }
                catch(SQLException e){
                    System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
                }
            }
        }        
        return info;
     }
     
     @Override
     public int cambiarPassword(String pPassword, int pIdUsuario){
        Connection conn = null;
        PreparedStatement stmt;
        int rowCount = 0;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC SPUCambiarContraseña @idUsuario = ?, @password = ?");
            stmt.setInt(1, pIdUsuario);
            stmt.setString(2, pPassword);
            
            stmt.executeUpdate();
            rowCount = 1;
        } 
        catch(SQLException e){
            rowCount = -1;
            System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
        }
        finally{
            if(conn != null){
                try{
                    conn.close();
                }
                catch(SQLException e){
                    System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
                }
            }
        }
        return rowCount;
     }
     
     @Override
     public int crearAgente(Usuario pUsuario, int pAgenciaId){
        Connection conn = null;
        PreparedStatement stmt;
        int rowCount = 0;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC SPUCrearAgente "
                    + "@nombre = ?, "
                    + "@apellidoP = ?, "
                    + "@apellidoM = ?, "
                    + "@usuario = ?, "
                    + "@password = ?, "
                    + "@tipo = ?, "
                    + "@agenciaId = ? ");
            stmt.setString(1, pUsuario.getNombre());
            stmt.setString(2, pUsuario.getApellidoP());
            stmt.setString(3, pUsuario.getApellidoM());
            stmt.setString(4, pUsuario.getUsuario());
            stmt.setString(5, pUsuario.getPassword());
            stmt.setInt(6, pUsuario.getTipo());
            stmt.setInt(7, pAgenciaId);
            
            stmt.executeUpdate();
            rowCount = 1;
        } 
        catch(SQLException e){
            rowCount = -1;
            System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
        }
        finally{
            if(conn != null){
                try{
                    conn.close();
                }
                catch(SQLException e){
                    System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
                }
            }
        }
        return rowCount;
     }
     
     @Override
    public List seleccionarAgencias() {
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        List<Integer> agencias = new ArrayList<>();
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("SELECT idAgencia FROM Agencias");
            rs = stmt.executeQuery();
            
            agencias = new ArrayList();
            
            while(rs.next()){
                agencias.add(rs.getInt("idAgencia"));
            }
        } 
        catch(SQLException e){
            System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
        }
        finally{
            if(conn != null){
                try{
                    conn.close();
                }
                catch(SQLException e){
                    System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
                }
            }
        }
        
        return agencias;
    }
    
}
