package websockets.version2_with_thread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerWS {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = new ServerSocket(9999);
        while (true) {
            Socket client = serverSocket.accept();
            WorkerThread workerThread = new WorkerThread(client);
            executorService.submit(workerThread);
        }
    }
}
