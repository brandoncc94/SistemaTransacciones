
package DAO;

import Classes.Participante;
import Classes.Usuario;
import java.math.BigDecimal;

public interface AgenteDAO {
    
    public int crearParticipante(Usuario pUsuario, Participante pParticipante, int agenteId);
    
    public int ejecutarTransaccion(int pCedula, BigDecimal pMonto, boolean pIsDolar, int pAgenteId, String pTipo);
}
