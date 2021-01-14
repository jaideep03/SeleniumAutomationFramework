package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApacheLog4j {
	
	static Logger logger = LogManager.getLogger(ApacheLog4j.class);
	
	public static void main(String[] args) {

		System.out.println("START");
		logger.trace("Logger trace message");
		logger.info("Logger Info message");
		logger.error("Logger error message");
		logger.warn("Logger warn message");
		logger.fatal("Logger fatal message");
		System.out.println("END");

	}

}
