package org.rahulshettyacademy.TestUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.rahulshettyacademy.PageObjects.FormPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class AndroidBaseTest {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    public FormPage formPage;

    @BeforeClass
    public void configureAppium() throws MalformedURLException, URISyntaxException {
        // code to start server
        service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\TSC\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("SiddheshPixel9a");
        options.setPlatformName("android");
        options.setApp(System.getProperty("user.dir") + "//src//test//java//org//rahulshettyacademy//resources//General-Store.apk");
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        formPage = new FormPage(driver);
    }

    @AfterClass
    public void tearDown() {

        if(driver != null){
            driver.quit();
        }
        if(service != null){
            service.stop();
        }

    }
}