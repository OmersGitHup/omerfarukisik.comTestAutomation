package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BaseLibrary{
    @BeforeMethod
    public void browserOpen(){
        webDriver=new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(url);

    }

    @AfterMethod
    public void browserShutter(){
        webDriver.quit();
    }

}
