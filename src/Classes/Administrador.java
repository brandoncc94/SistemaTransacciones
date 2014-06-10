
package Classes;

import java.util.Date;

public class Administrador {
    
    private String nombre;
    private char tipo;
    private char genero;    
    private Date fechaInicio;
    private Date fechaFin;
    private int metrica;
    private int rangoInicial;
    private int rangoFinal;
    private int limiteSerie;
    private int instalacionId;
    private int clasificacionId;
      
    public Administrador() {
        this.nombre = "";
        this.tipo = '-';
        this.genero = '-';
        this.fechaInicio = null;
        this.fechaFin = null;
        this.metrica = 0;
        this.rangoInicial = 0;
        this.rangoFinal = 0;
        this.limiteSerie = 0;
        this.instalacionId = 0;
        this.clasificacionId = 0;
    }
    
    public Administrador(String pNombre, char pTipo, char pGenero, Date pFechaInicio,
                        Date pFechaFin, int pMetrica, int pRangoInicial, int pRangoFinal,
                        int pLimiteSerie, int pInstalacionId, int pClasificacionId) {
        this.nombre = pNombre;
        this.tipo = pTipo;
        this.genero = pGenero;
        this.fechaInicio = pFechaInicio;
        this.fechaFin = pFechaFin;
        this.metrica = pMetrica;
        this.rangoInicial = pRangoInicial;
        this.rangoFinal = pRangoFinal;
        this.limiteSerie = pLimiteSerie;
        this.instalacionId = pInstalacionId;
        this.clasificacionId = pClasificacionId;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String pNombre) {
        nombre = pNombre;
    }
    
    public char getTipo() {
        return tipo;
    }
    public void setTipo(char pTipo) {
        tipo = pTipo;
    }
    
    public char getGenero() {
        return genero;
    }
    public void setGenero(char pGenero) {
        genero = pGenero;
    }
    
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date pFechaInicio) {
        fechaInicio = pFechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(Date pFechaFin) {
        fechaFin = pFechaFin;
    }
    
    public int getMetrica() {
        return metrica;
    }
    public void setMetrica(int pMetrica) {
        metrica = pMetrica;
    }
    
    public int getRangoInicial() {
        return rangoInicial;
    }
    public void setRangoInicial(int pRangoInicial) {
        rangoInicial = pRangoInicial;
    }
    
    public int getRangoFinal() {
        return rangoFinal;
    }
    
    public void setRangoFinal(int pRangoFinal) {
        rangoFinal = pRangoFinal;
    }
    
    public int getLimiteSerie() {
        return limiteSerie;
    }
    public void setRango(int pLimiteSerie) {
        limiteSerie = pLimiteSerie;
    }
    
    public int getInstalacionId() {
        return instalacionId;
    }
    public void setInstalacionId(int pInstalacionId) {
        instalacionId = pInstalacionId;
    }
    
    public int getClasificacionId() {
        return clasificacionId;
    }
    public void setClasificacionId(int pClasificacionId) {
        clasificacionId = pClasificacionId;
    }
}
