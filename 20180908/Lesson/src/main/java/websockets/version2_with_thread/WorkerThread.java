package websockets.version2_with_thread;

import javax.imageio.IIOException;
import java.io.*;
import java.net.Socket;

public class WorkerThread extends Thread {
    private Socket client;

    public WorkerThread() {
    }
    public WorkerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try (
                InputStream inputStream = client.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                OutputStream outputStream = client.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                PrintWriter printWriter = new PrintWriter(outputStreamWriter, true);
                ) {
            String messageFromClient;
            while ((messageFromClient = bufferedReader.readLine()) != null) {
                System.out.println(currentThread().getName() + " >>> msg from client >>> " + messageFromClient);
                String newMessageFromServerWorkerThreadForClient = messageFromClient.toUpperCase();
                printWriter.println(newMessageFromServerWorkerThreadForClient);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
