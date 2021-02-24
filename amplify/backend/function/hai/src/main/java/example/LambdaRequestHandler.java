package example;

import com.amazonaws.services.lambda.runtime.Context; 
import com.amazonaws.services.lambda.runtime.RequestHandler;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

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
			
			sendGET();
		
        } catch (UnknownHostException e1) {
			e1.printStackTrace ();
            greetingString = e1.getMessage();
        } catch (IOException e) {
			e.printStackTrace ();
            greetingString = e.getMessage();
        }
		
		
        return new ResponseClass(greetingString);
    }
	
	private static void sendGET() throws IOException {
		URL obj = new URL("https://www.google.com");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("GET request not worked");
		}

	}
}