package sendsms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import constant.Constant;

public class Sendsms
{
	public static void sendSms(String message,String number) 	
	{ 	
		try 		
		{ 		 		
				
			//important step... 
				
			message=URLEncoder.encode(message, "UTF-8"); 	
			String myUrl=Constant.URL+Constant.APIKEY+Constant.SEND_ID+Constant.SENDID+Constant.MESSAGE+message+Constant.LANGUAGE+Constant.LANGUAGE_+Constant.ROUTE_ID+Constant.ROUTE+Constant.NUMBER+number; 		 	
					
			//sending get request using java..
					
			URL url=new URL(myUrl); 		 	
			HttpsURLConnection con=(HttpsURLConnection)url.openConnection(); 		 		 	
			con.setRequestMethod("GET"); 		 		
			con.setRequestProperty(Constant.AGENT, Constant.MOZILLA); 		
			con.setRequestProperty(Constant.CONTROL, Constant.CACHE);
			// console output
			System.out.println("Wait..SMS IS SENDING............"); 		 	
			int code=con.getResponseCode(); 		 		
			System.out.println("Response code : "+code); 		 	
			StringBuffer response=new StringBuffer(); 		 	
			BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream())); 		 
			while(true) 		
			{ 		
				String line=br.readLine(); 			
				if(line==null) 			
				{ 				
						break;
				} 			
				response.append(line); 		
			} 		 		
			System.out.println(response); 		 		 		
		}
		catch (Exception e) 
		{ 	
			e.printStackTrace(); 		
		} 		 	
	} 
}
