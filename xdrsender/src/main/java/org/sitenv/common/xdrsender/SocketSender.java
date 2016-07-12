package org.sitenv.common.xdrsender;

import java.io.*;
import java.net.*;

public class SocketSender {

	public static String sendMessage(String endpoint, String payload) throws MalformedURLException, UnknownHostException, IOException {

        URL url = new URL(endpoint);

        String hostname = url.getHost();
        int port = url.getPort();
        if (port == -1) {
            port = 80;
        }
        String path = url.getPath();

        InetAddress addr = InetAddress.getByName(hostname);
        
       // SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
       // SSLSocket socket = (SSLSocket) factory.createSocket(addr,port);
        
        Socket socket = new Socket(addr, port);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));

        //   String fullPayload = SimpleSOAPSender.addHttpHeaders(path, payload);
        bufferedWriter.write(payload);
        bufferedWriter.flush();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        return SocketSender.getResponse(bufferedReader);

    }

    private static String getResponse(BufferedReader bufferedReader) throws IOException {

        StringBuilder response = new StringBuilder();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            response.append(line + "\n");
        }
        return response.toString();

    }
    
    
}
