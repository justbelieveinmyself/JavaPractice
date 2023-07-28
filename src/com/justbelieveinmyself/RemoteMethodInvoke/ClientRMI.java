package RemoteMethodInvoke;

import javax.naming.*;
import java.rmi.RemoteException;
import java.util.Enumeration;

public class ClientRMI {
    public static void main(String[] args) throws NamingException, RemoteException {
        Context context = new InitialContext();
        NamingEnumeration<NameClassPair> methods = context.list("rmi://127.0.0.1:1099");
        while(methods.hasMoreElements()){
            System.out.println(methods.nextElement().getName());
        }
        Adder stub = (Adder) context.lookup("rmi://127.0.0.1:1099/adderMeth");
        int result = stub.add(2,5);
        System.out.println(result);
    }
}
