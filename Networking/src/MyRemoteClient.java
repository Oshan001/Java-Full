import java.rmi.Naming;

public class MyRemoteClient {
    public static void main(String[] args) throws Exception{
        MyRemote obj=(MyRemote) Naming.lookup("rmi://localhost/MYOBJ");
        System.out.println("Result from Remote call :"+obj.add(10,10));
    }
}