package main;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import static main.App.log;
import static main.Server.requests;
import static utilites.AccessingAllClassesInPackage.getAllClasses;
import static utilites.ServerMessaging.nioSend;

public class Sender extends Thread {
    Server server;

    public Sender(Server server) {
        this.server = server;
    }

    @Override
    public void run() {
        while (true) {
            Request request;
            try {
                request = requests.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (request != null) {
                if (request.getMessages().get(0).equals("commands") && server.client.firstMessageFromClient) {
                    this.server.client.firstMessageFromClient = false;
                    StringBuilder sb = new StringBuilder();
                    getAllClasses("commands").stream().
                            filter(w ->
                                    Arrays.stream(w.getFields()).anyMatch(
                                            x -> (x.getName().equals("commandType"))) &&
                                            Arrays.stream(w.getFields()).anyMatch(
                                                    y -> y.getName().equals("name"))).
                            forEach(w -> {
                                try {
                                    sb.append(w.getField("name").get(w.getConstructor().newInstance())).append(",").append(w.getField("commandType").get(w.getConstructor().newInstance()).toString()).append(";");
                                } catch (IllegalAccessException | NoSuchFieldException |
                                         NoSuchMethodException |
                                         InstantiationException |
                                         InvocationTargetException e) {
                                    throw new RuntimeException(e);
                                }
                            });

                    try {
                        nioSend(this.server.getClientChannel(), sb.toString());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                } else {
                    request.commandToExecute = request.commandToExecute.revalidate(request.getMessages().get(0));

                    try {
                        Thread.sleep(10000);
                        nioSend(this.server.getClientChannel(), request.getCommandToExecute().calling(request.commandToExecute.getArgs(), request.getCommandToExecute().getValue()));
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }

            } else {
                log.info("null");
            }
        }
    }
}
