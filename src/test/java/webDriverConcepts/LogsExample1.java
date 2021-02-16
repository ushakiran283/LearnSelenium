package webDriverConcepts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogsExample1 {

	static WebDriver driver;

	private static Logger log = LogManager.getLogger(LogsExample1.class.getName());

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		log.error("object is not present");
		log.fatal("this is fatal");
		log.info("log is present");
		log.debug("I am debugging");
	}

}
