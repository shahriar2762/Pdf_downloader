package pdf_downloader;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

// page_url = https://intellipaat.com/blog/tutorial/selenium-tutorial/selenium-cheat-sheet/
public class PdfDownloaderPage {

    private WebDriver driver;
    private String url;



    public PdfDownloaderPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.url = readConfigFile("config.properties", "url");
    }

    private String readConfigFile(String fileName, String key){
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }

    public void openUrl(){
        driver.get(url);
    }

    public void clickPdf(){
        WebElement pdfLink = driver.findElement(By.linkText("Download a Printable PDF of this Cheat Sheet"));
//        pdfLink.click();

//        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//        WebElement pdfLink = driver.findElement(By.linkText("Download a Printable PDF of this Cheat Sheet"));
//        driver.get("https://intellipaat.com/blog/wp-content/uploads/2022/10/Selenium-Cheat-Sheet-2022.pdf");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        WebElement download_link = driver.findElement(By.xpath("//a[contains(@href,'https://intellipaat.com/blog/wp-content/uploads/2022/10/Selenium-Cheat-Sheet-2022.pdf')]"));
//        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        String script = "arguments[0].setAttribute('download','');";
        ((JavascriptExecutor)driver).executeScript(script, download_link);


//        pdf.click();
        download_link.click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//        pdfLink.click();

    }

//    public void downloadPdf(){
//        WebElement downloadIcon = driver.findElement(By.id("//*[@id=\"icon\"]/iron-icon"));
//        downloadIcon.click();
//    }

    public boolean pdfDownloaded(String filePath){
        File file = new File(filePath);
        return file.exists();
    }


}