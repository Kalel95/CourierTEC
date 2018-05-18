/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourierTEC.capalogica.Gestion;

//import com.sun.xml.internal.ws.api.message.Message;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
/**
 *
 * @author xvagl
 */
public class sms {
    private void EnviarSMS(String Texto, String Numero){
	String ACCOUNT_SID = "AC0d7fc176befd7e76575708eab68cf504";
	     String AUTH_TOKEN = "d0f1f7af55045d868f2963733bec125e ";

	    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	    Message message = Message.creator( new PhoneNumber(Numero),new PhoneNumber("+17327332852"),
	        
	        Texto).create();

	    System.out.println(message.getSid());
	  }
    
}
