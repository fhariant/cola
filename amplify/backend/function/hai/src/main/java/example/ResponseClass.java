

package example;
        
 public class ResponseClass {

    private boolean base64Encoded = false;

    private int statusCode = 200;

    private String headers = "Access-Control-Allow-Origin:*";

    private String body;


    public boolean isBase64Encoded () {
        return base64Encoded;
    }


    public void setBase64Encoded (boolean base64Encoded) {
        this.base64Encoded = base64Encoded;
    }


    public int getStatusCode () {
        return statusCode;
    }


    public void setStatusCode (int statusCode) {
        this.statusCode = statusCode;
    }


    public String getHeaders () {
        return headers;
    }


    public void setHeaders (String headers) {
        this.headers = headers;
    }


    public String getBody () {
        return body;
    }


    public void setBody (String body) {
        this.body = body;
    }

}
