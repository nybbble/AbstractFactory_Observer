import java.util.Scanner;

public class Client {

	static Scanner scan = new Scanner(System.in);
	
	private static DeliveryFactory factory;
	private static DeliveryFactory factory2;

	public static void main(final String[] args) {

		factory = null;
		factory2=null;

		Cargo cargo = new Cargo();

		System.out.println("");
		System.out.println("");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("--------------------WELCOME TO Busra&Yagmur ORDER SYSTEM--------------------");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("");
		System.out.println("");
		System.out.println("Our city is ANKARA.");
		System.out.println("");
		System.out.println("Price: 100 liras.");
		System.out.println("");
		System.out.println("");
		//System.out.print("Please press 1 if you want to order another place, :");


		/*
		String choice = scan.nextLine();
		System.out.println("");
		System.out.println("");

		if (choice == "1") 
		{
			System.out.print("Please enter your city:");

			String specificAddress = scan.next();

			System.out.println("");
			System.out.println("");
			cargo.setCargoAddress(specificAddress);
			System.out.println("New address is "+cargo.getCargoAddress());

		} else
		{
			System.out.println("Address determined as default: ANKARA.");
		}*/
		System.out.println("");
		System.out.println("");

		System.out.println("----------------------------------------------------------------------------");
		System.out.println("                          Let's set order now!");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("");

		
		System.out.println("Online Delivery Information:");
		System.out.println("-----Fast shopping.");
		System.out.println("-----Notifications are given by email.");
		System.out.println("-----Payment type is transfer.");
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		System.out.println("Store Delivery Information:");
		System.out.println("-----Store shopping.");
		System.out.println("-----Notifications are given by SMS.");
		System.out.println("-----Payment type is cash money.");
		
		System.out.println("");
		System.out.println("");
		 
		System.out.print("Please enter the order type you want { Online/Store/Both } :");

		//user select delivery type
		String deliveryType = scan.next();
		System.out.println("");
		System.out.println("");

		while(true)
		{
			switch(deliveryType)
			{
				case  "Online":
				{					
					System.out.println("");					
					
					//online factory created
					factory = new OnlineDeliveryFactory(cargo);
					
					System.out.println("Order created.");
							
					factory.deliveryTime = 10;
					System.out.println(factory.deliveryTime+"  minutes passed");
					System.out.println();
					
					//payment and notification assigned by online factory.
					final PaymentType pType = factory.createPaymentType();					
					final Notification n = factory.createNotification();
					
					System.out.println("Payment type and notification prepared.");
					
					factory.deliveryTime+=10;
					System.out.println(factory.deliveryTime+"  minutes passed");
					System.out.println("");
					
					pType.sendMoney(100);
					//n.sendMessage("Preparing Order");

					// cargo.attach(factory);
					// System.out.println(""+cargo.state);

					//cargo state is notified all factories.
					cargo.notifyAllObservers();
					n.sendMessage("Preparing Order");

					
					System.out.println();
					
					
					factory.deliveryTime+=10;
					
					if(factory.deliveryTime == 30)
					{
						System.out.println("30 minutes has expired !");
						cargo.changeState("Cargo is on the road.");
						n.sendMessage("Cargo is on the road.");
					}
					
					break;
				} 
				case "Store":
				{
					factory = new StoreDeliveryFactory(cargo);
					
					factory.deliveryTime=10;
					
					final PaymentType pType = factory.createPaymentType();
					final Notification n = factory.createNotification();
					
					factory.deliveryTime+=10;

					pType.sendMoney(100);
					//n.sendMessage("Preparing Order");
			
					// cargo.attach(factory);
					// System.out.println(""+cargo.state);

					cargo.notifyAllObservers();
					
					n.sendMessage("Preparing Order");
					
					System.out.println();

					factory.deliveryTime+=10;
					
					System.out.println("");
					
				
					if(	factory.deliveryTime == 120)
					{
						cargo.changeState("Cargo is on the road.");
						n.sendMessage("Cargo is on the road.");
						break;
					}
					else
					{
						System.out.println("Please wait your cargo.");
					
						int hour = 0;
							
						while(hour==0)
						{
							factory.deliveryTime+=10;
								
							hour += factory.deliveryTime/60;
								
							while(hour==1)
							{
								System.out.println(hour+" hour(s) passed.");
								hour += factory.deliveryTime/60;
								if(hour==2)
									break;
							}
						}
							
						System.out.println(hour+" hour(s) passed.");
							
						cargo.changeState("Cargo is on the road.");
						n.sendMessage("Cargo is on the road.");
							
					}
					break;
				}
				case "Both":
				{
					
					factory = new StoreDeliveryFactory(cargo);
					factory2 = new OnlineDeliveryFactory(cargo);
					
					factory.deliveryTime=10;
					factory2.deliveryTime=100;
					
					final PaymentType pType = factory.createPaymentType();
					final Notification n = factory.createNotification();
					
					
					final PaymentType pType2 = factory2.createPaymentType();
					final Notification n2 = factory2.createNotification();
					
					factory.deliveryTime+=10;
					factory2.deliveryTime+=100;

					System.out.println("Store Delivery System Processes: ");
					System.out.println();
					pType.sendMoney(100);
					n.sendMessage("Preparing Order");
					
					System.out.println("");
					System.out.println("");
					
					System.out.println("Online Delivery System Processes: ");
					System.out.println();
					pType2.sendMoney(100);
					n2.sendMessage("Preparing Order");
			
					// cargo.attach(factory);
					// System.out.println(""+cargo.state);

					cargo.notifyAllObservers();

					factory.deliveryTime+=10;
					factory2.deliveryTime+=100;
					
					System.out.println("");
					
				
					if(	factory.deliveryTime == 120 && factory2.deliveryTime==300)
					{
						cargo.changeState("Cargo is on the road.");
						n.sendMessage("Cargo is on the road.");
						break;
					}
					else
					{
						System.out.println("Please wait your cargo for Stores.");
					
						int hour = 0;
						
						while(hour==0)
						{
							factory2.deliveryTime+=50;
								
							hour += factory2.deliveryTime/60;
								
							while(hour==1)
							{
								System.out.println(hour+" hour(s) passed.");
								hour += factory2.deliveryTime/60;
								if(hour==2)
									break;
							}
						}
							
						System.out.println(hour+" hour(s) passed.");
				
						System.out.println();
						
						cargo.changeState("Cargo is on the road.");
						System.out.println();
						n.sendMessage("Cargo is on the road.");
						System.out.println();
						n2.sendMessage("Cargo is on the road.");
						System.out.println();
							
					}
					
					break;
				}
				default:
				{
					System.out.println("You made the wrong choice.");
					break;
				}
			}
			break;
		}
		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------------G-O-O-D-B-Y-E------------------------------------");
		System.out.println("---------------------------Thank you for choosing us-----------------------------");
		System.out.println("");
		System.out.println("");

		

	}
}
