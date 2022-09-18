package Negocio;

/**
 *
 * @author Leonel Otavalo
 */
public class Cuenta {
    private Cliente cli;
    private String user;
    private String pass;

    public Cuenta(Cliente cli, String pass) {
        this.cli = cli;
        this.pass = pass;
        this.user = cli.getCedula();
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
    
}
