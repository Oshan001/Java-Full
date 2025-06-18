import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class MyRemoteServer{
    public static void main(String[] args)throws Exception {
        MyRemoteImp obj = new MyRemoteImp();
        LocateRegistry.createRegistry(1099);
        System.out.println("Rmi Register started");
        Naming.rebind("MYOBJ",obj);
    }
}