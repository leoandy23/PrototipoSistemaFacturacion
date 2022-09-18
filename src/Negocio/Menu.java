package Negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Leonel Otavalo
 */
public class Menu {
    List <Platillo> menu;

    public Menu() {
        this.menu = new <Platillo> ArrayList();
    }
    
    public void addPlatillo(Platillo p){
        this.menu.add(p);
    }

    public List<Platillo> getMenu() {
        return menu;
    }

    public void setMenu(List<Platillo> menu) {
        this.menu = menu;
    }
    
    public void OrdenarNombre(){
        Collections.sort(menu,new ComparatorPlatilloName());
    }
    
     public void OrdenarPrecio(){
        Collections.sort(menu,new ComparatorPlatilloPrecio());
    }
    
    public int BusqBinNombre(Platillo p){
        OrdenarNombre();
         return Collections.binarySearch(menu,p,new ComparatorPlatilloName());  
    }
    
    public boolean removePlatillo(Platillo p){
      OrdenarNombre();
        Iterator <Platillo> it = menu.iterator();
        int aux = 0;
        while (it.hasNext()|aux==0){    
            Platillo p2 =it.next();
            if (p.getNombre().equals(p2.getNombre())) {
                it.remove();
                return true;
            }
            aux++;
        }
        return false; 
    }

    @Override
    public String toString() {
        String salida="\n*****MENU*****";
        for (Platillo p : menu) {
            salida+=p.toString()+"\n";
        }
        return salida;
    }
    
    
}
