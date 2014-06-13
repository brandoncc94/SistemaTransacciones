
package Classes;

import java.util.Date;

public class Participante {
    private int cedula;
    private Date fechaNacimiento;
    private String correo;
    private String direccion;
    private int telefono;

    public Participante(int cedula, Date fechaNacimiento, String correo, String direccion, int telefono) {
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public int getCedula() {
        return cedula;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }
    
    
}
