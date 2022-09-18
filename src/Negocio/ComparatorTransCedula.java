package Negocio;

import java.util.Comparator;

/**
 *
 * @author Leonel Otavalo
 */
public class ComparatorTransCedula implements Comparator {
    
    @Override
    public int compare(Object t1, Object t2) {
        Transportista tr1 = (Transportista)t1;
        Transportista tr2 = (Transportista)t1;
        return (tr1.getCedula().compareTo(tr2.getCedula()));
    }
}
