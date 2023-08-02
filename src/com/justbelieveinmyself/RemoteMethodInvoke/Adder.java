package com.justbelieveinmyself.RemoteMethodInvoke;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Adder extends Remote {
    int add(int a, int b) throws RemoteException;
}