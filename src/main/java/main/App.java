
package main;

import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;

import static utilites.ObjectConverter.readAndUpdate;
import static utilites.ServerMessaging.recieve;
import static utilites.ServerMessaging.send;

public class App {
    private static ServerSocket serverSocket;
    private static Socket socket;

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
            while ((socket.isBound())) {
                CollectionManager.getWasExecuted().clear();
                String serverMessage = "";
                try {
                    serverMessage = recieve(socket).getMessages().get(0);
                }catch (IOException e){



                }
                if(!serverMessage.isEmpty()){
                    send(socket,new Command().commandReader(serverMessage).calling());
                }
            }
            inizializeSokets();

        }catch (IOException e){
            e.printStackTrace();
        }

    }


    }