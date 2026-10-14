package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("C:\\Users\\gudde_g0nggde\\.eclipse\\AutomationFrameWork\\src\\java\\resources\\configfiles\\config.properties");
		
		Properties p = new Properties();
		p.load(fr);
		
		System.out.println(p.getProperty("browser")); 
		System.out.println(p.getProperty("testUrl"));
	}

}
