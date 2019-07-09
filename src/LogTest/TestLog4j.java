package LogTest;

import com.sun.istack.internal.logging.Logger;

public class TestLog4j {
    static Logger logger = Logger.getLogger(TestLog4j.class);
    public static void main(String args[]){
      logger.info("111111111111111");
    }
}
