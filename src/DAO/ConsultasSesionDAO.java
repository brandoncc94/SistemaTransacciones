
package DAO;

import Factory.SQLServerDAOFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultasSesionDAO implements SesionDAO {

    public ConsultasSesionDAO() {}
    
    @Override
    public List<Integer> obtenerSesionActual()
    {
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        int id = 0;
        int comision = 0;
        List<Integer> info = new ArrayList<>();    
        
        try{         
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC SPObtenerSesionActual");

            rs = stmt.executeQuery();
            
            while(rs.next()){
                id = rs.getInt("idSesion");
                comision = rs.getInt("porcentComision");
            }
            
            info.add(id);
            info.add(comision);
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
}
