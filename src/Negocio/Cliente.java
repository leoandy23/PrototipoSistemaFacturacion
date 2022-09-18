package Negocio;

/**
 *
 * @author Leonel Otavalo
 */
public class Cliente extends Persona{
    private String direccion;
    private String correo;
    public Cliente(String direccion, String correo,String nombre, String apellido, String cedula, String telefono) {
        super(nombre, apellido, cedula, telefono);
        this.direccion = direccion;
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    @Override
    public String toString() {
        String salida="\nCLIENTE";
        salida+=super.toString();
        salida+="\nCORREO: "+this.correo;
        salida+="\nDIRECCION: "+this.direccion;
        return salida;
    }    
}
