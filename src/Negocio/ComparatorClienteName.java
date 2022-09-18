package Negocio;

import java.util.Comparator;

/**
 *
 * @author Leonel Otavalo
 */
public class ComparatorClienteName implements Comparator{

    @Override
    public int compare(Object t1, Object t2) {
        Cliente c1 = (Cliente)t1;
        Cliente c2 = (Cliente)t2;
        return (c1.getNombre().compareTo(c2.getNombre()));
    }

}
