import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class test4 {
    public static void main (String args[]) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName(String.valueOf(Browser.CHROME));
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        WebDriver driver=null;
        URL remote = null;
        try {
            remote = new URL("http://localhost:4444/wd/hub");
            System.out.println("R: " + remote);
            driver = new RemoteWebDriver(remote, desiredCapabilities);
            Thread.sleep(15000);
            driver.get("https://github.com/mashtura-mazed-sebpo");
            Thread.sleep(15000);
            String title = driver.getTitle();//the output should be the head
            System.out.println(title);
            // driver.quit();
        }catch (MalformedURLException e) {
            driver.quit();
            e.printStackTrace();
        }
        System.out.println("<........GOT THE DRIVER........>");

    }
}