package DAO;

import Factory.SQLServerDAOFactory;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConsultasTransaccionDAO implements TransaccionDAO{

    public ConsultasTransaccionDAO() {}
    
    @Override
    public BigDecimal obtenerMontoTransado(int sesionId)
    {
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        BigDecimal montoTransado = BigDecimal.ZERO;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC SPObtenerMontoTransado @sesionId = ?");
            stmt.setInt(1, sesionId);
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                montoTransado = rs.getBigDecimal("montoTransado");
            }
        } 
        catch(SQLException e)
        {
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
        
        return montoTransado;
    }
    
    @Override
    public BigDecimal obtenerTipoCambioPromedio(int sesionId)
    {
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        BigDecimal tipoCambioProm = BigDecimal.ZERO;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC ObtenerTipoCambioPromedio @sesionId = ?");
            stmt.setInt(1, sesionId);
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                tipoCambioProm = rs.getBigDecimal("tipoCambio");
            }
        } 
        catch(SQLException e)
        {
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
        
        return tipoCambioProm;
    }
    
}
