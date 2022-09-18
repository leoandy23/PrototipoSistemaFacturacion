package Negocio;

/**
 *
 * @author Leonel Otavalo
 */
public class Pedido {
    private Platillo plat;
    private Cliente client;
    private Transportista transp;
    private String desc;
    private int cant;
    private float total;

    public Pedido(Platillo plat, Cliente client, Transportista transp, String desc, int cant) {
        this.plat = plat;
        this.client = client;
        this.transp = transp;
        this.desc = desc;
        this.cant = cant;
        this.total = plat.getPrecio()*cant;
    }

    public Platillo getPlat() {
        return plat;
    }

    public void setPlat(Platillo plat) {
        this.plat = plat;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public Transportista getTransp() {
        return transp;
    }

    public void setTransp(Transportista transp) {
        this.transp = transp;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
    
    public void ApplyProm(){
        this.total = (float) (this.total-(this.total*0.15));
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    @Override
    public String toString() {
        String salida="\nPEDIDO";
        salida+="\nPLATO: "+this.plat.getNombre();
        salida+="\nCANTIDAD: "+this.cant;
        salida+="\nCLIENTE: "+this.client.getNombre()+" "+this.client.getApellido();
        salida+="\nTELEFONO CLIENTE: "+this.client.getTelefono();
        salida+="\nDIRECCION: "+this.client.getDireccion();
        salida+="\nENCARGADO ENTREGA: "+this.transp.getNombre()+" "+this.transp.getApellido();
        salida+="\nPLACA AUTO: "+this.transp.getPlaca();
        salida+="\nPRECIO TOTAL: $"+this.total;
        salida+="\nDESCRIPCION: "+this.desc;
        return salida;
    }
    
   
    
}
