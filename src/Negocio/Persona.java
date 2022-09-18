package Negocio;
/**
 *
 * @author Leonel Otavalo
 */
public class Persona {
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;

    public Persona(String nombre, String apellido, String cedula, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    

    @Override
    public String toString() {
        String salida="";
        salida+="\nNOMBRE: "+ this.nombre+" "+this.apellido;
        salida+="\nCEDULA: "+this.cedula;
        salida+="\nTELEFONO: "+this.telefono;
        return salida;
    }
    
}
