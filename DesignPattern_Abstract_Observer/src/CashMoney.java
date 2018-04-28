
public class CashMoney implements PaymentType{

    @Override
    public void sendMoney(final int amount) 
    {    	
        System.out.print("' " + amount + " ' TL will be paid in cash ( payment at the door ).\n");
        //System.out.println("");
    }
    
}
