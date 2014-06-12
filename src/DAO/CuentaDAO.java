
package DAO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import Classes.Cuenta;


public interface CuentaDAO {
    
    public Cuenta obtenerCuenta(int participanteId, boolean isDolar);
    public int congelarMonto(int cuentaId, BigDecimal monto);
    
}
