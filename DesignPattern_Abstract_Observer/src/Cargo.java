import java.util.ArrayList;

//SUBJECT
public class Cargo {
	
	//OBSERVERS=FACTORIES    
	private ArrayList<DeliveryFactory> observers = new ArrayList<DeliveryFactory>();
	
	public String state = "Cargo is preparing.";

	final String defaultAddress = "ANKARA";
	


	public void changeState(String state) {
		this.state = state;
		notifyAllObservers();
	}
	
	public void attach(DeliveryFactory observer)
	{
		observers.add(observer);
	}
	
	public void notifyAllObservers()
	{
		for(DeliveryFactory observer:observers)
		{
			observer.update();
		}
	}
	
	
    
}
