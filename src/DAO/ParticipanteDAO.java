
package DAO;

import java.math.BigDecimal;
import javax.swing.JTable;



public interface ParticipanteDAO {
    
    public int mostrarNegociaciones(int participanteId, JTable pTable);
    public int buscarOfertas(String criterio, BigDecimal rangoMin, BigDecimal rangoMax, boolean isCompra, JTable pTable);
    
}
