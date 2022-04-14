package websockets.version3_nio_selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Arrays;
import java.util.Set;

public class ServerWS {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress("localhost", 9999));
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while(true) {
            int numberOfClients = selector.select();
            if (numberOfClients <= 0) continue;
            System.out.println(numberOfClients);
            Set<SelectionKey> selectionKeys = selector.keys();
            for (SelectionKey selectionKey: selectionKeys) {
                System.out.println("aaa");
                if (selectionKey.isValid()) {
                    if (selectionKey.isAcceptable()) {
                        ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
                        SocketChannel client = channel.accept();
                        if (client != null) {
                            client.configureBlocking(false);
                            client.register(selector, SelectionKey.OP_READ);
                        }
                    } else if (selectionKey.isReadable()) {
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        SocketChannel client = (SocketChannel) selectionKey.channel();
                        int originalSize = client.read(buffer);
                        while (originalSize > 0) {
                            byte[] messageWithOriginalSize = new byte[originalSize];
                            System.arraycopy(buffer.array(), 0, messageWithOriginalSize, 0, originalSize);
                            System.out.println("msg from client >>> " + new String(messageWithOriginalSize));
                            originalSize = client.read(buffer);
                        }
                    }
                }
            }
        }
    }
}
