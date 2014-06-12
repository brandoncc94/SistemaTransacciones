
package DAO;

import Classes.Sesion;
import Classes.Usuario;
import Factory.SQLServerDAOFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConsultasAdministradorDAO implements AdministradorDAO {
    
    public ConsultasAdministradorDAO(){ }
     
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
    // Buscar todos los alojamientos disponibles
    public int seleccionarUsuarios(JTable pTable){       
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        
        try{              
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC SPUSeleccionarUsuarios");
            rs = stmt.executeQuery();
            
            DefaultTableModel tabla= new DefaultTableModel();

            tabla.addColumn("Id Usuario");
            tabla.addColumn("Nombre");
            tabla.addColumn("Apellidos");
            tabla.addColumn("Tipo");

            while (rs.next()){
                Object dato[] = new  Object[4];
                for (int i=0; i<4; i++){
                    dato[i]=rs.getString(i+1);
                    if(i == 3){
                        switch(dato[i].toString()){
                            case "1":
                                dato[i] = "Administrador";
                                break;
                            case "2":
                                dato[i] = "Agente";
                                break;
                            case "3":
                                dato[i] = "Participante";
                                break;
                        }
                    }
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
    public List<Integer> seleccionarParticipantes(JTable pTable){
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        List<Integer> participantesIds = new ArrayList<>();
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            
            if(pTable == null){
                stmt = conn.prepareStatement("SELECT idUsuario FROM Usuarios WHERE tipo = 3");
                rs = stmt.executeQuery();
                participantesIds = new ArrayList();

                while(rs.next()){
                    participantesIds.add(rs.getInt("idUsuario"));
                }
            }else{
                stmt = conn.prepareStatement("EXEC SPUObtenerDatosPartipantes");
                rs = stmt.executeQuery();
                DefaultTableModel tabla= new DefaultTableModel();

                tabla.addColumn("Id Usuario");
                tabla.addColumn("Nombre");
                tabla.addColumn("Apellidos");
                tabla.addColumn("Activo");

                while (rs.next()){
                    Object dato[] = new  Object[4];
                    for (int i=0; i<4; i++){
                        dato[i]=rs.getString(i+1);
                        if(i == 3){
                            if(dato[i].equals("1") || dato[i].equals("True"))
                                dato[i] = "Activo";
                            else
                                dato[i] = "Inactivo";
                        }
                    }
                    tabla.addRow(dato);
                }

                pTable.setModel(tabla);

                participantesIds.add(1);
            }
        } 
        catch(SQLException e){
            participantesIds.add(-1);
            System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
        }
        finally{
            if(conn != null){
                try{
                    conn.close();
                }
                catch(SQLException e){
                    participantesIds.add(-1);
                    System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
                }
            }
        }
        
        return participantesIds;
    }
    
    @Override
    public int suspenderUsuario(int pIdUsuario){
        Connection conn = null;
        PreparedStatement stmt;
        int rowCount = 0;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC SPUSuspenderUsuario @idUsuario = ?");
            stmt.setInt(1, pIdUsuario);
            
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
    public int isSuspendido(int pIdUsuario){
        Connection conn = null;
        PreparedStatement stmt;
        int rowCount = 0;
        ResultSet rs;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC SPUConsultarParticipanteSuspendido @idUsuario = ?");
            stmt.setInt(1, pIdUsuario);
            
            rs = stmt.executeQuery();

            while(rs.next()){
                rowCount = rs.getInt("isActivo");
            }
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
    public int mostrarPizarra(String pOrdenar, JTable pTable){
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        
        try{              
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC SPUMostrarPizarra @ordenar = ?");
            stmt.setString(1, pOrdenar);
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
    
    @Override
    public List<Integer> seleccionarSesiones(){
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        List<Integer> sesiones = new ArrayList<>();
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("SELECT idSesion FROM Sesiones WHERE isFinalizada = 'False' ");
            rs = stmt.executeQuery();
            
            sesiones = new ArrayList();
            
            while(rs.next()){
                sesiones.add(rs.getInt("idSesion"));
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
        
        return sesiones;
    }
    
    @Override
    public int crearSesion(Sesion pSesion){
        Connection conn = null;
        PreparedStatement stmt;
        int rowCount = 0;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC SPUCrearSesion "
                    + "@adminId = ?, "
                    + "@comision = ?, "
                    + "@isFinalizada = ? ");
            stmt.setInt(1, pSesion.getAdminId());
            stmt.setInt(2, pSesion.getPorcentComision());
            stmt.setBoolean(3, pSesion.isIsFinalizada());
            
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
    public int cancelarSesion(int pIdSesion){
        Connection conn = null;
        PreparedStatement stmt;
        int rowCount = 0;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC SPUActualizarSesion "
                    + "@idSesion = ? ");
            stmt.setInt(1, pIdSesion);
            
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
