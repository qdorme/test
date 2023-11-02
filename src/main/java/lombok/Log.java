package lombok;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Log4j2
public class Log {

    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        Log log = new Log();
        log.run();
    }

    private void run() {

        String toto = null;
        log.error("Toto : {}", toto);
        logger.error("Toto : {} v2", toto);


    }

}
