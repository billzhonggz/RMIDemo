package com.billzhonggz;

import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;

public class MessageServer {
    public static void main(String args[]) {
        System.setSecurityManager(new SecurityManager());
        try {
            Message aMessage = new MessageServant();
            Message stub = (Message) UnicastRemoteObject.exportObject(aMessage, 0);
            Naming.rebind("Message", aMessage);
            System.out.println("Message server ready");
        } catch (Exception e) {
            System.out.println("Message server `main` " + e.getMessage());
            e.printStackTrace();
        }
    }
}
