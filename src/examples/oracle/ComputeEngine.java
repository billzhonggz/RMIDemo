package examples.oracle;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ComputeEngine implements Compute {
    public ComputeEngine(){
        super();
    }

    public <T> T executeTask(Task<T> t){
        return t.execute();
    }

    public static void main(String args[]){
        if (System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "Compute";
            Compute engine = new ComputeEngine();
            Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);
            Registry registry = LocateRegistry.getRegistry();
            // From https://stackoverflow.com/questions/1823305/rmi-connection-refused-with-localhost
            // Registry registry = LocateRegistry.createRegistry(2020);
            registry.rebind(name, stub);
            System.out.println("Compute Engine bound");
        } catch (Exception e) {
            System.err.println("Compute Engine exception:");
            e.printStackTrace();
        }
    }
}
