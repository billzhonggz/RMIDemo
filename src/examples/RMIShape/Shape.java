package examples.RMIShape;
import java.rmi.*;
import java.util.Vector;

public interface Shape extends Remote {
   int getVersion() throws RemoteException;
   GraphicalObject getAllState() throws RemoteException;
}
