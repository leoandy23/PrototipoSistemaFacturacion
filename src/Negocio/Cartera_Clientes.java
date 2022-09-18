package Negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Leonel Otavalo
 */
public class Cartera_Clientes {
    List<Cliente> cartera_cli;

    public Cartera_Clientes() {
        this.cartera_cli=new <Cliente> ArrayList();
    }
    
    public void addCliente(Cliente c){
        this.cartera_cli.add(c);
    }

    public List<Cliente> getCartera_cli() {
        return cartera_cli;
    }

    public void setCartera_cli(List<Cliente> cartera_cli) {
        this.cartera_cli = cartera_cli;
    }
    
    public void OrdenarNombre(){
        Collections.sort(cartera_cli,new ComparatorClienteName());
    }
    
    public void OrdenarCedula(){
        Collections.sort(cartera_cli,new ComparatorClienteCedula());
    }
    
    public int BusqBinNombre(Cliente c){
        OrdenarNombre();
        return Collections.binarySearch(cartera_cli,c,new ComparatorClienteName());
    }
    
    public int BusqBinCedula(Cliente c){
        OrdenarCedula();
        return Collections.binarySearch(cartera_cli,c,new ComparatorClienteCedula());
    }
    
    public boolean removeCliente(Cliente c){
      OrdenarCedula();
        Iterator <Cliente> it = cartera_cli.iterator();
        int aux = 0;
        while (it.hasNext()|aux==0){    
            Cliente c2 =it.next();
            if (c.getCedula().equals(c2.getCedula())) {
                it.remove();
                return true;
            }
            aux++;
        }
        return false; 
    }

    @Override
    public String toString() {
        String salida="\n*****CLIENTES*****";
        for (Cliente c : cartera_cli) {
            salida+=c.toString()+"\n";
        }
        return salida;
    }
    
    
}
