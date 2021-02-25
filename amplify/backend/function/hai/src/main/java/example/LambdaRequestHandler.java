package example;

import com.amazonaws.services.lambda.runtime.Context; 
import com.amazonaws.services.lambda.runtime.RequestHandler;

 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.KeyStore;

import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class LambdaRequestHandler implements RequestHandler<RequestClass, ResponseClass>{   

    public ResponseClass handleRequest(RequestClass request, Context context){
        String greetingString = null;
		int timeout = 2000;
        try {
		 
			System.out.println("sendREST()");
			greetingString= sendREST();
		
        } catch (Exception e) {
			e.printStackTrace ();
            greetingString = e.getMessage();
        } 
		
		ResponseClass resp= new ResponseClass();
		resp.setBody(greetingString);
        return resp;
    }
	
	private static String sendREST(){
		try {
			String url= System.getenv("URL_ME");
			System.out.println("Target REST: " + url);
			 

           
            RestTemplate restTemplate = new RestTemplate ( );	
			
			 
			ResponseEntity<String> response = restTemplate.getForEntity (url, String.class);
			return response.getBody();
		} catch (Exception e) {
            e.printStackTrace ();
            return e.getMessage ();
        }
	}
	
	private static void sendGET() throws IOException {
		String url= System.getenv("URL_ME");
		System.out.println("Target: " + url);
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
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