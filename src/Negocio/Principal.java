package Negocio;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Leonel Otavalo
 */
public class Principal {

    public static void main(String[] args) {
        
        //CREACIÓN DE CADA UNO DE LAS LISTAS
        Cartera_Clientes clientes = new Cartera_Clientes();
        Menu menu = new Menu();
        ListaTransport listtrans = new ListaTransport();
        ListPedidos lisped = new ListPedidos();
        ListCuentas listcue = new ListCuentas();
        
        //INGRESO DE CLIENTES A LA CARTERA DE CLIENTES
        Cliente cl1 = new Cliente("AMAGASI","leoandy28aa@hotmail.com","ANDY","OTAVALO","1727723213","0999011921");
        clientes.addCliente(cl1);
        Cliente cl2 = new Cliente("CUMBAYA","jperez32@gmail.com","JUAN","PEREZ","1707879643","0987654321");
        clientes.addCliente(cl2);
        Cliente cl3 = new Cliente("CARCELEN","mandrade15@gmail.com","MARIA","ANDRADE","1001081065","0980758432");
        clientes.addCliente(cl3);
//        System.out.println(clientes.toString());
        
        //INGRESO DE CUENTAS AL GESTOR DE CUENTAS
        Cuenta c1 = new Cuenta(cl1,"ANDY123");
        listcue.addCuenta(c1);
        Cuenta c2 = new Cuenta(cl2,"JUAN123");
        listcue.addCuenta(c2);
        Cuenta c3 = new Cuenta(cl3,"MARIA123");
        listcue.addCuenta(c3);
        
        //INGRESO DE PLATILLOS AL MENU
        Platillo p1 = new Platillo("ENCOCADO","COMPLETO", (float) 2.50);
        menu.addPlatillo(p1);
        Platillo p2 = new Platillo("ENCEBOLLADO","COMPLETO", (float) 3.50);
        menu.addPlatillo(p2);
        Platillo p3 = new Platillo("CANGREJADA","COMPLETO", (float) 4.50);
        menu.addPlatillo(p3);
        Platillo p4 = new Platillo("ALMUERZO","COMPLETO", (float) 2.25);
        menu.addPlatillo(p4);   
//        System.out.println(menu.toString());
        
        //INGRESO DE TRANSPORTISTAS
        Transportista tr1 = new Transportista("Moto","DA124", "HCB145","PEDRO","QUINTERO","1007896547","0967439065");
        listtrans.addTransportista(tr1);
        Transportista tr2 = new Transportista("Taxi","DF374", "HTB196","LUIS","MONTALVO","1706259603","0999481449");
        listtrans.addTransportista(tr2);
        Transportista tr3 = new Transportista("Moto","DA124", "HJB155","MARCELO","RUIZ","1727728795","0983491449");
        listtrans.addTransportista(tr3);
//        System.out.println(listtrans.toString());

    //INTERACCIÓN CON EL USUARIO
    Scanner sc = new Scanner(System.in);
    int opc;
    String user;
    String pass;
    
        System.out.println("***BIENVENIDO AL RESTAURANTE***");
        System.out.println("1. INICIAR SESION");
        System.out.println("2. REGISTRARSE");
        System.out.println("3. SALIR");
        System.out.println("ESCOJA UNA OPCION: ");
        opc=sc.nextInt();
        
        switch (opc) {
            case 1:
                Cuenta aux=null;
                Factura fac;
                String plat;
                Platillo auxpl;
                int pos,cant,opc2;
                Pedido ped;
                int cont=0;
                do {
                    //PUEDE USAR LOS SIQUIENTES USUARIOS Y CONTRASEÑAS
                    //USER:1727723213 PASS:ANDY123
                    //USER:1707879643 PASS:JUAN123
                    //USER:1001081065 PASS:MARIA123
                    System.out.print("\nINGRESE EL USUARIO: ");
                    user=sc.next();
                    System.out.print("\nINGRESE LA CONTRASEÑA: ");
                    pass=sc.next();
                    aux=listcue.FindCuenta(user,pass);
                    if (aux!=null) {
                        System.out.println("***INICIO DE SESION EXITOSO***");
                        System.out.print("\nDESEA REALIZAR UN PEDIDO ?  \n1.SI \n2.NO\nESCOJA UNA OPCION: ");
                        opc = sc.nextInt();
                        //SI DESEA REALIZAR EL PEDIDO SE PROCEDE A MOSTRAR EL MENU SINO EL PROGRAMA TERMINA
                        if(opc==1){
                            
                            menu.OrdenarNombre();
                            System.out.println(menu.toString());
                            do {
                            //INGRESAMOS EL NOMBRE DEL PLATILLO A PEDIR
                            System.out.print("\nESCOJA UN PLATILLO E INGRESE SU NOMBRE TAL CUAL SE MUESTRA EN LA LISTA: ");
                            plat = sc.next();
                            auxpl = new Platillo(plat,"", (float) 0.00);
                            pos=menu.BusqBinNombre(auxpl);
                            //VERIFICAMOS SI EL NOMBRE DEL PLATILLO ESTA EN EL MENU
                            if(pos>=0){
                                //INGRESAMOS LA CANTIDAD DE PLATILLOS QUE SE VA A PEDIR
                                System.out.print("\nINGRESE LA CANTIDAD DE PLATILLOS QUE DESEA: ");
                                cant = sc.nextInt();
                                //CREAMOS UN NUEVO PEDIDO Y LO AGREGAMOS A LA LISTA
                                ped = new Pedido(menu.getMenu().get(pos),aux.getCli(),tr3,"BIEN CALIENTE", cant);
                                lisped.addPedido(ped);
                                System.out.println("***PEDIDO AGREGADO EXITOSAMENTE***\n");
                            }else{
                                System.out.println("***EL PLATILLO NO EXISTE O SE INGRESO MAL EL NOMBRE***");
                            }
                            //PREGUNTAMOS SI DESEA HACER EL PEDIDO DE OTRO PLATILLO
                            System.out.print("\nDESEA AGREGAR OTRO PEDIDO? \n1.SI\n2.NO\nESCOJA UNA OPCION: ");
                            opc2=sc.nextInt();
                            } while (opc2==1);
                            //OBTENEMOS TODOS LOS PEDIDOS REALIZADOS POR EL CLIENTE
                            //PARA PODER FACTURAR
                            List <Pedido> liscl = lisped.PedidosCliente(aux.getCli());
                            //VERIFICAMOS SI LA LISTA ESTA VACIA
                            if(!liscl.isEmpty()){
                                fac = new Factura(aux.getCli(),liscl);
                                System.out.println(fac.toString());
                            }
                            
                        }else{
                            System.out.println("***OK! CERRANDO SESION***");
                        }
                        
                    }else{
                        System.out.println("****ERROR DE INICIO DE SESION****");
                        cont++;
                    }
                } while (aux==null && cont<3);
                break;
            case 2:
                String nombre;
                String apellido;
                String cedula;
                String telefono;
                String direccion;
                String correo;
                Cliente newclient;
                Cuenta newacount;
                boolean flag=false;
                do{
                //INGRESAMOS LOS DATOS NECESARIOS PARA CREAR UNA NUEVA CUENTA
                System.out.print("\nINGRESE SU NOMBRE: ");
                nombre=sc.next();
                System.out.print("\nINGRESE SU APELLIDO: ");
                apellido=sc.next();
                System.out.print("\nINGRESE SU CEDULA: ");
                cedula=sc.next();
                System.out.print("\nINGRESE SU TELEFONO: ");
                telefono=sc.next();
                //***INGRESAR SOLO EL NOMBRE DE LA CIUDAD PORQUE NO ME PERMITE LEER TEXTO CON ESPACIOS EN BLANCO***
                System.out.print("\nINGRESE SU DIRECCION: ");
                direccion=sc.next();
                System.out.print("\nINGRESE SU CORREO: ");
                correo=sc.next();
                //EL USUARIO DE LA CUENTA ES LA CEDULA
                System.out.print("\nINGRESE UNA CONTRASEÑA: ");
                pass=sc.next();
                
                //VALIDAMOS LOS DATOS INGRESADOS
                if(!(nombre.equals("")) && !(apellido.equals("")) && !(telefono.equals("")) && !(pass.equals("")) && !(cedula.equals(""))){
                    //CREAMOS EL NUEVO CLIENTE Y SU RESPECTIVA CUENTA
                    newclient = new Cliente(direccion,correo,nombre,apellido,cedula,telefono);
                    newacount = new Cuenta(newclient,pass);
                    clientes.addCliente(newclient);
                    listcue.addCuenta(newacount);
                    System.out.println(newclient.toString());
                    System.out.println("***CLIENTE REGISTRADO EXITOSAMENTE***");
                    //PROCEDEMOS A PREGUNTAR SI DESEA REALIZAR UN PEDIDO
                    System.out.print("\nDESEA REALIZAR UN PEDIDO ?  \n1.SI \n2.NO\nESCOJA UNA OPCION: ");
                    opc = sc.nextInt();
                        //SI DESEA REALIZAR EL PEDIDO SE PROCEDE A MOSTRAR EL MENU SINO EL PROGRAMA TERMINA
                    if(opc==1){
                            menu.OrdenarNombre();
                            System.out.println(menu.toString());
                            do {
                            //INGRESAMOS EL NOMBRE DEL PLATILLO A PEDIR
                            System.out.print("\nESCOJA UN PLATILLO E INGRESE SU NOMBRE TAL CUAL SE MUESTRA EN LA LISTA: ");
                            plat = sc.next();
                            auxpl = new Platillo(plat,"", (float) 0.00);
                            pos=menu.BusqBinNombre(auxpl);
                            //VERIFICAMOS SI EL NOMBRE DEL PLATILLO ESTA EN EL MENU
                            if(pos>=0){
                                //INGRESAMOS LA CANTIDAD DE PLATILLOS QUE SE VA A PEDIR
                                System.out.print("\nINGRESE LA CANTIDAD DE PLATILLOS QUE DESEA: ");
                                cant = sc.nextInt();
                                //CREAMOS UN NUEVO PEDIDO Y LO AGREGAMOS A LA LISTA
                                ped = new Pedido(menu.getMenu().get(pos),newclient,tr2,"BIEN CALIENTE", cant);
                                lisped.addPedido(ped);
                                System.out.println("***PEDIDO AGREGADO EXITOSAMENTE***\n");
                            }else{
                                System.out.println("***EL PLATILLO NO EXISTE O SE INGRESO MAL EL NOMBRE***");
                            }
                            //PREGUNTAMOS SI DESEA HACER EL PEDIDO DE OTRO PLATILLO
                            System.out.print("\nDESEA AGREGAR OTRO PEDIDO? \n1.SI\n2.NO\nESCOJA UNA OPCION: ");
                            opc2=sc.nextInt();
                            } while (opc2==1);
                            
                            //OBTENEMOS TODOS LOS PEDIDOS REALIZADOS POR EL CLIENTE
                            //PARA PODER FACTURAR
                            List <Pedido> liscl = lisped.PedidosCliente(newclient);
                            //VERIFICAMOS SI LA LISTA ESTA VACIA
                            if(!liscl.isEmpty()){
                                fac = new Factura(newclient,liscl);
                                System.out.println(fac.toString());
                            }
                    }else{
                            System.out.println("***OK! CERRANDO SESION***");
                    }                
                    flag=true;
                }else{
                    System.out.println("***INGRESE BIEN LOS VALORES DE CADA CAMPO***");
                }
                }while(!flag);
                break;
            default:
                    System.out.println("***SALIENDO DEL SISTEMA***");
                break;
        }
    }

}
