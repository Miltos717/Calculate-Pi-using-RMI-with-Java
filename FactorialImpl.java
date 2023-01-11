import java.rmi.*;
import java.rmi.server.*;
import java.util.HashMap;


public class FactorialImpl extends UnicastRemoteObject implements Factorial {
	
	private static final long serialVersionUID = 1;
	
	// We create a Hash Map to store the results of the pi calculation
	private HashMap<Integer,Double> map = new HashMap<Integer,Double>();
	
	// Constructor
	public FactorialImpl() throws RemoteException {
	}
	
	// Computing the PI with the number that the Client send
	public double ComputePi(int number) {
		
		if(map.containsKey(number)) {
			System.out.println("The number is already in Map");
			return map.get(number);
		}
		else {
			double step = 1.0 / (double)number;
	        double sum=0.0;
	        for (long i=0; i < number; ++i) {
	            double x = ((double)i+0.5)*step;
	            sum += 4.0/(1.0+x*x);
	        }
	        double pi = sum * step;
	        map.put(number, pi);
	        return pi;
		}      
	}
	
}
