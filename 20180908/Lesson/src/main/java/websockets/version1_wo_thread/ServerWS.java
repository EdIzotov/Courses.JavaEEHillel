package websockets.version1_wo_thread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerWS {
    public static void main(String[] args) throws IOException {
        try (
                ServerSocket serverSocket = new ServerSocket(9999);
                Socket client = serverSocket.accept();
                InputStream inputStream = client.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                OutputStream outputStream = client.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                PrintWriter printWriter = new PrintWriter(outputStreamWriter, true);
                ) {

            String messageFromClient;
            while ((messageFromClient = bufferedReader.readLine()) != null) {
                System.out.println("message >>> " + messageFromClient);
                String newMessageForClientFromServer = messageFromClient.toUpperCase();
                printWriter.println(newMessageForClientFromServer);
            }
        }
    }
}
