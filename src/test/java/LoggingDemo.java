import org.apache.log4j.Logger;

public class LoggingDemo{
	
	final static Logger logger = Logger.getLogger(LoggingDemo.class);
	
	public static void main(String[] args) {
	
		LoggingDemo obj = new LoggingDemo();
		obj.runMe("mkyong");
		
	}
	
	private void runMe(String parameter){
		
		if(logger.isDebugEnabled()){
			logger.debug("This is debug : " + parameter);
		}
		
		if(logger.isInfoEnabled()){
			logger.info("This is info : " + parameter);
		}
		
		logger.warn("This is warn : " + parameter);
		logger.error("This is error : " + parameter);
		logger.fatal("This is fatal : " + parameter);
		
	}
	
}