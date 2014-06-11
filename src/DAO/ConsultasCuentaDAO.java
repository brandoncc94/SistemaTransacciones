
package DAO;

import Factory.SQLServerDAOFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasCuentaDAO implements CuentaDAO{

    public ConsultasCuentaDAO() {}
    
    @Override
    public int obtenerCuenta(int participanteId, boolean isDolar)
    {
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        int cuentaId = -1;
        
        try{         
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC SPObtenerCuenta");

            rs = stmt.executeQuery();
            
            while(rs.next()){
                cuentaId = rs.getInt("idCuenta");
            }
        } 
        catch(SQLException e){
            cuentaId = -1;
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
        return cuentaId;
    }
    
}
