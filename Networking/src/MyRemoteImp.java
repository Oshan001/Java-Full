import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

interface MyRemote extends Remote
{
         int add(int a,int b)throws RemoteException;
}

public class MyRemoteImp extends UnicastRemoteObject implements MyRemote
    {
        public MyRemoteImp()throws RemoteException
        {
            super();
        }
        public  int add (int a ,int b){
            return a+b;
        }
    }

