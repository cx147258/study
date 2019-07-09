package LogTest;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogTest {
    public static Log log = LogFactory.getLog(LogTest.class);
    public static void test(){
        log.debug("debug");
        log.info("info:1111111111111111");
        log.warn("warn");
        log.error("error");
    }
    public static void main(String args[]){
        test();
    }
}
