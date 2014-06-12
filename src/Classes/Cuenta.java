
package Classes;

import java.math.BigDecimal;


public class Cuenta {
    
    private int id;
    private boolean isDolar;
    private BigDecimal saldo;
    private BigDecimal montoCongelado;
    private int participanteId;

    public Cuenta(int id, boolean isDolar, BigDecimal saldo, BigDecimal montoCongelado, int participanteId) {
        this.id = id;
        this.isDolar = isDolar;
        this.saldo = saldo;
        this.montoCongelado = montoCongelado;
        this.participanteId = participanteId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getIsDolar() {
        return isDolar;
    }

    public void setIsDolar(boolean isDolar) {
        this.isDolar = isDolar;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getMontoCongelado() {
        return montoCongelado;
    }

    public void setMontoCongelado(BigDecimal montoCongelado) {
        this.montoCongelado = montoCongelado;
    }

    public int getParticipanteId() {
        return participanteId;
    }

    public void setParticipanteId(int participanteId) {
        this.participanteId = participanteId;
    }  
}
