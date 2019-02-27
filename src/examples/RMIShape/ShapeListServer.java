package examples.RMIShape;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
public class ShapeListServer {
	public static void main(String args[]){
         System.setSecurityManager(new RMISecurityManager());
        try{
            ShapeList aShapeList = new ShapeListServant();
            ShapeList stub = (ShapeList) UnicastRemoteObject.exportObject(aShapeList,0);
			Naming.rebind("ShapeList", aShapeList);
            System.out.println("ShapeList server ready");
        }catch(Exception e) {
            System.out.println("ShapeList server main " + e.getMessage());
            e.printStackTrace();
        }
    }
}
