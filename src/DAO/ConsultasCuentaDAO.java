
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
    public int congelarMonto(BigDecimal tipoCambio, int usuarioId, BigDecimal montoOferta, boolean isCompra)
    {
        Connection conn = null;
        PreparedStatement stmt;
        int resultado = 0;
        
        try{         
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC SPCongelarMonto @tipoCambio = ?, @usuarioId = ?, "
                                        + "@montoOferta= ?, @isCompra = ?");
            stmt.setBigDecimal(1, tipoCambio);
            stmt.setInt(2, usuarioId); 
            stmt.setBigDecimal(3, montoOferta);
            stmt.setBoolean(4, isCompra);
            stmt.executeUpdate();
            
            resultado = 1;       
        } 
        catch(SQLException e){
            resultado = -1;       
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
        return resultado;
    }
    
}
