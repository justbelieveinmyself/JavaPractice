package com.justbelieveinmyself.RemoteMethodInvoke;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class ServerRMI { //not working
    public static void main(String[] args) throws NamingException, RemoteException, MalformedURLException, AlreadyBoundException {
        Context context = new InitialContext();
        context.rebind("rmi://127.0.0.1:1099/adderMeth", new AdderImplement()); //dont forget start rmiregistry in cmd or java/bin/rmiregistry.exe
        //Naming.bind("adderMeth", new AdderImplement()); // -Djava.rmi.server.codebase=http://localhost:1099/adderMeth
    }
}



