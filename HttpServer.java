import java.io.*; 
import java.net.*;

class HttpServer 
{  
    private static final String USER_AGENT = "Google Chrome"; 
    static String sendGET(String GET_URL) throws IOException 
    { 
        URL obj = new URL(GET_URL); 
        HttpURLConnection con = (HttpURLConnection) obj.openConnection(); 
        con.setRequestMethod("GET"); 
        con.setRequestProperty("User-Agent", USER_AGENT); 
        int responseCode = con.getResponseCode(); 
        System.out.println("GET Response Code :: " + responseCode); 
        if (responseCode == HttpURLConnection.HTTP_OK) 
        { 
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())); 
            String inputLine; 
            StringBuffer response = new StringBuffer(); 
            while ((inputLine = in.readLine()) != null) 
            { 
                response.append(inputLine); 
            } 
            in.close(); 
            System.out.println(response.toString()); 
            return(response.toString()); 
        } 
        else 
        { 
            System.out.println("GET request not worked"); 
            return (null); 
        }
    } 
    public static void main(String a[]) throws Exception 
    { 
        ServerSocket ss=new ServerSocket(6789); 
        while(true){ 
            Socket consoc= ss.accept(); 
            BufferedReader ifc =new BufferedReader(new InputStreamReader(consoc.getInputStream())); 
            DataOutputStream otc =new DataOutputStream(consoc.getOutputStream()); 
            String cs=ifc.readLine()+'\n'; 
            System.out.println("RECEIVED : "+cs); 
            String GET_URL = cs; 
            otc.writeBytes(sendGET(GET_URL)+'\n'); 
            System.out.println("GET DONE"); 
        }
    } 
}