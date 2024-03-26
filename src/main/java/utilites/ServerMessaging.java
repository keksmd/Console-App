package utilites;

import com.fasterxml.jackson.core.type.TypeReference;
import exceptions.LOLDIDNTREAD;
import exceptions.Discntcd;
import main.Request;
import main.Response;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import static main.App.log;


public class ServerMessaging {

    public static Request nioRead(SocketChannel clientChannel) throws IOException, LOLDIDNTREAD, Discntcd {
        ByteBuffer buf = ByteBuffer.allocate(1024);
        int readed= clientChannel.read(buf);
                if (readed != -1) {
                    buf.flip();
                    String msg = new String(ByteBuffer.allocate(readed).put(buf.array(),0,readed).array());
                    log.info("readed {}",msg);
                    return ObjectConverter.deserialize(msg, new TypeReference<>() {});
                } else throw new LOLDIDNTREAD();
    }
    public static void nioSend(SocketChannel clientChannel,String message) throws IOException {
        Response resp = new Response();
        resp.addMessage(message);
        message =ObjectConverter.toJson(resp);
        log.info("sended {}",message);
        ByteBuffer buf = ByteBuffer.allocate(message.getBytes().length).put(message.getBytes());
        buf = buf.flip();
        while (buf.hasRemaining()){
            clientChannel.write(buf);
        }
    }
    public static void nioSend(SocketChannel clientChannel,Response resp) throws IOException {
        String message = ObjectConverter.toJson(resp);
        log.info("sended {}",message);
        ByteBuffer buf = ByteBuffer.allocate(message.getBytes().length);

        buf.put(message.getBytes());
        buf = buf.flip();
        while (buf.hasRemaining()){
            clientChannel.write(buf);
        }
    }

}
