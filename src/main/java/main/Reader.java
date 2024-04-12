package main;

import exceptions.LOLDIDNTREAD;

import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;

import static main.App.log;
import static main.Server.requests;
import static utilites.ServerMessaging.nioRead;

public class Reader implements Runnable {
    Server server;

    public Reader(Server s) {
        this.server = s;
    }


    @Override
    public void run() {
        Request request = null;
        try {
            request = nioRead(this.server.getClientChannel());

        } catch (IOException | LOLDIDNTREAD e) {
            if (e instanceof LOLDIDNTREAD) {
                try {
                    this.server.getClientChannel().close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            log.error("непрочитали(", e);
        }
        if (request != null) {
            requests.add(request);

            try {
                this.server.getClientChannel().register(this.server.getSelector(), SelectionKey.OP_WRITE);
            } catch (ClosedChannelException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
