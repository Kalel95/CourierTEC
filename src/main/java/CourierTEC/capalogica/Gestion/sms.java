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
	String ACCOUNT_SID = "ACc6785efb7a6e1aa1198ba554af5b449d";
	     String AUTH_TOKEN = "f06648034582dcd95a8c60d6d7dc730a ";

	    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	    Message message = Message.creator( new PhoneNumber(Numero),new PhoneNumber("+17327332852"),
	        
	        Texto).create();

	    System.out.println(message.getSid());
	  }
    
}
