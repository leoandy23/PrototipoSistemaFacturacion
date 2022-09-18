package Negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Leonel Otavalo
 */
public class ListaTransport {
    List <Transportista> listtrans;

    public ListaTransport() {
        this.listtrans = new <Transportista> ArrayList();
    }
    
    public void addTransportista(Transportista t){
        this.listtrans.add(t);
    }

    public List<Transportista> getListtrans() {
        return listtrans;
    }

    public void setListtrans(List<Transportista> listtrans) {
        this.listtrans = listtrans;
    }
    
    public void OrdenarNombre(){
        Collections.sort(listtrans,new ComparatorTransName());
    }
    
    public void OrdenarCedula(){
        Collections.sort(listtrans,new ComparatorTransCedula());
    }
    
    public void OrdenarPlaca(){
        Collections.sort(listtrans,new ComparatorTransPlaca());
    }
    public int BusqBinNombre(Transportista t){
        OrdenarNombre();
        return Collections.binarySearch(listtrans,t,new ComparatorTransName());
    }
    
    public int BusqBinCedula(Transportista t){
        OrdenarCedula();
        return Collections.binarySearch(listtrans,t,new ComparatorTransCedula());
    }
    
    public int BusqBinPlaca(Transportista t){
        OrdenarPlaca();
        return Collections.binarySearch(listtrans,t,new ComparatorTransPlaca());
    }
    
    public boolean removeTransportista(Transportista t){
        OrdenarPlaca();
        Iterator <Transportista> it = listtrans.iterator();
        int aux = 0;
        while (it.hasNext()|aux==0){    
            Transportista t2 =it.next();
            if (t.getPlaca().equals(t2.getPlaca())) {
                it.remove();
                return true;
            }
            aux++;
        }
        return false; 
    }

    @Override
    public String toString() {
        String salida="\n*****TRANSPORTISTAS*****";
        for (Transportista t : listtrans) {
            salida+=t.toString()+"\n";
        }
        return salida;
    }
    
    
}
