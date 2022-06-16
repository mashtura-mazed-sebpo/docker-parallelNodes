import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class doc_test2 {
    public static void main (String args[]) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
       // chromeOptions.addArguments("start-maximized");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName(String.valueOf(Browser.CHROME));
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        URL remote = null;
        try {
            remote = new URL("http://localhost:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println("R: "+remote);
        WebDriver driver = new RemoteWebDriver(remote, desiredCapabilities);
        System.out.println("<........GOT THE DRIVER........>");
        Thread.sleep(15000);
        driver.get("https://pmis1.sebpo.net/");
        Thread.sleep(15000);
        String title = driver.getTitle();//the output should be the head
        System.out.println(title);
        driver.quit();
    }
}
