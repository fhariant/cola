package example;

import com.amazonaws.services.lambda.runtime.Context; 
import com.amazonaws.services.lambda.runtime.RequestHandler;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class LambdaRequestHandler implements RequestHandler<RequestClass, ResponseClass>{   

    public ResponseClass handleRequest(RequestClass request, Context context){
        String greetingString = null;
		int timeout = 2000;
        try {
            InetAddress[] addresses = InetAddress.getAllByName ("www.google.com");
            for (InetAddress address: addresses) {
                if (address.isReachable (timeout))
                    greetingString = "It is reachable";
                else
                    greetingString = "could not be contacted: " + address;
            }
        } catch (UnknownHostException e1) {
			e1.printStackTrace ();
            greetingString = e1.getMessage();
        } catch (IOException e) {
			e.printStackTrace ();
            greetingString = e.getMessage();
        }
		
        return new ResponseClass(greetingString);
    }
}