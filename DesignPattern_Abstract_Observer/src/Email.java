
public class Email implements Notification{

    @Override
    public void sendMessage(final String text) {
       
    	System.out.print("The contents of ' " + text + " ' have been sent by e-mail.\n");
    	//System.out.println("");
    }
    
}
