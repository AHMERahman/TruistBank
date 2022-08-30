package reporting;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.Reporter;

public class Loggers { 
	
	private static final Logger logger =Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public static void obtainLog(String msgs) {
		// Java console log
		logger.log(Level.INFO, msgs);
		
		//TestNG reporter log
		Reporter.log(msgs+"<br>"); 
		
	}
	
	
}
