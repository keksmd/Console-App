package main;

import exceptions.LOLDIDNTREAD;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;

import static main.App.log;
import static utilites.ServerMessaging.nioRead;


public class Server {
    static final LinkedBlockingDeque<Request> requests = new LinkedBlockingDeque<Request>(100);
    private static boolean flag = true;
    Selector selector;
    ServerSocketChannel serverSocketChannel;
    //SocketChannel clientChannel;
    Client client;

    public Server(int port) {
        try {
            log.info("Программа запущенна");
            this.serverSocketChannel = ServerSocketChannel.open();
            this.serverSocketChannel.bind(new InetSocketAddress(port));
            this.serverSocketChannel.configureBlocking(false);
            this.selector = Selector.open();
            this.serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            log.info("Сервер настроен");
        } catch (IOException e) {
            log.error("Cервер не настроен", e);
            throw new RuntimeException(e);
        }
    }

    public Selector getSelector() {
        return selector;
    }

    public void setSelector(Selector selector) {
        this.selector = selector;
    }

    public void run() throws IOException {

        while (true) {//true
            log.info("Новый шаг бесконечного цикла по селектору");

            this.getSelector().select();
            log.info("мощность итератора = {}", getSelector().selectedKeys().size());
            Iterator<SelectionKey> keysIterator = this.getSelector().selectedKeys().iterator();

            try {
                while (keysIterator.hasNext()) {
                    log.info("взяли ключ");
                    SelectionKey key = keysIterator.next();

                    if (key.isAcceptable()) {

                        log.info("ключ оказался доступным");
                        this.setClientChannel(this.getServerSocketChannel().accept());
                        this.client.channel.configureBlocking(false);
                        this.getClientChannel().register(this.getSelector(), SelectionKey.OP_READ);
                        log.info("Зарегали на селектор с read");
                        new Sender(this).start();
                    }
                    if (key.isReadable()) {
                        Request request = null;
                        log.info("ключ оказался читаемым");
                        try {
                            request = nioRead(this.getClientChannel());

                        } catch (IOException | LOLDIDNTREAD e) {
                            if (e instanceof LOLDIDNTREAD) {
                                try {
                                    this.getClientChannel().close();
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                            log.error("непрочитали(", e);
                        }
                        if (request != null) {
                            requests.add(request);

                                /*try {
                                    this.getClientChannel().register(this.getSelector(), SelectionKey.OP_WRITE, SelectionKey.OP_READ);
                                } catch (ClosedChannelException e) {
                                    throw new RuntimeException(e);
                                }*/
                        }
                    }
                    if (key.isWritable()) {

                        log.info("ключ оказался писаемым");

                        //this.getClientChannel().register(this.getSelector(), SelectionKey.OP_READ);


                    }

                    keysIterator.remove();
                }
            } catch (Exception e) {
                log.error("ошибка,сервер чуть не лег", e);
            }
        }

    }

    public ServerSocketChannel getServerSocketChannel() {
        return serverSocketChannel;
    }

    public void setServerSocketChannel(ServerSocketChannel serverSocketChannel) {
        this.serverSocketChannel = serverSocketChannel;
    }

    public SocketChannel getClientChannel() {
        return this.client.channel;
    }

    public void setClientChannel(SocketChannel clientChannel) {
        this.client = new Client(clientChannel);
    }


}
