package uw.edu.webservice;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


/*
 * This web service handles  the functionality of generating notification and sending it to the caretaker,
 * if the patient's vital signs are not in the normal range.
 */
public class SMSNotificationService {
	
	  public static final String ACCOUNT_SID = "XXXXXXXXXXXXXX";
	  public static final String AUTH_TOKEN = "XXXXXXXXXXXX";

	  public void sendNotification(String notify, String caretaker_no) {
		    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		    Message message = Message.creator(new PhoneNumber(caretaker_no),
		        new PhoneNumber("+18608502203"), 
		        notify).create();

		    System.out.println(message.getSid());
		  }

}
