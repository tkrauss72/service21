package net.tk;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws Exception {
        final Service service = new Service();

        int port = Integer.parseInt(args[1]);
        HttpServer server = HttpServer.create(new InetSocketAddress(args[0], port), port);
        server.createContext("/service21", new HttpHandler() {
            public void handle(HttpExchange t) throws IOException {
                String response = service.serve(t.getRequestURI().getQuery());
                t.sendResponseHeaders(200, response.length());
                OutputStream os = t.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });
        server.start();
    }
}
