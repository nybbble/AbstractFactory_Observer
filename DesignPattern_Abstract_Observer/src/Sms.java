
public class Sms implements Notification{

    @Override
    public void sendMessage(String text) 
    {
        System.out.print("The contents of ' " + text + " ' have been sent by SMS.");
        //System.out.println("");
    }
    
}
