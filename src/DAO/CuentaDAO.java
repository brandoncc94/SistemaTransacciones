
package DAO;

import java.math.BigDecimal;


public interface CuentaDAO {
    
    public int obtenerCuentaId(int participanteId, boolean isDolar);
    public int congelarMonto(int cuentaId, BigDecimal monto);
    
}
