package websockets.version3_nio_selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class ClientWS {
    public static void main(String[] args) throws IOException {
        InetSocketAddress socketAddress = new InetSocketAddress("localhost", 9999);
        try (SocketChannel client = SocketChannel.open(socketAddress);) {
            for (String msg: Arrays.asList("msg1", "msg2", "msg3", "msg4", "msg5", "msg6", "msg7", "msg8")) {
                ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
                client.write(byteBuffer);
            }
        }
    }
}
