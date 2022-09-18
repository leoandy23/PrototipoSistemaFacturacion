package Negocio;

import java.util.Comparator;

/**
 *
 * @author Leonel Otavalo
 */
public class ComparatorPlatilloPrecio implements Comparator{

    @Override
    public int compare(Object t1, Object t2) {
        Platillo p1 = (Platillo)t1;
        Platillo p2 = (Platillo)t2;
        if (p1.getPrecio()==p2.getPrecio()) {
                return 0;
            }
            
            if (p1.getPrecio()<p2.getPrecio()) {
                return -1;
            }else{
            return 1;
            }
    }

}
