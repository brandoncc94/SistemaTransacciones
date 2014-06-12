
package DAO;

import Factory.SQLServerDAOFactory;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Classes.Cuenta;

public class ConsultasCuentaDAO implements CuentaDAO{

    public ConsultasCuentaDAO() {}
    
    @Override
    public Cuenta obtenerCuenta(int participanteId, boolean isDolar)
    {
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        int cuentaId = 0;
        BigDecimal saldo = BigDecimal.ZERO;
        BigDecimal montoCongelado = BigDecimal.ZERO;
        Cuenta cuenta; 
        
        try{         
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC SPObtenerCuenta @participanteId = ?, @isDolar = ?");
            stmt.setInt(1, participanteId);
            stmt.setBoolean(2, isDolar); 
            rs = stmt.executeQuery();
            
            while(rs.next()){
                cuentaId = rs.getInt("idCuenta");
                saldo = rs.getBigDecimal("saldo");
            }
            
            cuenta = new Cuenta(cuentaId, isDolar, saldo, montoCongelado, participanteId);
        } 
        catch(SQLException e){
            cuenta = null;
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
        return cuenta;
    }
    
    @Override
    public int congelarMonto(int cuentaId, BigDecimal monto)
    {
        Connection conn = null;
        PreparedStatement stmt;
        int rowCount = 0;
        
        try{         
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC SPCongelarMonto @idCuenta = ?, @montoCongelar = ?");
            stmt.setInt(1, cuentaId);
            stmt.setBigDecimal(2, monto); 
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
    
}
