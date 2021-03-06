
package Factory;

import DAO.AdministradorDAO;
import DAO.AgenteDAO;
import DAO.CuentaDAO;
import DAO.OfertaDAO;
import DAO.ParticipanteDAO;
import DAO.SesionDAO;
import DAO.TransaccionDAO;
import DAO.UsuarioDAO;

public abstract class DAOFactory {

    // List of DAO types supported by the factory
    public static final int SQLSERVER = 1;

    // There will be a method for each DAO that can be created. The concrete factories will have to implement these methods.
    public abstract AdministradorDAO getAdministradorDAO();
    public abstract UsuarioDAO getUsuarioDAO();
    public abstract OfertaDAO getOfertaDAO();
    public abstract SesionDAO getSesionDAO();
    public abstract CuentaDAO getCuentaDAO();
    public abstract ParticipanteDAO getParticipanteDAO();
    public abstract TransaccionDAO getTransaccionDAO();
    public abstract AgenteDAO getAgenteDAO();

    public static DAOFactory getDAOFactory(int whichFactory){

        switch(whichFactory){
          case SQLSERVER: 
              return new SQLServerDAOFactory();
          default: 
              return null;
        }
    }
}
