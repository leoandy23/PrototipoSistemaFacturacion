package Negocio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonel Otavalo
 */
public class ListCuentas {
    List <Cuenta> cuentas;

    public ListCuentas() {
        this.cuentas = new <Cuenta> ArrayList();
    }
    
    public void addCuenta(Cuenta c){
        this.cuentas.add(c);
    }
    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
    
    public Cuenta FindCuenta(String user,String pass){
        for (Cuenta c : cuentas) {
            if(c.getUser().equals(user) && c.getPass().equals(pass)){
                return c;
            }
        }
        return null;
    }
    
}
