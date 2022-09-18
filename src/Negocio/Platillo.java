package Negocio;

/**
 *
 * @author Leonel Otavalo
 */
public class Platillo {
    private String nombre;
    private String descripcion;
    private float precio;

    public Platillo(String nombre, String descripcion, float precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    
    @Override
    public String toString() {
        String salida="\nPLATILLO";
        salida+="\nNOMBRE: "+this.nombre;
        salida+="\nDESCRIPCION: "+this.descripcion;
        salida+="\nPRECIO: $"+this.precio;
        return salida;
    }
    
    
    
    
}
