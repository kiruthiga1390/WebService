package uw.edu.webservice;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMSNotificationService {
	// Find your Account Sid and Token at twilio.com/user/account
	  public static final String ACCOUNT_SID = "XXXXXXXXXXXXXX";
	  public static final String AUTH_TOKEN = "XXXXXXXXXXXX";
	  
//	  public static final String ACCOUNT_SID = "ACcb1ee2d94ff1e158f945eaec38fd1c2e";
//	  public static final String AUTH_TOKEN = "66b05150b766ed526fd6b8948d8fb8fa";
	  
	 
	  
	  public void sendNotification(String notify, String caretaker_no) {
		    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		    Message message = Message.creator(new PhoneNumber(caretaker_no),
		        new PhoneNumber("+18608502203"), 
		        notify).create();

		    System.out.println(message.getSid());
		  }

}
