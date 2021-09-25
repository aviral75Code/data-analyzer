package self.aviral.project.cmd;

import com.google.inject.Singleton;

@Singleton
public class ParameterFactory implements IParameterFactory {

    @Override
    public IParameterProvider getParameters(String[] args) {
        return new CmdParser(args);
    }
}