package example;


import java.util.HashMap;
import java.util.Map;

public class ResponseClass {

    private boolean isBase64Encoded = false;

    private int statusCode = 200;

	private Map<String, String> headers= new HashMap<String, String> ();

    private String body;

	
	public ResponseClass(){
		headers.put("Access-Control-Allow-Origin", "*");
	}

    public boolean getIsBase64Encoded () {
        return isBase64Encoded;
    }


    public void setIsBase64Encoded (boolean isBase64Encoded) {
        this.isBase64Encoded = isBase64Encoded;
    }


    public void setStatusCode (int statusCode) {
        this.statusCode = statusCode;
    }


    public Map<String, String> getHeaders () {
        return headers;
    }


    public void setHeaders (Map<String, String> headers) {
        this.headers = headers;
    }


    public String getBody () {
        return body;
    }


    public void setBody (String body) {
        this.body = body;
    }

}
