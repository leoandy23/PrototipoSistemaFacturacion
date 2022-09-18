package Negocio;

/**
 *
 * @author Leonel Otavalo
 */
public class Transportista extends Persona{
    private String tipo_auto;
    private String licencia;
    private String placa;

    public Transportista(String tipo_auto, String licencia, String placa, String nombre, String apellido, String cedula, String telefono) {
        super(nombre, apellido, cedula, telefono);
        this.tipo_auto = tipo_auto;
        this.licencia = licencia;
        this.placa = placa;
    }

    public String getTipo_auto() {
        return tipo_auto;
    }

    public void setTipo_auto(String tipo_auto) {
        this.tipo_auto = tipo_auto;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    @Override
    public String toString() {
        String salida="\nTRANSPORTISTA";
        salida+=super.toString();
        salida+="\nLICENCIA: "+this.licencia;
        salida+="\nTIPO DE TRANSPORTE: "+this.tipo_auto;
        salida+="\nPLACA: "+this.placa;
        return salida;
    }  
    
    
}
