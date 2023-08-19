package pour.test;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.*;

class ReplaceSystemOutTest {

    @Test
    void test_doSomething(){

        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(byteArray);

        ReplaceSystemOut system = new ReplaceSystemOut(out);

        system.doSomething();

        assertThat(byteArray.toString(UTF_8)).isEqualTo("Hello world !!!\r\n");

    }
}
