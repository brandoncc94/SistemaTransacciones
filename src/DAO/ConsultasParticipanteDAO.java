

package DAO;

import Factory.SQLServerDAOFactory;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ConsultasParticipanteDAO implements ParticipanteDAO{

    public ConsultasParticipanteDAO() { }
     
    
    @Override
    public int mostrarNegociaciones(int participanteId, JTable pTable)
    {
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        
        try{              
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC SPMostrarNegociaciones @usuarioId = ?");
            stmt.setInt(1, participanteId);
            rs = stmt.executeQuery();
            
            DefaultTableModel tabla= new DefaultTableModel();

            tabla.addColumn("Id Negociación");
            tabla.addColumn("Tipo Cambio Promedio");
            tabla.addColumn("Monto");
            tabla.addColumn("Fecha");

            while (rs.next()){
                Object dato[] = new  Object[4];
                for (int i=0; i<4; i++){
                    dato[i]=rs.getString(i+1);
                }
                
                tabla.addRow(dato);
            }

            pTable.setModel(tabla);
            
            return 1;
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
        return -1;
    }
    
    @Override
    public int buscarOfertas(String criterio, BigDecimal rangoMin, BigDecimal rangoMax, boolean isCompra, JTable pTable)
    {
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        
        try{              
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC [SPBuscarOferta] @criterio = ?, @rangoMin = ?, @rangoMax = ?, @isCompra = ?");
            stmt.setString(1, criterio);
            stmt.setBigDecimal(2, rangoMin);
            stmt.setBigDecimal(3, rangoMax);
            stmt.setBoolean(4, isCompra);
            rs = stmt.executeQuery();
            
            DefaultTableModel tabla= new DefaultTableModel();

            tabla.addColumn("Id Oferta");
            tabla.addColumn("Monto");
            tabla.addColumn("TipoCambio");
            tabla.addColumn("Id Usuario");
            tabla.addColumn("Tipo Oferta");

            while (rs.next()){
                Object dato[] = new  Object[5];
                for (int i=0; i<5; i++){
                    dato[i]=rs.getString(i+1);
                }
                
                String tipoOferta = dato[4].toString();
                
                if (tipoOferta.equals("0"))
                    dato[4] = "Venta";
                else
                    dato[4] = "Compra";
                
                tabla.addRow(dato);
            }

            pTable.setModel(tabla);
            
            return 1;
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
        return -1;
    }
    
}
