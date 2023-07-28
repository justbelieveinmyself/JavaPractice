package RemoteMethodInvoke;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class AdderImplement extends UnicastRemoteObject implements Adder{
    protected AdderImplement() throws RemoteException{

    }
    @Override
    public int add(int a, int b){
        return a+b;
    }
}
