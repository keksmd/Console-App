
package main;

import com.fasterxml.jackson.core.type.TypeReference;
import exceptions.Discntcd;
import exceptions.LOLDIDNTREAD;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;

import static utilites.ObjectConverter.readAndUpdate;
import static utilites.ServerMessaging.*;

public class App {
    private static ServerSocket serverSocket;
    private static Selector selector;
    private static Socket socket;
    private static ServerSocketChannel serverSocketChannel;

    public static Socket getSocket() {
        return socket;
    }
    private static final Logger log = LogManager.getLogger();

    static void inizializeSokets(){
        try {
            log.info("Программа запущенна");
            serverSocket = new ServerSocket( 8081);
            socket = serverSocket.accept();
            log.info("Соединение с клиентом установлено");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static void inizializeSokets2(){
        try {
            log.info("Программа запущенна");
             serverSocketChannel = ServerSocketChannel.open();
           serverSocketChannel.bind(new InetSocketAddress(8081));
            serverSocketChannel.configureBlocking(false);
            selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static SocketChannel clientChannel;
    public static final String fileName = System.getenv("JSON_LIB");
    private App(){
    }
    public static void main(String[] args) {

        inizializeSokets();
        try {

            File f  = new File(fileName);
            if (f.exists()) {
                CollectionManager.lastUpdated = new Date(f.lastModified());
                if (f.length() > 0) {
                    CollectionManager.collection.addAll(readAndUpdate(fileName, new TypeReference<>() {
                    }));
                }
            } else {
                new File(fileName).createNewFile();
            }

            while ((socket.isBound())) {//true


                //
                String serverMessage = "";
                selector.select();//сервер заблокирован
                Iterator<SelectionKey> keysIterator= selector.selectedKeys().iterator();
                while (keysIterator.hasNext()){
                    SelectionKey key = keysIterator.next();
                    keysIterator.remove();
                    Response resp =new Response();

                    if(key.isAcceptable()){
                        clientChannel = serverSocketChannel.accept();
                        clientChannel.configureBlocking(false);
                        clientChannel.register(selector, SelectionKey.OP_READ);

                    }else if(key.isReadable()){
                        try{
                            resp= nioRead(clientChannel);
                        }catch (IOException | LOLDIDNTREAD | Discntcd e){
                            resp = null;
                            if(e instanceof Discntcd){
                                clientChannel.close();
                            }
                        }
                        if(resp==null){
                            serverMessage = resp.getMessages().get(0);
                        }

                    }

                }


                //
                CollectionManager.getWasExecuted().clear();

                try {
                    serverMessage = recieve(socket).getMessages().get(0);
                }catch (IOException e){



                }
                if(!serverMessage.isEmpty()){
                    send(socket,new Command().commandReader(serverMessage).calling());
                }
            }
            inizializeSokets();

        }catch (IOException  e){
            e.printStackTrace();
        }

    }


    }