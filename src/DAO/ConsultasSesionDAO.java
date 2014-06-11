
package DAO;

import Factory.SQLServerDAOFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasSesionDAO implements SesionDAO {

    public ConsultasSesionDAO() {}
    
    @Override
    public int obtenerSesionActual()
    {
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        int info = -1;
        
        try{         
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC SPObtenerSesionActual");

            rs = stmt.executeQuery();
            
            while(rs.next()){
                info = rs.getInt("idSesion");
            }
        } 
        catch(SQLException e){
            info = -1;
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
    
    
    
}
