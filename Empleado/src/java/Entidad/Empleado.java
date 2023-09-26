
package Entidad;

/**
 *
 * @author Anderson
 */
public class Empleado {
    int id_empleado;
    int id_documento;
    int id_area;
    int id_cargo;
    String nombre_empleado;
    String apellido_empleado;

    public Empleado() {
    }

    public Empleado(int id_empleado, int id_documento, int id_area, int id_cargo, String nombre_empleado, String apellido_empleado) {
        this.id_empleado = id_empleado;
        this.id_documento = id_documento;
        this.id_area = id_area;
        this.id_cargo = id_cargo;
        this.nombre_empleado = nombre_empleado;
        this.apellido_empleado = apellido_empleado;
    }

    
    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getApellido_empleado() {
        return apellido_empleado;
    }

    public void setApellido_empleado(String apellido_empleado) {
        this.apellido_empleado = apellido_empleado;
    }
    
    
}
