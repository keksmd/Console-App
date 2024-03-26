package main;

import exceptions.Discntcd;
import exceptions.LOLDIDNTREAD;
import utilites.CheckingReader;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import static main.App.log;
import static utilites.ServerMessaging.nioRead;
import static utilites.ServerMessaging.nioSend;


public class Server {
    Selector selector;
     ServerSocketChannel serverSocketChannel;
     SocketChannel clientChannel;

    public Selector getSelector() {
        return selector;
    }

    public Server(int port){
        try {
            log.info("Программа запущенна");
            this.serverSocketChannel = ServerSocketChannel.open();
            this.serverSocketChannel.bind(new InetSocketAddress(port));
            this.serverSocketChannel.configureBlocking(false);
            this.selector = Selector.open();
            this.serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            log.info("Сервер настроен");
        } catch (IOException e) {
            log.error("Cервер не настроен",e);
            throw new RuntimeException(e);
        }
    }

    public void setSelector(Selector selector) {
        this.selector = selector;
    }
    public void  run() throws IOException {
        while (true) {//true
            log.info("Вошли в бесконечный цикл");
            CollectionManager.getWasExecuted().clear();

            this.getSelector().select();
            log.info("прошли selector");
            Iterator<SelectionKey> keysIterator= this.getSelector().selectedKeys().iterator();
            while (keysIterator.hasNext()){
                log.info("взяли ключ");
                SelectionKey key = keysIterator.next();

                Request request ;
                if(key.isAcceptable()){
                    log.info("ключ оказался доступным");
                    this.setClientChannel(this.getServerSocketChannel().accept());
                    this.clientChannel.configureBlocking(false);

                    this.getClientChannel().register(this.getSelector(), SelectionKey.OP_READ);
                    log.info("Зарегали на селектор с read");

                }
                String serverMessage = "";
                if(key.isReadable()){
                    log.info("ключ оказался читаемым");
                    try{
                        request= nioRead(this.getClientChannel());
                    }catch (IOException | LOLDIDNTREAD | Discntcd e){
                        request = null;
                        if(e instanceof LOLDIDNTREAD){
                            this.getClientChannel().close();
                        }
                        log.error("непрочитали(",e);

                    }
                    if(request!=null){
                        log.info("прочитали {}",request.getMessages());
                        serverMessage = request.getMessages().get(0);
                    }else{
                        log.info("null" );
                    }
                    if(!serverMessage.isEmpty()){
                        log.info(serverMessage);
                        request.getCommandToExecute().calling();
                        nioSend(this.getClientChannel(),new Command().commandReader(serverMessage).calling());
                    }

                }
                log.info("key - if закончился");

                keysIterator.remove();

            }
            log.info("итератор закончился");
        }
    }

    public ServerSocketChannel getServerSocketChannel() {
        return serverSocketChannel;
    }

    public void setServerSocketChannel(ServerSocketChannel serverSocketChannel) {
        this.serverSocketChannel = serverSocketChannel;
    }

    public SocketChannel getClientChannel() {
        return clientChannel;
    }

    public void setClientChannel(SocketChannel clientChannel) {
        this.clientChannel = clientChannel;
    }

    public SocketChannel getSocketChannel() {
        return this.clientChannel;
    }
}
