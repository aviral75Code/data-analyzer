package self.aviral.project.cmd;

public interface IParameterFactory {

    IParameterProvider getParameters(String[] args);
}
