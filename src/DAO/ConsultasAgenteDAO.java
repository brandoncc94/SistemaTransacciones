
package DAO;

import Classes.Participante;
import Classes.Usuario;
import Factory.SQLServerDAOFactory;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ConsultasAgenteDAO implements AgenteDAO {
    
    public ConsultasAgenteDAO(){ }
    
    @Override
    public int crearParticipante(Usuario pUsuario, Participante pParticipante, int pAgenteId){
        Connection conn = null;
        PreparedStatement stmt;
        int rowCount = 0;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC SPUCrearParticipante "
                    + "@nombre = ?, "
                    + "@apellidoP = ?, "
                    + "@apellidoM = ?, "
                    + "@usuario = ?, "
                    + "@password = ?, "
                    + "@tipo = ?, "
                    + "@cedula = ?, "
                    + "@fechaNac = ?, "
                    + "@correo = ?, "                    
                    + "@direccion = ?, "                    
                    + "@telefono = ?, "                    
                    + "@idAgente = ? ");
            stmt.setString(1, pUsuario.getNombre());
            stmt.setString(2, pUsuario.getApellidoP());
            stmt.setString(3, pUsuario.getApellidoM());
            stmt.setString(4, pUsuario.getUsuario());
            stmt.setString(5, pUsuario.getPassword());
            stmt.setInt(6, pUsuario.getTipo());
            stmt.setInt(7, pParticipante.getCedula());
            stmt.setDate(8, new java.sql.Date(pParticipante.getFechaNacimiento().getTime()));
            stmt.setString(9, pParticipante.getCorreo());
            stmt.setString(10, pParticipante.getDireccion());
            stmt.setInt(11, pParticipante.getTelefono());
            stmt.setInt(12, pAgenteId);
            
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
    public int ejecutarTransaccion(int pCedula, BigDecimal pMonto, boolean pIsDolar, int pAgenteId, String pTipo){
        Connection conn = null;
        PreparedStatement stmt;
        int rowCount = 1;
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC SPUCrearTransaccionAgente "
                    + "@cedula = ?, "
                    + "@monto = ?, "
                    + "@isDolar = ?, "
                    + "@agenteId = ?,"
                    + "@tipo = ? ");
            stmt.setInt(1, pCedula);
            stmt.setBigDecimal(2, pMonto);
            stmt.setBoolean(3, pIsDolar);
            stmt.setInt(4, pAgenteId);
            stmt.setString(5, pTipo);
            
            stmt.executeUpdate();            
        } 
        catch(SQLException e){
            rowCount = -6;
            System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
        }
        finally{
            if(conn != null){
                try{
                    conn.close();
                }
                catch(SQLException e){
                    rowCount = -6;
                    System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
                }
            }
        }
        return rowCount;
    }
}
