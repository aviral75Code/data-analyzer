package self.aviral.project;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import self.aviral.project.cmd.CmdParser;
import self.aviral.project.cmd.IParameterFactory;
import self.aviral.project.cmd.IParameterProvider;
import self.aviral.project.server.IServerThread;
import self.aviral.project.server.IServerThreadFactory;

import java.io.IOException;
import java.util.Scanner;

public class Server {

    private final IParameterFactory parameterFactory;

    private final IServerThreadFactory serverThreadFactory;

    @Inject
    public Server(IParameterFactory parameterFactory, IServerThreadFactory serverThreadFactory) {
        this.parameterFactory = parameterFactory;
        this.serverThreadFactory = serverThreadFactory;
    }


    private void run(String[]args) throws IOException {
        final IParameterProvider parameters = parameterFactory.getParameters(args);
        final IServerThread serverThread = serverThreadFactory.getServerThread(parameters);
        serverThread.start();
        Scanner scanner = new Scanner(String.valueOf(args));
        while(true) {
            final String input = scanner.nextLine();
            if ("exit".equals(input)) {
                break;
            }
        }
        serverThread.shutdown();
    }

    public static void main(String[] args) throws Exception {
        final Injector injector = Guice.createInjector(new ServerModule());
        Server server = injector.getInstance(Server.class);
        server.run(args);
    }
}
