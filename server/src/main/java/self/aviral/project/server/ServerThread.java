package self.aviral.project.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ServerThread extends Thread implements IServerThread{

    private static final int SOCKET_TIMEOUT = 5000;
    private final int port;
    private boolean running = false;

    ServerThread(int port) throws IOException {
        super("ServerThread");
        this.port = port;
    }

    @Override
    public void shutdown() {
        running = false;
        try {
            join();
        } catch (InterruptedException ignored) {}
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setSoTimeout(SOCKET_TIMEOUT);
            while (running) {
                try {
                    final Socket socket = serverSocket.accept();
                } catch (SocketTimeoutException ignored) {}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
