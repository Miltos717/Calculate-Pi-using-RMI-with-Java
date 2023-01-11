import java.rmi.*;

public interface Factorial extends Remote {
	
	// remote method signature
	
	public double ComputePi(int number) throws RemoteException;

}
