

//OBSERVER
public abstract class DeliveryFactory {
  
	protected Cargo cargo=null;
	
	//cargo delivery time represents minute
	public int deliveryTime; 
		
	public abstract PaymentType createPaymentType();
		
	public abstract Notification createNotification();
	
	public abstract void update();

    
}

