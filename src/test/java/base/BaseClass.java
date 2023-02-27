package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utilities.ReadConfig;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();

    public String baseURL = readConfig.getApplicationURL();
    WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String br) {
        if (br.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
            driver = new ChromeDriver();
        } else if (br.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", readConfig.getChromePath());
            driver = new FirefoxDriver();
        }
        try {
            driver.manage().window().maximize();
            driver.get(baseURL);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
//    public void setup() {
//        if (System.getProperty("browser").equalsIgnoreCase("Chrome")) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        } else if (System.getProperty("browser").equalsIgnoreCase("Firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//        }
//        driver.manage().window().maximize();
//        driver.get(System.getProperty("url"));
//        driver.get("https://www.google.com/");
//        driver.manage().window().maximize();
//    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
