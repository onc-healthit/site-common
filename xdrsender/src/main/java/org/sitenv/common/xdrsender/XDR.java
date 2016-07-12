package org.sitenv.common.xdrsender;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

public class XDR {
	
	private static String sendMessage(String endpoint,String doc, String name, String directTo, String directFrom, String replyTo, String metadata) {
		metadata = XDRUtilities.replaceHeaders(metadata, directFrom, directTo, replyTo);
		String ccda = doc;
		String mtomPackage = XDRUtilities.createMtomPackage(metadata, ccda);
		String payload = XDRUtilities.addHTTPHeadersToPayload(endpoint, mtomPackage);
		
		System.out.println(" PAYLOAD === " + payload);
		
		String response = "";
		try {
			response = SocketSender.sendMessage(endpoint, payload);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Response = " + response);
		return response;
	}
	
	public static String sendValidFullXDRMessage(String endpoint,String doc, String name, String directTo, String from, String replyTo) {
		String metadata = XDRUtilities.getXDRFullTemplate("Xdr_full_metadata_only.xml");
		return sendMessage(endpoint,doc,name,directTo,from,replyTo, metadata);
	}
	
	public static String sendValidMinimalXDRMessage(String endpoint,String doc, String name, String directTo, String directFrom, String replyTo) {
		String metadata = XDRUtilities.getXDRFullTemplate("Xdr_minimal_metadata_only.xml");
		return sendMessage(endpoint,doc,name,directTo,directFrom,replyTo, metadata);
	}
}
