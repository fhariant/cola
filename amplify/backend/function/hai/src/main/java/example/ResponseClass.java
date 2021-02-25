package example;

public class ResponseClass {

    private boolean isBase64Encoded = false;

    private int statusCode = 200;

    private String headers = "\"Access-Control-Allow-Origin\":\"*\"";

    private String body;


    public boolean getIsBase64Encoded () {
        return isBase64Encoded;
    }


    public void setIsBase64Encoded (boolean isBase64Encoded) {
        this.isBase64Encoded = isBase64Encoded;
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
