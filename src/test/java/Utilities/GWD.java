package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
                default:

                    if (isRunningOnJenkins()) {
                        // madem jenkins de çalışıyorsun max boyutta ve başlıksız çalış
                        //Jenkins için Chrome memory maximize edildi ve hafızada çalışır hale getirildi
                        ChromeOptions ChromeOptions = new ChromeOptions();
                        ChromeOptions.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu", "--window-size=1400,2400");

                        threadDriver.set(new ChromeDriver(ChromeOptions));
                    }
                    else
                    {
                        threadDriver.set(new ChromeDriver());// bu thread e bir chrome oluştur ve set et
                    }
            }

            threadDriver.get().manage().window().maximize();
            threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        }
        return threadDriver.get();
    }

    public static boolean isRunningOnJenkins() {
        String jenkinsHome = System.getenv("JENKINS_HOME");
        return jenkinsHome != null && !jenkinsHome.isEmpty();
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
