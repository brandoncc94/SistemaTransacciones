package DAO;

import Classes.Oferta;
import Factory.SQLServerDAOFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultasOfertaDAO implements OfertaDAO{

    public ConsultasOfertaDAO() {}
    
    @Override
    public int crearOferta(Oferta pOferta)
    {
        Connection conn = null;
        PreparedStatement stmt;
        int rowCount = 0;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC SPCrearOferta "
                    + "@isCompra = ?, "
                    + "@monto = ?, "
                    + "@tipoCambio = ?, "
                    + "@usuarioId = ?, "
                    + "@isActiva = ?, "
                    + "@idSesion = ? ");
            stmt.setBoolean(1, pOferta.getIsCompra());
            stmt.setBigDecimal(2, pOferta.getMonto());
            stmt.setBigDecimal(3, pOferta.getTipoCambio());
            stmt.setInt(4, pOferta.getIdParticipante());
            stmt.setBoolean(5, pOferta.getIsActiva());
            stmt.setInt(6, pOferta.getIdSesion());

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
