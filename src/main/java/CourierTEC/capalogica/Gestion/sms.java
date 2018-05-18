/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourierTEC.capalogica.Gestion;

 
import com.twilio.Twilio; 
import com.twilio.rest.api.v2010.account.Message; 
import com.twilio.rest.api.v2010.account.MessageCreator; 
import com.twilio.type.PhoneNumber; 
 
import java.math.BigDecimal; 
import java.net.URI; 
import java.util.ArrayList; 
import java.util.List; 
 
public class sms { 
    private final static String ACCOUNT_SID = "ACc6785efb7a6e1aa1198ba554af5b449d"; 
    private final static String AUTH_TOKEN = "f06648034582dcd95a8c60d6d7dc730a"; 
 
    public static void main(String[] args) { 
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        String Numero = "+50663420702";
        String Texto = "Hola";

	    Message message = Message.creator( new PhoneNumber(Numero),new PhoneNumber("+18603002179"),
	        
	        Texto).create();

	    System.out.println(message.getSid());
    } 
}