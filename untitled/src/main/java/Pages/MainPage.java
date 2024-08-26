package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class MainPage extends BaseLibrary {
    @Step("Site Check")
    public MainPage siteCheck() throws InterruptedException {
        String value = webDriver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[7]/a")).getText();
        screenshot();
        Assert.assertEquals("Writer Panel", value);
        return this;
    }
}
