
public class Transfer implements PaymentType{

    @Override
    public void sendMoney(int amount) {
        
        System.out.print("' " + amount + " ' TL money was sent by transfer.\n");
        //System.out.println("");
    }
    
}
