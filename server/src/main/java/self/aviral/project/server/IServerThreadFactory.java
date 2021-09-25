package self.aviral.project.server;

import self.aviral.project.cmd.IParameterProvider;

import java.io.IOException;

public interface IServerThreadFactory {

    IServerThread getServerThread(IParameterProvider parameters) throws IOException;
}
