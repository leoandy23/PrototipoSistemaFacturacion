package Negocio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonel Otavalo
 */
public class ListPedidos {
    List <Pedido> listped;

    public ListPedidos() {
        this.listped = new <Pedido> ArrayList();
    }
    
    public void addPedido(Pedido p){
        this.listped.add(p);
    }

    public List<Pedido> getListped() {
        return listped;
    }

    public void setListped(List<Pedido> listped) {
        this.listped = listped;
    }
    
    public List PedidosCliente(Cliente c){
        List <Pedido> ped_clie = new <Pedido> ArrayList();
        for (Pedido p : this.listped) {
            if(p.getClient().getCedula().equals(c.getCedula())){
                ped_clie.add(p);
            }
        }
        return ped_clie;
    }

    @Override
    public String toString() {
        String salida="\n*****PEDIDOS*****";
        for (Pedido p : listped) {
            salida+=p.toString()+"\n";
        }
        return salida;
    }
    
    
}
