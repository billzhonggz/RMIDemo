package com.billzhonggz;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Message extends Remote {
    int getVersion() throws RemoteException;
}
