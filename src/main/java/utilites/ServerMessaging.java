package utilites;

import com.fasterxml.jackson.core.type.TypeReference;
import exceptions.LOLDIDNTREAD;
import exceptions.Discntcd;
import main.Response;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;


public class ServerMessaging {
    public static void send(Socket socket,String message) throws IOException {
        OutputStream os = socket.getOutputStream();
        Response resp = new Response();
        resp.getMessages().add(message);
        os.write(ObjectConverter.toJson(resp).getBytes());
        os.write(-1);
    }
    public static Response nioRead(SocketChannel clientChannel) throws IOException, LOLDIDNTREAD, Discntcd {
        ByteBuffer buf = ByteBuffer.allocate(1024);
        int readed = clientChannel.read(buf);
        if(readed>0){
            return ObjectConverter.deserialize(new String(buf.flip().array(), 0, readed), new TypeReference<Response>() {});
        } else if (readed==-1) {
            throw new Discntcd();
        } else  throw new LOLDIDNTREAD();

    }
    public static void nioSend(SocketChannel clientChannel,String message) throws IOException {
        Response resp = new Response();
        resp.addMessage(message);
        ByteBuffer buf = ByteBuffer.allocate(1024).put(ObjectConverter.toJson(resp).getBytes());
        clientChannel.write(buf);
    }
    public static void nioSend(SocketChannel clientChannel,Response resp) throws IOException {
        ByteBuffer buf = ByteBuffer.allocate(1024).put(ObjectConverter.toJson(resp).getBytes());
        clientChannel.write(buf);
    }
    public static void send(Socket socket,Response resp) throws IOException {
        OutputStream os = socket.getOutputStream();
        os.write(ObjectConverter.toJson(resp).getBytes());
        os.write(-1);
    }

    public static Response recieve(Socket socket) throws IOException{
        InputStream is =  socket.getInputStream();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte b;
        while ((b = (byte)is.read())!=-1) {
            buffer.write(b);
        }
        if(buffer.size()==0){
            throw new IOException();
        }
        return ObjectConverter.deserialize(buffer.toString(StandardCharsets.UTF_8), new TypeReference<Response>() {});

    }
}
