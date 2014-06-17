
package Classes;


public class Sesion {
    
    private int adminId;
    private float porcentComision;
    private boolean isFinalizada;

    public Sesion(int adminId, float porcentComision, boolean isFinalizada) {
        this.adminId = adminId;
        this.porcentComision = porcentComision;
        this.isFinalizada = isFinalizada;
    }

    public boolean isIsFinalizada() {
        return isFinalizada;
    }

    public void setIsFinalizada(boolean isFinalizada) {
        this.isFinalizada = isFinalizada;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public float getPorcentComision() {
        return porcentComision;
    }

    public void setPorcentComision(int porcentComision) {
        this.porcentComision = porcentComision;
    }  
}
