import java.rmi.*;
import java.rmi.registry.*;


/*
 * Execute:
 * java FactorialClient
 */
public class FactorialClient {
	
	private static final String HOST = "localhost";
	private static final int PORT = Registry.REGISTRY_PORT; // 1099
	
	public static void main(String[] args) {
				
		try { 
			// Locate rmi registry
			
			Registry registry = LocateRegistry.getRegistry(HOST, PORT);
			
			// Look up for a soecific name and get remote reference (stub)
			String rmiObjectName = "Factorial";
			Factorial ref = (Factorial)registry.lookup(rmiObjectName);
			
			// Do remote method invocation
			//int result = ref.fact(5);			
			
			System.out.println("Give number to compute pi ");
			int number = System.in.read();
			double result = ref.ComputePi(number);
			System.out.println("The pi is " + result);
			
			
		} catch (RemoteException re) {
			System.out.println("Remote Exception");
			re.printStackTrace();
		} catch (Exception e) {
			System.out.println("Other Exception");
			e.printStackTrace();
		}
	}
}

