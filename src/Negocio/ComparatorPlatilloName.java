package Negocio;

import java.util.Comparator;

/**
 *
 * @author Leonel Otavalo
 */
public class ComparatorPlatilloName implements Comparator{

    @Override
    public int compare(Object t1, Object t2) {
        Platillo p1 = (Platillo)t1;
        Platillo p2 = (Platillo)t2;
        return (p1.getNombre().compareTo(p2.getNombre()));
    }

}
