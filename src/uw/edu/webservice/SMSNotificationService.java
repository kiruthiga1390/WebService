package uw.edu.webservice;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMSNotificationService {
	// Find your Account Sid and Token at twilio.com/user/account
	  public static final String ACCOUNT_SID = "XXXXXXXXXXXXXX";
	  public static final String AUTH_TOKEN = "XXXXXXXXXXXX";
	  
	  public static void main(String[] args) {
		    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		    Message message = Message.creator(new PhoneNumber("+12065037649"),
		        new PhoneNumber("+18608502203"), 
		        "This is the ship that made the Kessel Run in fourteen parsecs?").create();

		    System.out.println(message.getSid());
		  }

}
