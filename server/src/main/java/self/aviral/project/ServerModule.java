package self.aviral.project;

import self.aviral.project.cmd.IParameterFactory;
import self.aviral.project.cmd.ParameterFactory;
import com.google.inject.AbstractModule;
import self.aviral.project.server.IServerThreadFactory;
import self.aviral.project.server.ServerThreadFactory;

public class ServerModule extends AbstractModule {

        @Override
        public void configure() {
            bind(IParameterFactory.class).to(ParameterFactory.class);
            bind(IServerThreadFactory.class).to(ServerThreadFactory.class);
        }
    }
