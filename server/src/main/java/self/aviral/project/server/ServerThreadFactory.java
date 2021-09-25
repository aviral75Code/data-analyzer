package self.aviral.project.server;

import self.aviral.project.cmd.CmdParser;
import self.aviral.project.cmd.IParameterProvider;

import java.io.IOException;

public class ServerThreadFactory implements  IServerThreadFactory{

    // Default port
    private static final int DEFAULT_SERVER_PORT = 15378;
    // Default maximum number of clients
    private static final int DEFAULT_MAX_CLIENTS = 3;
    // Default waiting queue size
    private static final int DEFAULT_WAITING_QUEUE_SIZE = 1;

    @Override
    public IServerThread getServerThread(IParameterProvider parameters) throws IOException {
        final int port = parameters.getInteger(CmdParser.PORT, DEFAULT_SERVER_PORT);
        final int maxClients = parameters.getInteger(CmdParser.CLIENTS, DEFAULT_MAX_CLIENTS);
        final int waitingQueueSize = parameters.getInteger(CmdParser.MAX_WAITING_QUEUE, DEFAULT_WAITING_QUEUE_SIZE);

        return new ServerThread(port);
    }
}
