package Negocio;

import java.util.List;

/**
 *
 * @author Leonel Otavalo
 */
public class Factura {
    Cliente client;
    List<Pedido> aux;

    public Factura(Cliente client, List<Pedido> aux) {
        this.client = client;
        this.aux = aux;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public List<Pedido> getAux() {
        return aux;
    }

    public void setAux(List<Pedido> aux) {
        this.aux = aux;
    }
   
    @Override
    public String toString() {
        float total=0;
        String salida="\n****FACTURA****";
        salida+="\nCLIENTE: "+this.client.getNombre()+" "+this.client.getApellido();
        salida+="\nCEDULA: "+this.client.getCedula();
        salida+="\nTELEFONO: "+this.client.getTelefono();
        salida+="\nDIRECCION: "+this.client.getDireccion();
        salida+="\nCORREO: "+this.client.getCorreo();
        salida+="\nPLATILLO\t\tCANTIDAD\tPRECIO C/U\tPRECIO TOTAL";
        for (Pedido p : this.aux) {
            total+=p.getTotal();
            salida+="\n"+p.getPlat().getNombre()+"\t\t"+p.getCant()+"\t\t"+p.getPlat().getPrecio()+"\t\t"+p.getTotal();
        }
        salida+="\nTOTAL A PAGAR: $"+total;
        salida+="\n****ENCARGADO DE LA ENTREGA****";
        salida+="\nNOMBRE: "+this.aux.get(0).getTransp().getNombre()+" "+this.aux.get(0).getTransp().getApellido();
        salida+="\nTELEFONO: "+this.aux.get(0).getTransp().getTelefono();
        salida+="\nTIPO DE AUTO: "+this.aux.get(0).getTransp().getTipo_auto();
        salida+="\nPLACA: "+this.aux.get(0).getTransp().getPlaca();
        return salida;
    }
    
    
    
    
}
