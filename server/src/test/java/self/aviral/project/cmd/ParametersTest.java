package self.aviral.project.cmd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParametersTest {
    private static final String[] PARAMETERS = {
            "-port=6298", "-clients=5", "-max_waiting_queue=5", "name=test"
    };
    private IParameterProvider parameterProvider;

    @Before
    public void setUp() throws Exception {
        parameterProvider = new CmdParser(PARAMETERS);
    }

    @Test
    public void getStringTest() {
        final String key = "name";
        final String name = "test";
        assertEquals("Error, server name value mismatch.", name, parameterProvider.getString(key));
    }

    @Test
    public void getStringNegativeTest() {
        final String key = "unknown";
        final String value = CmdParser.DEFAULT_STRING;
        assertEquals("Error, wrongly defined default value.", value, parameterProvider.getString(key));
    }

    @Test
    public void getIntegerTest() {
        final String key = "port";
        final int value = 6298;
        assertEquals("Error, port value mismatch.", value, parameterProvider.getInteger(key));
    }

    @Test
    public void getIntegerNegativeTest() {
        final String key = "unknown";
        final int value = CmdParser.DEFAULT_INTEGER;
        assertEquals("Error, wrongly defined default value.", value, parameterProvider.getInteger(key));
    }
}
