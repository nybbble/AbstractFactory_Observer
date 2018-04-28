
public class OnlineDeliveryFactory extends DeliveryFactory{

	
	public OnlineDeliveryFactory(Cargo cargo)
	{
		this.cargo=cargo;
		this.cargo.attach(this);
		//online delivery time is 30 minute
		deliveryTime = 30; 
	}
	
	@Override
	public PaymentType createPaymentType() {
		return new Transfer();
	}

	@Override
	public Notification createNotification() {
		return new Email();
	}

	@Override
	public void update() {
		System.out.println("");
		System.out.println("");
		System.out.println("Cargo state has been updated as '"+cargo.state+"' to Online Delivery Factory.");
		System.out.println("");
		
	}

}
