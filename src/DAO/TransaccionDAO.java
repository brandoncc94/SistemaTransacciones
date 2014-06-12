package DAO;

import java.math.BigDecimal;


public interface TransaccionDAO {
    
    public BigDecimal obtenerMontoTransado(int sesionId);
    
    public BigDecimal obtenerTipoCambioPromedio(int sesionId);
    
}
