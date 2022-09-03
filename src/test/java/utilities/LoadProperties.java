package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

    public static void loadProperties() throws IOException {
       try {
           FileReader read = new FileReader("C:\\Users\\AES Tech\\IdeaProjects" +
                   "\\CucumberPractice\\src\\test\\java\\utilities\\userProperty.properties");
           Properties properties = new Properties();
           properties.load(read);
           Constant.APP_URL = properties.getProperty("APP_URL");
           Constant.userName = properties.getProperty("userName");
           Constant.passWord = properties.getProperty("passWord");
       }catch (Exception e){
           e.printStackTrace();
       }

    }
}
