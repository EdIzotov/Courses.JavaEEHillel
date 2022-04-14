package websockets.version2_with_thread;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class ClientWS {
    public static void main(String[] args) throws IOException {
        try (
                Socket client = new Socket("localhost", 9999);
                InputStream inputStream = client.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                OutputStream outputStream = client.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                PrintWriter printWriter = new PrintWriter(outputStreamWriter, true);
                ) {
            for (String msg: Arrays.asList("msg1", "msg2", "msg3")) {
                printWriter.println(msg);
                String messageFromServer = bufferedReader.readLine();
                System.out.println("msg from server >>> " + messageFromServer);
            }
        }
    }
}
