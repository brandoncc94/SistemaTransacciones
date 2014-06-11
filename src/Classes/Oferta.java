
package Classes;

import java.math.BigDecimal;

public class Oferta {
    
    private boolean isCompra;
    private BigDecimal monto;
    private BigDecimal tipoCambio;
    private boolean isActiva;
    private int idParticipante;
    private int idSesion;

    public Oferta(boolean isCompra, BigDecimal monto, BigDecimal tipoCambio, boolean isActiva, 
                  int idParticipante, int idSesion) {
        this.isCompra = isCompra;
        this.monto = monto;
        this.tipoCambio = tipoCambio;
        this.isActiva = isActiva;
        this.idParticipante = idParticipante;
        this.idSesion = idSesion;
    }

    public boolean getIsCompra() {
        return isCompra;
    }

    public void setIsCompra(boolean isCompra) {
        this.isCompra = isCompra;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(BigDecimal tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public boolean getIsActiva() {
        return isActiva;
    }

    public void setIsActiva(boolean isActiva) {
        this.isActiva = isActiva;
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public int getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }
}
