
package Classes;


public class Sesion {
    
    private int adminId;
    private int porcentComision;

    public Sesion(int adminId, int porcentComision) {
        this.adminId = adminId;
        this.porcentComision = porcentComision;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getPorcentComision() {
        return porcentComision;
    }

    public void setPorcentComision(int porcentComision) {
        this.porcentComision = porcentComision;
    }  
}
