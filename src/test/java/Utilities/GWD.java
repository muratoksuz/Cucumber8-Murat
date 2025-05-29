package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Locale;

public class GWD {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>();

    public static WebDriver getDriver() {
        //threadDriver.get() - > bulunduğum thread deki driver ı al
        //threadDriver.set() - > bulunduğum thread de driver set et

        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");


        if (threadDriver.get() == null) {
            threadBrowserName.set("chrome");

            switch (threadBrowserName.get()){
                case "edge" : threadDriver.set(new EdgeDriver());
                case "firefox" : threadDriver.set(new FirefoxDriver());
                default: threadDriver.set(new ChromeDriver());
            }

            threadDriver.get().manage().window().maximize();
            threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        }
        return threadDriver.get();
    }

    public static void quitDriver() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (threadDriver.get() != null) {
            threadDriver.get().quit();
            WebDriver driver = threadDriver.get();
            driver = null;
            threadDriver.set(driver);
        }
    }

}
