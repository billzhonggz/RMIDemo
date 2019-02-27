package com.billzhonggz;

import java.rmi.RemoteException;

public class MessageServant implements Message {
    private String message;
    private int version;

    public MessageServant() throws RemoteException{
        message = new String();
        version = 0;
    }

    public String newMessage(String mString) throws RemoteException {
        version++;
        message = mString;
        return message;
    }

    public int getVersion() throws RemoteException{
        return version;
    }
}
