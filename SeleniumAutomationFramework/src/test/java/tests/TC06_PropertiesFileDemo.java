package tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class TC06_PropertiesFileDemo {

	static Properties prop = new Properties();
	static String projectPath = System.getProperty("user.dir"); //Fetching the Project Path

	public static void main(String[] args) throws IOException {
		getProperties();
		setProperties();
		getProperties();
	}

	public static void getProperties() {

		try {
			InputStream input = new FileInputStream(projectPath+"/src/test/java/config/config.properties");
			prop.load(input);
			String browser = prop.getProperty("browser");
			System.out.println(browser);
			TC07_PropertiesFile_Log4j_TestNG_ExtentReport.browsername = browser;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}

	}

	public static void setProperties() {

		try {
			OutputStream output = new FileOutputStream(projectPath+"/src/test/java/config/config.properties");
			prop.setProperty("browser", "chrome");
			prop.store(output, null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
}
