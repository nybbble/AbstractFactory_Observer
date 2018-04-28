
public class StoreDeliveryFactory extends DeliveryFactory{

	public StoreDeliveryFactory(Cargo cargo)
	{
		this.cargo = cargo;
		this.cargo.attach(this);
		//with order from store delivery time is 5 hour.
		deliveryTime = 300;
	}
	
	@Override
	public PaymentType createPaymentType() {
		return new CashMoney();
	}

	@Override
	public Notification createNotification() {
		return new Sms();
	}

	@Override
	public void update() {
		System.out.println("");
		System.out.println("");
		System.out.println("Cargo state has been updated as '"+cargo.state+"'  to Store Delivery Factory");
		System.out.println("");
		
	}


    
}
